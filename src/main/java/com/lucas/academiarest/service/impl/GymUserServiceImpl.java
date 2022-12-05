package com.lucas.academiarest.service.impl;

import com.lucas.academiarest.model.GymUser;
import com.lucas.academiarest.model.forms.GymUserForm;
import com.lucas.academiarest.model.view.GymUserView;
import com.lucas.academiarest.repository.GymUserRepository;
import com.lucas.academiarest.security.model.User;
import com.lucas.academiarest.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GymUserServiceImpl {

    @Autowired
    GymUserRepository gymUserRepository;

    @Autowired
    UserRepository userRepository;

    GymUser create(GymUserForm form) {
        User user = userRepository.findByUsername(form.getUsername());
        GymUser gymUser = new GymUser();
        gymUser.setAccount(user);
        gymUser.setCpf(form.getCpf());
        gymUser.setAddress(form.getAddress());
        gymUser.setPhone(form.getPhone());
        gymUser.setBirthday(form.getBirthday());

        return gymUserRepository.save(gymUser);
    }

    List<GymUserView> getAll() {
        List<GymUser> list = gymUserRepository.findAll();
        List<GymUserView> listView = new ArrayList<>();

        for (GymUser gymUser : list) {
            GymUserView view = new GymUserView();
            view.setName(gymUser.getAccount().getName());
            view.setUsername(gymUser.getAccount().getUsername());
            view.setCpf(gymUser.getCpf());
            view.setBirthday(gymUser.getBirthday());
            view.setAddress(gymUser.getAddress());
            view.setPhone(gymUser.getPhone());
            view.setId(gymUser.getId());
            listView.add(view);
        }
        return listView;
    }

}
