package com.beat.tutorial.controller;

import com.beat.tutorial.entity.User;
import com.beat.tutorial.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@Tag(name = "API for managing users", description="")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    // APi 1
    @PostMapping("/create")
    @Operation(summary = "Creates user", description = "Returns created user")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

}
