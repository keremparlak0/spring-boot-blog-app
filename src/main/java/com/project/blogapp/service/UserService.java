package com.project.blogapp.service;

import com.project.blogapp.entity.User;
import com.project.blogapp.exception.CustomDataIntegrityException;
import com.project.blogapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        try {
            return userRepository.save(user);
        }
        catch (DataIntegrityViolationException e){
            throw new CustomDataIntegrityException("Data integrity violation occurred. Probably this username already exists. ", e);
        }
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    public User updateUserById(Long userId, User user) {
        Optional<User> userById = userRepository.findById(userId);
        if (userById.isPresent()) {
            User foundUser = userById.get();
            foundUser.setUserName(user.getUserName());
            foundUser.setPassword(user.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        } else {
            return null;
        }
    }

    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

}
