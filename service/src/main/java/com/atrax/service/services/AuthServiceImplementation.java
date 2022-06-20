package com.atrax.service.services;

import com.atrax.service.model.dto.UserLogin;
import com.atrax.service.model.dto.UserPrincipal;
import com.atrax.service.model.dto.UserResponse;
import com.atrax.service.repository.UserRepository;
import com.atrax.service.security.JwtTokenProvider;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.security.InvalidParameterException;

@Service
public class AuthServiceImplementation implements AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserResponse authenticate(UserLogin loginCredentials) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginCredentials.getUsername()
                        , loginCredentials.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);

        return userRepository.findByUsername(loginCredentials.getUsername())
                .map(e -> modelMapper.map(e, UserResponse.class))
                .map(e -> {
                    e.setToken(jwt);
                    return e;
                })
                .orElseThrow(() -> new InvalidParameterException("INCORRECT USERNAME"));
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        return userRepository.findById(id)
                .map(UserPrincipal::create)
                .orElseThrow(() -> new EntityNotFoundException("USER DOES NOT EXISTS"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(UserPrincipal::create)
                .orElseThrow(() -> new EntityNotFoundException("USER DOES NOT EXISTS"));
    }

    @Override
    public void logout() {

    }

}
