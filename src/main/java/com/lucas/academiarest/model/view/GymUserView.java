package com.lucas.academiarest.model.view;

import com.lucas.academiarest.model.Evaluation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GymUserView {
    private Long id;

    private String username;

    private String name;

    private String cpf;

    private String address;

    private String phone;

    private LocalDate birthday;

    private List<Evaluation> evaluations;
}
