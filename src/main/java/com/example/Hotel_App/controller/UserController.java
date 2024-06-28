package com.example.Hotel_App.controller;

import com.example.Hotel_App.dto.request.UserCreationRequest;
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

    @PostMapping("/users")
    User createUser(@RequestBody UserCreationRequest request){
        return userService.createUser(request);
    }
    @GetMapping
    List<User> getUsers(){
        return userService.getUsers();
    }

}
