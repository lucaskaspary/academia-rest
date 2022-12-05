package com.lucas.academiarest.init;

import com.lucas.academiarest.security.model.User;
import com.lucas.academiarest.security.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartApplication implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        // TODO: This code adds a basic user to access the REST API
        User user = repository.findByUsername("admin");
        if (user == null) {
            user = new User();
            user.setName("ADMIN");
            user.setUsername("admin");
            user.setPassword("admin");
            user.getRoles().add("ADMIN");
            user.setGymAccessPassword("1234");
            repository.save(user);
        }
    }
}
