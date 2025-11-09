package com.bookmyshow.bookmyshow.controller;

import com.bookmyshow.bookmyshow.model.User;
import com.bookmyshow.bookmyshow.repository.UserRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping
    public User registerUser(@Valid @RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
