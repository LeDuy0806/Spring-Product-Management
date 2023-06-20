package com.overpower.ProductManagementApi.services;


import com.overpower.ProductManagementApi.exception.CustomException;
import com.overpower.ProductManagementApi.models.User;
import com.overpower.ProductManagementApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById(String id) {
//      log.info("User found in database: {}", result);
        return userRepository.findById(id).orElseThrow(
                ()-> new CustomException("User not found",
                        404,
                        "CUSTOM_ERROR",
                        LocalDateTime.now()));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
//        System.out.println("Saving new user {} to the db "+ user.getUserName());
        return userRepository.save(user);
    }

    public User updateUser(String id, User user) {
        userRepository.findById(id).orElseThrow(
                ()-> new CustomException("User not found",
                        404,
                        "CUSTOM_ERROR",
                        LocalDateTime.now()));;
        user.setId(id);
        return userRepository.save(user);
    }

    public String deleteUser(String id) {
        userRepository.findById(id).orElseThrow(
                ()-> new CustomException("User not found",
                        404,
                        "CUSTOM_ERROR",
                        LocalDateTime.now()));;

        userRepository.deleteById(id);
        return String.format("User with id %s has been deleted", id);
    }

    public List<User> getUserByRole(List<String> roles) {
        return userRepository.findByRoleIn(roles);
    }
}
