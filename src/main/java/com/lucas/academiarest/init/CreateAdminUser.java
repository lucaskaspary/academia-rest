package com.lucas.academiarest.init;

import com.lucas.academiarest.security.model.User;
import com.lucas.academiarest.security.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateAdminUser implements CommandLineRunner {
    @Autowired
    private UserService service;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        User admin = new User();
        admin.setUsername("admin");
        admin.setName("admin");
        admin.setPassword("admin");
        admin.setEmail("admin@admin.com");
        admin.setGymAccessPassword("1234");
        admin.getRoles().add("ADMIN");
        service.createUser(admin);
    }
}
