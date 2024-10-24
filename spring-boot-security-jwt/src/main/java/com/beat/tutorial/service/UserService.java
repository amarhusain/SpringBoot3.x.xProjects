package com.beat.tutorial.service;

import com.beat.tutorial.dto.JwtRequest;
import com.beat.tutorial.dto.UserDTO;
import com.beat.tutorial.entity.User;

public interface UserService {
    User createUser(UserDTO userDTO);
    String login(JwtRequest jwtRequest);
    User getUser();
}
