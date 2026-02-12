package com.jpa.example.repository;

import com.jpa.example.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String value);
    Optional<List<User>> findByName(String name);

    @Query(value = "SELECT * FROM jpa_user", nativeQuery = true)
    public List<User> getUser();

    @Query(value = "SELECT * FROM jpa_user WHERE email = :email", nativeQuery = true)
    public List<User> getUsersByEmail(@Param("email") String email);
}
