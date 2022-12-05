package com.lucas.academiarest.controller;

import com.lucas.academiarest.model.Evaluation;
import com.lucas.academiarest.model.forms.EvaluationForm;
import com.lucas.academiarest.service.impl.EvaluationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EvaluationController {
    @Autowired
    EvaluationServiceImpl evaluationService;

    @PostMapping("/user/evaluation")
    public Evaluation create(@RequestBody EvaluationForm form) {
        return evaluationService.create(form);
    }

    @GetMapping("/user/evaluation")
    public List<Evaluation> getAll() {
        return evaluationService.getAll();
    }

    @GetMapping("/user/evaluation/{id}")
    public Evaluation getById(@PathVariable Long id) {
        return evaluationService.getById(id);
    }

}
