package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.entity.User;
import com.example.studentmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    // Register User
    public User register(User user) {
        return repository.save(user);
    }

    // Get All Users
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    // Find User by Username
    public User findByUsername(String username) {
        return repository.findByUsername(username).orElse(null);
    }
}