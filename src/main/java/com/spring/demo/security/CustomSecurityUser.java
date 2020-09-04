package com.spring.demo.security;/*
@Author : Yogesh Deshmukh
*/

import com.spring.demo.model.User;
import org.springframework.security.core.userdetails.UserDetails;



public class CustomSecurityUser extends User implements UserDetails {
    private static final long serialVersionUID = 1L;

    public CustomSecurityUser(User user) {
        this.setAuthorities(user.getAuthorities());
        this.setId(user.getId());
        this.setPassword(user.getPassword());
        this.setUsername(user.getUsername());
    }

    public CustomSecurityUser() {
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
