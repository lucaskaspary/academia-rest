package com.lucas.academiarest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lucas.academiarest.security.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "tbl_gym_users")
public class GymUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private User account;

    @Column(unique = true)
    private String cpf;

    private String address;

    private String phone;

    private LocalDate birthday;

    @OneToMany(mappedBy = "gym_user", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Evaluation> evaluations;

}
