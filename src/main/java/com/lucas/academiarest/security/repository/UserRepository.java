package com.lucas.academiarest.security.repository;

import com.lucas.academiarest.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT e FROM User e JOIN FETCH e.roles WHERE e.username = (:username)")
    public User findByUsername(@Param("username") String username);

    @Query("SELECT e FROM User e WHERE e.name = (:name)")
    public User findUserByName(@Param("name") String name);

    @Query("SELECT e FROM User e WHERE e.username = (:username)")
    public User findUserByUsername(@Param("username") String username);
}