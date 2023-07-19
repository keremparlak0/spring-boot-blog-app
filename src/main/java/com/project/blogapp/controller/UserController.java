package com.project.blogapp.controller;

import com.project.blogapp.entity.User;
import com.project.blogapp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){

        return  ResponseEntity.status(HttpStatus.CREATED).body(this.userService.createUser(user));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(userId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUserById(@PathVariable Long userId, @RequestBody User user){
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUserById(userId, user));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUserById(@PathVariable Long userId){

        userService.deleteUserById(userId);
        return new ResponseEntity(null,HttpStatus.OK);}
}
