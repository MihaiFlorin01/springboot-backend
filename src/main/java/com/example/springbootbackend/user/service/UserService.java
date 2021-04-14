package com.example.springbootbackend.user.service;

import com.example.springbootbackend.user.model.User;
import com.example.springbootbackend.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public boolean existsByUsernameAndPassword(String username, String password) {
        return userRepository.existsByUsernameAndPassword(username, password);
    }
}
