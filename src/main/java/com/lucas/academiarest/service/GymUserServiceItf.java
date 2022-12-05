package com.lucas.academiarest.service;

import com.lucas.academiarest.model.GymUser;
import com.lucas.academiarest.model.forms.GymUserForm;
import com.lucas.academiarest.model.view.GymUserView;

import java.util.List;

public interface GymUserServiceItf {
    GymUserView create(GymUserForm form);
    GymUserView getById(Long id);
    List<GymUserView> getAll();
}
