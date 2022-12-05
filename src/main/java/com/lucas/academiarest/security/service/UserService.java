package com.lucas.academiarest.security.service;

import com.lucas.academiarest.security.model.User;
import com.lucas.academiarest.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public void createUser(User user) {
        String pass = user.getPassword();
        user.setPassword(encoder.encode(pass));
        repository.save(user);
    }


    // TODO: This function return must be repleaced to a view to protect the passwords
    public User findUserById(Long id) {
        return repository.findById(id.intValue()).get();
    }

    // TODO: This function return must be repleaced to a view to protect the passwords
    public User findUserByUsername(String username) {
        return repository.findUserByUsername(username);
    }

    // TODO: This function return must be repleaced to a view to protect the passwords
    public User findUserByName(String name) {
        return repository.findUserByName(name);
    }

    // TODO: This function return must be repleaced to a view to protect the passwords
    public List<User> getAll() {
        return repository.findAll();
    }

}
