package com.assignment.one.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "assignment_one_user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    private Boolean isActive = true;
    private LocalDate createDate =  LocalDate.now();
    private LocalDate updatedAt;

}
