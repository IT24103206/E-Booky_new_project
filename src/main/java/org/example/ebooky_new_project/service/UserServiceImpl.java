package org.example.ebooky_new_project.service;

import org.example.ebooky_new_project.model.User;
import org.example.ebooky_new_project.repository.UserRepository;
import org.example.ebooky_new_project.repository.UserRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(){
        this.userRepository = new UserRepositoryImpl();
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public Optional<User> saveUser(User user) {
        User saveUser = userRepository.saveUser(user);
        if(saveUser != null){
            return Optional.of(saveUser);
        }else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> loginUser(String email, String password) {
        List<User> users = getAllUsers();
        for(User u: users){
            if(u.getEmail().equals(email) && u.getPassword().equals(password)){
                return Optional.of(u);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> updateUser(User user) {
        return userRepository.updateUser(user);
    }

    @Override
    public boolean deleteUser(int id) {
        return userRepository.deleteUser(id);
    }
}
