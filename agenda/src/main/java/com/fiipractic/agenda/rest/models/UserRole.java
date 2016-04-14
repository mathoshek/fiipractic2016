package com.fiipractic.agenda.rest.models;

import javax.persistence.*;

@Entity
@Table(name="user_roles")
public class UserRole {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="id")
   private Long id;
   
   @ManyToOne
   @JoinColumn(name="user_id")
   private User user;
   
   @Column(name="role")
   private String role;

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public User getUser() {
    return user;
}

public void setUser(User user) {
    this.user = user;
}

public String getRole() {
    return role;
}

public void setRole(String role) {
    this.role = role;
}
   
   
}
