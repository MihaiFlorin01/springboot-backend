package com.example.springbootbackend.login.controller;

import com.example.springbootbackend.login.model.User;
import com.example.springbootbackend.login.repository.UserRepository;
import com.example.springbootbackend.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("/login/users")
    public List<User> getUsers() {
        System.out.println(userService.findAll().toString());
        return userService.findAll();
    }

//    @PostMapping("/register")
//    public LoginStatus registerUser(@RequestBody User newUser) {
//        List<User> users = userService.findAll();
//        System.out.println("New user: " + newUser.toString());
//        for (User user : users) {
//            System.out.println("Registered user: " + newUser.toString());
//            if (user.equals(newUser)) {
//                System.out.println("User Already exists!");
//                return LoginStatus.USER_ALREADY_EXISTS;
//            }
//        }
//        userService.save(newUser);
//        return LoginStatus.SUCCESS;
//    }

    @PostMapping("/login")
    public boolean loginUser(@RequestBody User user) {
        User userDB = getUsers().get(0);
//        System.out.println(getUsers().get(0).toString());
        return userDB.getUsername().equals(user.getUsername()) && userDB.getPassword().equals(user.getPassword());
    }

//    @PostMapping("/logout")
//    public LoginStatus logUserOut(@RequestBody User user) {
//        List<User> users = userService.findAll();
//        for (User other : users) {
//            if (other.equals(user)) {
//                user.setLoggedIn(false);
//                userService.save(user);
//                return LoginStatus.SUCCESS;
//            }
//        }
//        return LoginStatus.FAILURE;
//    }

//    @DeleteMapping("/users/all")
//    public LoginStatus deleteUsers() {
//        userService.deleteAll();
//        return LoginStatus.SUCCESS;
//    }

}
