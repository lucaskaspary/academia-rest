package com.lucas.academiarest.model.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GymUserForm {
    private String username;

    private String cpf;

    private String address;

    private String phone;

    private LocalDate birthday;
}
