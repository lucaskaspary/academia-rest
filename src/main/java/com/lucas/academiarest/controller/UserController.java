package com.lucas.academiarest.controller;

import com.lucas.academiarest.security.model.User;
import com.lucas.academiarest.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping
    public void postUser(@RequestBody User user) {
        service.createUser(user);
    }

   @GetMapping
    public List<User> getAll(){
        return service.getAll();
   }


}
