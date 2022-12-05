package com.lucas.academiarest.service.impl;

import com.lucas.academiarest.model.GymUser;
import com.lucas.academiarest.model.forms.GymUserForm;
import com.lucas.academiarest.model.view.GymUserView;
import com.lucas.academiarest.repository.GymUserRepository;
import com.lucas.academiarest.security.model.User;
import com.lucas.academiarest.security.repository.UserRepository;
import com.lucas.academiarest.service.GymUserServiceItf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GymUserServiceImpl implements GymUserServiceItf {

    @Autowired
    GymUserRepository gymUserRepository;

    @Autowired
    UserRepository userRepository;

    private GymUserView gymUserToView(GymUser gymUser) {
        GymUserView view = new GymUserView();
        view.setName(gymUser.getAccount().getName());
        view.setUsername(gymUser.getAccount().getUsername());
        view.setCpf(gymUser.getCpf());
        view.setBirthday(gymUser.getBirthday());
        view.setAddress(gymUser.getAddress());
        view.setPhone(gymUser.getPhone());
        view.setId(gymUser.getId());
        view.setEmail(gymUser.getAccount().getEmail());
        return view;
    }

    public GymUserView getById(Long id) {
        GymUser gymUser = gymUserRepository.findById(id).get();
        if(gymUser == null)
            return null;

       return gymUserToView(gymUser);
    }

    public GymUserView create(GymUserForm form) {
        User user = userRepository.findByUsername(form.getUsername());
        GymUser gymUser = new GymUser();
        gymUser.setAccount(user);
        gymUser.setCpf(form.getCpf());
        gymUser.setAddress(form.getAddress());
        gymUser.setPhone(form.getPhone());
        gymUser.setBirthday(form.getBirthday());

        return gymUserToView(gymUserRepository.save(gymUser));
    }

    public List<GymUserView> getAll() {
        List<GymUser> list = gymUserRepository.findAll();
        List<GymUserView> listView = new ArrayList<>();

        for (GymUser gymUser : list) {
            listView.add(gymUserToView(gymUser));
        }
        return listView;
    }

}
