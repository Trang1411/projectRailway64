package com.example.examdemo.service;

import com.example.examdemo.entity.User;
import com.example.examdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User updateUser(User user) {
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if (optionalUser.isPresent()) {
            User user1 = new User(user.getId(), user.getUserName());
            return null;
        }
        User user1 = optionalUser.get();
        user1.setId(user.getId());
        user1.setUserName(user.getUserName());
        return userRepository.save(user);
    }

    @Override
    public User createUser(User user) {
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if (optionalUser.isPresent()) {
            User user1 = new User(user.getId(), user.getUserName());
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(int userId) {
        userRepository.deleteById(userId);
    }
}
