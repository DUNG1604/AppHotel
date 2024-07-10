package com.example.Hotel_App.controller;

import com.example.Hotel_App.dto.request.ApiResponse;
import com.example.Hotel_App.dto.request.UpdateUsernameRequest;
import com.example.Hotel_App.dto.request.UserCreationRequest;
import com.example.Hotel_App.dto.response.TestResponse;
import com.example.Hotel_App.entity.User;
import com.example.Hotel_App.repository.UserRepository;
import com.example.Hotel_App.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody UserCreationRequest request){
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));
        return apiResponse;
    }
    @GetMapping
    ApiResponse<List<User>> getUsers(){
        ApiResponse<List<User>> getUsers = new ApiResponse<>();
        getUsers.setResult(userService.getUsers());
        return  getUsers;
    }
    @GetMapping("/usernames")
    List<TestResponse> getUsernames(){
        return userService.getUsersname();
    }

    @PostMapping("/update")
    ApiResponse<User> updateUser(@RequestBody UpdateUsernameRequest request){
        ApiResponse<User> updateUser = new ApiResponse<>();
        updateUser.setResult(userService.updateUser(request));
        return updateUser;
    }
}
