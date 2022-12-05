package com.lucas.academiarest.repository;

import com.lucas.academiarest.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
    @Query("SELECT e FROM Evaluation e WHERE e.gymUser.account.username = (:username)")
    List<Evaluation> findByUsername(String username);
}
