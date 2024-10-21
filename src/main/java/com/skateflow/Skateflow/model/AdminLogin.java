package com.skateflow.Skateflow.model;


import jakarta.persistence.*;

@Entity
@Table(name = "AdminLogin")
public class AdminLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Use um identificador único

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "senha", nullable = false)
    private String password; // Considere usar hashing para a senha

    // Getters e Setters
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
