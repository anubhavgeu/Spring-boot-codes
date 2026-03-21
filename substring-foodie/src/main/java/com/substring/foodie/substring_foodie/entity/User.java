package com.substring.foodie.substring_foodie.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "foodie_user")
@Getter
@Setter
public class User {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String address;
    private String phoneNumber;
//    @Enumerated(EnumType.STRING)
//    private Role role; // ADMIN, CUSTOMER, DELIVERY BOY
    private Boolean isAvailable = true; // applicable for delivery boy only
    private LocalDateTime createdAt;
    private Boolean enabled = Boolean.TRUE;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Restaurant> restaurantList = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<RoleEntity> roleEntities = new ArrayList<>();

//    @PrePersist
//    public void preSave() {
//        this.createdAt = LocalDateTime.now();
//    }
//
//    @PostUpdate
//    @Pre
//    public void postSave() {
//        this.createdAt = LocalDateTime.now();
//    }
}
