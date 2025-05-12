package org.example.ebooky_new_project.service;

import org.example.ebooky_new_project.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> saveUser(User user);
    Optional<User> loginUser(String email, String password);
    Optional<User> updateUser(User user);
    boolean deleteUser(int id);
}
