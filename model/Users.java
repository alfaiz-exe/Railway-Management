package com.example.demo.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "user_name",nullable = false)
    private String username;
    @Column(name = "password_hash",nullable = false)
    private String passwordHash;
    @Column(name = "user_type",nullable = false)
    private String userType;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
