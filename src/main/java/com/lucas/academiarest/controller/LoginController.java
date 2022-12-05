package com.lucas.academiarest.controller;

import com.lucas.academiarest.model.view.Login;
import com.lucas.academiarest.model.view.Session;
import com.lucas.academiarest.security.JWTCreator;
import com.lucas.academiarest.security.JWTObject;
import com.lucas.academiarest.security.SecurityConfig;
import com.lucas.academiarest.security.model.User;
import com.lucas.academiarest.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.util.Date;

@RestController
public class LoginController {
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository repository;

    @PostMapping("/login")
    public Session login(@RequestBody Login login) {
        User user = repository.findByUsername(login.getUsername());
        if(user != null) {
            boolean isAuthenticated = encoder.matches(login.getPassword(),user.getPassword());
            if (!isAuthenticated) {
                // TODO: This line must be repleaced to a correct error handling
                return new Session();
                //throw new RuntimeException("Invalid password at login :" + login.getUsername());
            }

            Session session = new Session();
            session.setLogin(user.getUsername());

            JWTObject jwtObject = new JWTObject();
            jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
            jwtObject.setExpiration(new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION));
            jwtObject.setRoles(user.getRoles());
            session.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));

            return session;
        } else {
            // TODO: This line must be repleaced to a correct error handling
            return new Session();
            //throw new RuntimeException("Invalid username");
        }
    }
}
