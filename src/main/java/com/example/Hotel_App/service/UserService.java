package com.example.Hotel_App.service;

import com.example.Hotel_App.dto.request.UpdateUsernameRequest;
import com.example.Hotel_App.dto.request.UserCreationRequest;
import com.example.Hotel_App.dto.response.TestResponse;
import com.example.Hotel_App.entity.User;
import com.example.Hotel_App.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request){
        User user = new User();
        if(userRepository.existsByUsername(request.getUsername()))
            throw new RuntimeException("Username đã tồn tại");
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());

        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public List<TestResponse> getUsersname(){
        return userRepository.findAll().stream().map(user -> {
            TestResponse res = new TestResponse();
            res.setUsername(user.getUsername());
            return res;
        }).collect(Collectors.toList());
    }

    public User updateUser(UpdateUsernameRequest request){
        Optional<User> userOptional = userRepository.findById(request.getId());
        if(userOptional.isPresent()){
            User user = userOptional.get();
            if(userRepository.existsByUsername(request.getUsername())){
                throw new RuntimeException("username này đã tồn tại");
            }else {
                user.setUsername(request.getUsername());
                return userRepository.save(user);
            }
        }else {
            throw new RuntimeException("user này không tồn tại");
        }
    }
}
