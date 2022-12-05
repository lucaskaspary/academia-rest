package com.lucas.academiarest.model.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationForm {
    private String username;

    private double weight;

    private double height;

    private double bodyFat;
}
