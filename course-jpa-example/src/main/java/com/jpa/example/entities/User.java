package com.jpa.example.entities;

import com.jpa.example.dto.UserType;
import jakarta.persistence.*;

@Entity
@Table(name = "jpa_user")
public class User {
    @Id
    @Column(name = "jpa_user_id")
    private int userId;
    @Column(name = "jpa_user_name", nullable = false)
    private String name;
    private String email;
    private int age;
    private boolean isActive;
    @Enumerated(EnumType.STRING)
    private UserType type = UserType.STUDENT;
    @Transient
    private String extraInformation;
    @Embedded
    private Address address;


    public User() {}
    public User(int userId, String name, String email, int age, boolean isActive, UserType userType) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.age = age;
        this.isActive = isActive;
        this.type = userType;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getExtraInformation() {
        return extraInformation;
    }

    public void setExtraInformation(String extraInformation) {
        this.extraInformation = extraInformation;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
