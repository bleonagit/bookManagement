package com.atrax.controller.rest;

import com.atrax.service.model.dto.UserLogin;
import com.atrax.service.model.dto.UserResponse;
import com.atrax.service.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public UserResponse authenticate(@RequestBody UserLogin user){
        return authService.authenticate(user);
    }

    @GetMapping("/logout")
    public ResponseEntity logout(){
        authService.logout();
        return new ResponseEntity(HttpStatus.OK);
    }
}
