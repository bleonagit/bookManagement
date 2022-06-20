package com.atrax.service.model.dto;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String name;
    private String lastname;
    private String username;
    private String email;
    private String token;
}
