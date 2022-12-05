package com.lucas.academiarest.repository;

import com.lucas.academiarest.model.GymUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GymUserRepository extends JpaRepository<GymUser, Long> {

    @Query("SELECT g FROM GymUser g WHERE g.account.username = (:username)")
    GymUser findByUsername(String username);
}
