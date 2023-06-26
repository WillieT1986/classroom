/*  The User class represents a user in the system.
    It contains fields such as id, email, encodedPassword, creationDate, and lastLoginDate.
    It also provides getters and setters for accessing and modifying the user's properties.
    The class is annotated with JPA annotations to map it to the corresponding database table.

    - William R Thompson Jr. (06/16/2023)
*/

package com.wrthompsonjr.classroom.model;

import com.wrthompsonjr.classroom.model.user.UserLoginActivity;
import com.wrthompsonjr.classroom.model.user.UserProfile;
import com.wrthompsonjr.classroom.model.user.UserRole;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "last_login_date")
    private LocalDateTime lastLoginDate;

    /* RELATIONSHIPS */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserLoginActivity> loginActivities = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private UserRole userRole;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserProfile userProfile;

    /* CONSTRUCTORS */
    public User() {
    }

    public User(String email, String encodedPassword) {
        this.email = email;
        this.encodedPassword = encodedPassword;
        this.creationDate = LocalDateTime.now();
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public List<UserLoginActivity> getLoginActivities() {
        return loginActivities;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public UserProfile getUserProfile() {
        return userProfile;
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

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setLastLoginDate(LocalDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public void setLoginActivities(List<UserLoginActivity> loginActivities) {
        this.loginActivities = loginActivities;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public void setUserProfile(UserProfile userProfile) {
        if (userProfile == null) {
            if (this.userProfile != null) {
                this.userProfile.setUser(null);
            }
        } else {
            userProfile.setUser(this);
        }
        this.userProfile = userProfile;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", encodedPassword='" + encodedPassword + '\'' +
                ", creationDate=" + creationDate +
                ", lastLoginDate=" + lastLoginDate +
                ", loginActivities=" + loginActivities +
                ", userRole=" + userRole +
                '}';
    }

}
