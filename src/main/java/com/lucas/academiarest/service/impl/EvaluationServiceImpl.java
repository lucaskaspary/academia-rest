package com.lucas.academiarest.service.impl;

import com.lucas.academiarest.model.Evaluation;
import com.lucas.academiarest.model.GymUser;
import com.lucas.academiarest.model.forms.EvaluationForm;
import com.lucas.academiarest.repository.EvaluationRepository;
import com.lucas.academiarest.repository.GymUserRepository;
import com.lucas.academiarest.security.model.User;
import com.lucas.academiarest.security.repository.UserRepository;
import com.lucas.academiarest.service.EvaluationServiceItf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationServiceImpl implements EvaluationServiceItf {
    @Autowired
    GymUserRepository gymUserRepository;

    @Autowired
    EvaluationRepository evaluationRepository;


    public Evaluation create(EvaluationForm form) {
        Evaluation eval = new Evaluation();
        eval.setGymUser(gymUserRepository.findByUsername(form.getUsername()));
        eval.setWeight(form.getWeight());
        eval.setHeight(form.getHeight());
        eval.setBodyFat(form.getBodyFat());

        return evaluationRepository.save(eval);
    }

    public List<Evaluation> findByUsername(String username) {
        return evaluationRepository.findByUsername(username);
    }

    public List<Evaluation> getAll() {
        return evaluationRepository.findAll();
    }

    public Evaluation getById(Long id) {
        return evaluationRepository.findById(id).get();
    }
}
