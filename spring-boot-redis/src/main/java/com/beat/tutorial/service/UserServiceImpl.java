package com.beat.tutorial.service;

import com.beat.tutorial.entity.User;
import com.beat.tutorial.exception.UserAlreadyExistsException;
import com.beat.tutorial.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        String username = user.getUsername().replace(" ", "");
        User existingUser = userRepository.findByUsername(username);
        if (existingUser != null) {
            throw new UserAlreadyExistsException("Username " + username + " already exists.");
        }
        user.setUsername(username);
        return userRepository.save(user);
    }


}
