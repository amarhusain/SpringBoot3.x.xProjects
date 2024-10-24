package com.beat.tutorial.security;

import com.beat.tutorial.entity.Role;
import com.beat.tutorial.entity.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

  private String username;
  private String password;
  private List<GrantedAuthority> authorities;

  public CustomUserDetails(User userInfo) {
    username=userInfo.getUsername();
    password=userInfo.getPassword();
    List<GrantedAuthority> auths = new ArrayList<>();

    for(Role role : userInfo.getRoles()){

      auths.add(new SimpleGrantedAuthority(role.getRole().getValue()));
    }
    this.authorities = auths;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}
