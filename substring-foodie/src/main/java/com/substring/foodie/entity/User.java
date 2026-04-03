package com.substring.foodie.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "foodie_user")
@Getter
@Setter
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Role roles;
    private boolean isAvailable = true; //applicable for delivery boy only;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Restaurant> restaurants = new ArrayList<>();
    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<RoleEntity> roleEntities = new ArrayList<>();

    private LocalDate createdAt;


    @PrePersist
    public void preSave() {
        System.out.println("Called just before saving in db");
        this.setCreatedAt(LocalDate.now());
    }

    @PostPersist
    public void postSave() {
        System.out.println("Callback method just after saving");
        System.out.println("Entity saved " + this.getId());
    }

    @PreUpdate
    public void preUpdate() {
        System.out.println("Entity updated: " + this.getId());
    }
}
