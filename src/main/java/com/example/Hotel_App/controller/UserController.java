package com.example.Hotel_App.controller;

import com.example.Hotel_App.dto.request.UserCreationRequest;
import com.example.Hotel_App.entity.User;
import com.example.Hotel_App.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    User createUser(@RequestBody UserCreationRequest request){
        return userService.createUser(request);
    }
}
