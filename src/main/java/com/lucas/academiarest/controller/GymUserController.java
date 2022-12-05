package com.lucas.academiarest.controller;

import com.lucas.academiarest.model.Evaluation;
import com.lucas.academiarest.model.forms.GymUserForm;
import com.lucas.academiarest.model.view.GymUserView;
import com.lucas.academiarest.service.impl.GymUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gymUser")
public class GymUserController {
    @Autowired
    GymUserServiceImpl gymUserService;

    @PostMapping
    GymUserView create(@RequestBody GymUserForm form) {
        return gymUserService.create(form);
    }

    @GetMapping
    List<GymUserView> gelAll() {
        return gymUserService.getAll();
    }

    @GetMapping("/user/{id}")
    public GymUserView getById(@PathVariable Long id) {
        return gymUserService.getById(id);
    }
}
