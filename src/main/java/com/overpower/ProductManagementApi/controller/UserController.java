package com.overpower.ProductManagementApi.controller;

import com.overpower.ProductManagementApi.models.User;
import com.overpower.ProductManagementApi.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("")
    public User createUser(@RequestBody User user){
        User newuser = new User(user);
        return userService.saveUser(newuser);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") String id){
        return userService.getUserById(id);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") String id, @RequestBody User user){
        return userService.updateUser(id,user);
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") String id){
        return userService.deleteUser(id);
    }
}
