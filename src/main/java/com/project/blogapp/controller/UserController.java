package com.project.blogapp.controller;

import com.project.blogapp.entity.User;
import com.project.blogapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping()
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping()
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    public User updateUserById(@PathVariable Long userId, @RequestBody User user){
        return userService.updateUserById(userId, user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable Long userId){
        userService.deleteUserById(userId);
    }
}
