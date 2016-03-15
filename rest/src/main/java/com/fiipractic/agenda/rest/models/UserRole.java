package com.fiipractic.agenda.rest.models;

import javax.persistence.*;

/**
 * File created by a.chmilevski on 3/15/2016 - 11:12 AM.
 * RadiON
 */
@Entity
@Table(name = "user_roles", uniqueConstraints = {@UniqueConstraint(columnNames = {"username", "role"})})
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
