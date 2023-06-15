package com.wrthompsonjr.classroom.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "email", nullable = false, length = 254, unique = true) // 254 is the max length of an email address according to the RFC 5321 standards
    private String email;
    @Column(name = "password", nullable = false, length = 80) // 80 is the max length since we are using BCrypt which has a max length of 72 bytes
    private String encodedPassword;

    public User() {
    }
    public User(String email, String encodedPassword) {
        this.email = email;
        this.encodedPassword = encodedPassword;
    }

    /* GETTERS */
    public long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return encodedPassword;
    }

    /* Setters */
    public void setId(long id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String encodedPassword) {
        this.encodedPassword = encodedPassword;
    }

    /* OVERRIDES */
    @Override
    public int hashCode() {
        return ((Long) id).hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return id == ((User) obj).id;
    }
}
