package com.tech.atm.controller;

import com.tech.atm.dto.UserRequest;
import com.tech.atm.dto.UserResponse;
import com.tech.atm.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> CreateUser(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.CreateUser(userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Integer id)
    {
        UserResponse userResponse = userService.getById(id);

        return new ResponseEntity<>(userResponse,HttpStatus.OK);
    }

    @GetMapping
    public List<UserResponse> getAllUsers()
    {
        return userService.getAllUsers();
    }

}
