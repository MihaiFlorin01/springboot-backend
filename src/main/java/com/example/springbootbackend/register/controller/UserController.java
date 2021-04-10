package com.example.springbootbackend.register.controller;

import com.example.springbootbackend.register.model.User;
import com.example.springbootbackend.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public User userRegistration(@RequestBody User user) {
        Optional<User> user2 = userService.findByEmail(user.getEmail());
        if (user2.isPresent()) {
            if (user.getEmail().equals(user2.get().getEmail())) {
                user2.get().setFirstName(user.getFirstName());
                user2.get().setLastName(user.getLastName());
                user2.get().setEmail(user.getEmail());
                user2.get().setPassword(user.getPassword());
                return userService.save(user2.get());
            }
        }
        return userService.save(user);

    }

}
