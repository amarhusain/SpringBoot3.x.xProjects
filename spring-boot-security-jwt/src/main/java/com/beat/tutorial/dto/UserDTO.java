package com.beat.tutorial.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String roles;


}

