package com.atrax.service.services;

import com.atrax.service.model.dto.UserLogin;
import com.atrax.service.model.dto.UserResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {
    UserResponse authenticate(UserLogin loginCredentials);
    UserDetails loadUserById(Long id);
    UserDetails loadUserByUsername(String s);
    void logout();
}
