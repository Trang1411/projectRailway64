package com.example.examdemo.service;

import com.example.examdemo.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User createUser(User user);
    public User updateUser(User user);
    public void deleteUserById(int userId);
}
