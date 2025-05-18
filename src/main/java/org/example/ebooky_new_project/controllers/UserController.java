package org.example.ebooky_new_project.controllers;

import org.example.ebooky_new_project.dto.LoginRequest;
import org.example.ebooky_new_project.model.User;
import org.example.ebooky_new_project.service.UserService;
import org.example.ebooky_new_project.service.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class UserController {
    private UserService userService;

    public UserController(){
        this.userService = new UserServiceImpl();
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users/register")
    public Optional<User> registerUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("user/login")
    public Optional<User> loginUser(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        return userService.loginUser(email, password);
    }

    @PostMapping("/user/{id}")
    public Optional<User> updateUser(@RequestBody User user, @PathVariable int id) {
        user.setUserId(id);
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }
}
