package com.beat.tutorial.service;

import com.beat.tutorial.dto.JwtRequest;
import com.beat.tutorial.dto.UserDTO;
import com.beat.tutorial.entity.Role;
import com.beat.tutorial.entity.RoleType;
import com.beat.tutorial.entity.User;
import com.beat.tutorial.exception.UserAlreadyExistsException;
import com.beat.tutorial.repository.UserRepository;
import com.beat.tutorial.security.JwtTokenUtil;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AuthenticationProvider authenticationProvider;
    private final JwtTokenUtil jwtTokenUtil;

    public UserServiceImpl(UserRepository userRepository,
        AuthenticationProvider authenticationProvider,
        JwtTokenUtil jwtTokenUtil) {
        this.userRepository = userRepository;
        this.authenticationProvider = authenticationProvider;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public User createUser(UserDTO userDTO) {
        String username = userDTO.getUsername();
        User existingUser = userRepository.findByUsername(username);
        if (existingUser != null) {
            throw new UserAlreadyExistsException("Username " + username + " already exists.");
        }
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setRole(RoleType.USER);
        roles.add(role);
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setFirstname(userDTO.getFirstName());
        user.setLastname(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setRoles(roles);
        return userRepository.save(user);
    }

    @Override
    public String login(JwtRequest jwtRequest) {
        final Authentication authentication = authenticationProvider.authenticate(
            new UsernamePasswordAuthenticationToken(
                jwtRequest.getUsername(),
                jwtRequest.getPassword()
            )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final User user = userRepository.findByUsername(jwtRequest.getUsername());
        return jwtTokenUtil.generateToken(user.getUsername());
    }


    @Override
    public User getUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByUsername(userDetails.getUsername());
    }

}
