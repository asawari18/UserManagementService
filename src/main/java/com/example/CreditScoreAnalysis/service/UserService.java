package com.example.CreditScoreAnalysis.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.CreditScoreAnalysis.exceptionHandling.UserAlreadyExistsException;
import com.example.CreditScoreAnalysis.exceptionHandling.UserNotFoundException;
import com.example.CreditScoreAnalysis.model.User;
import com.example.CreditScoreAnalysis.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private final PasswordEncoder passwordEncoder;
    
    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }			

    public User registerUser(String username, String password, String email, String role) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new UserAlreadyExistsException("Username '" + username + "' already exists.");
        }

        if (userRepository.findByEmail(email).isPresent()) {
            throw new UserAlreadyExistsException("Email '" + email + "' already exists.");
        }

        User user = new User();
        user.setUsername(username);
        user.setPasswordHash(passwordEncoder.encode(password));
        user.setEmail(email);
        user.setRole(role);
        user.setCreatedAt(LocalDateTime.now());
        user.setStatus("ACTIVE");

        return userRepository.save(user);
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User with username '" + username + "' not found."));
    }
    
    public User findByEmailId(String email) {
    	return userRepository.findByEmail(email)
    			.orElseThrow( () -> new UserNotFoundException("user with this email" + email + " not found"));
    }
}
