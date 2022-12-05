package com.lucas.academiarest.repository;

import com.lucas.academiarest.model.GymUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymUserRepository extends JpaRepository<GymUser, Long> {
}
