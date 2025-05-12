package org.example.ebooky_new_project.repository;

import org.example.ebooky_new_project.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getAllUsers();
    User saveUser(User user);

    Optional<User> updateUser(User user);
    boolean deleteUser(int Id);
}
