package com.example.CreditScoreAnalysis.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.example.CreditScoreAnalysis.DTO.UserRequest;
import com.example.CreditScoreAnalysis.model.User;
import com.example.CreditScoreAnalysis.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/user-management")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserRequest userRequest) {
        User user = userService.registerUser(
            userRequest.getUsername(),
            userRequest.getPassword(),
            userRequest.getEmail(),
            userRequest.getRole()
        );
        return ResponseEntity.ok(user);
    }
    
    @GetMapping("/user/{username}")
    public ResponseEntity<Optional<User>> getUserByUsername(@PathVariable String username) {
        Optional<User> user = Optional.ofNullable(userService.findUserByUsername(username));
        return ResponseEntity.ok(user);
    }
    
    @Operation(summary = "Returns user with email ")
    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<User>> getUserByEmailId(@PathVariable String email){
    	Optional<User> user = Optional.of(userService.findByEmailId(email));
    	return ResponseEntity.ok(user) ;
    }
}

