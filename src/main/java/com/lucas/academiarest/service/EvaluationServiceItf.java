package com.lucas.academiarest.service;

import com.lucas.academiarest.model.Evaluation;
import com.lucas.academiarest.model.forms.EvaluationForm;

import java.util.List;

public interface EvaluationServiceItf {
    Evaluation create(EvaluationForm form);

    List<Evaluation> findByUsername(String username);

    List<Evaluation> getAll();

    Evaluation getById(Long id);

}
