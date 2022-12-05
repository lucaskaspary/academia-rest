package com.lucas.academiarest.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JWTObject {
    // User name
    private String subject;

    // Creation date
    private Date issuedAt;

    // Expiration date
    private Date expiration;

    // Access profiles
    private List<String> roles;

    public void setRoles(String... roles) {
        this.roles = Arrays.asList(roles);
    }
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
