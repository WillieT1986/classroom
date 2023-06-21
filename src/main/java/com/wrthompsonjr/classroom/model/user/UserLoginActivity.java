/*  The UserLoginActivity class represents the login activity of a user.
    It contains fields such as id, loginDate, loginStatus, and a reference to the associated User entity.
    It provides getters and setters for accessing and modifying the login activity properties.
    The class is annotated with JPA annotations to map it to the corresponding database table.

    - William R Thompson Jr. (06/16/2023)
*/

package com.wrthompsonjr.classroom.model.user;

import com.wrthompsonjr.classroom.model.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_login_activity")
public class UserLoginActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login_date", nullable = false)
    private LocalDateTime loginDate;

    @Column(name = "login_status", nullable = false)
    private boolean loginStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public UserLoginActivity() {
    }

    public UserLoginActivity(LocalDateTime loginDate, boolean loginStatus, User user) {
        this.loginDate = loginDate;
        this.loginStatus = loginStatus;
        this.user = user;
    }

    /* GETTERS */
    public long getId() {
        return id;
    }

    /**
     * Gets the login date of the user login activity.
     * @return The login date.
     */
    public LocalDateTime getLoginDate() {
        return loginDate;
    }

    /**
     * Checks if the login status of the user login activity is successful.
     * @return true if the login status is successful, false otherwise.
     */
    public boolean isLoginStatus() {
        return loginStatus;
    }

    public User getUser() {
        return user;
    }

    /* SETTERS */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Sets the login date of the user login activity.
     * @param loginDate The login date.
     */
    public void setLoginDate(LocalDateTime loginDate) {
        this.loginDate = loginDate;
    }

    /**
     * Sets the login status of the user login activity.
     * @param loginStatus The login status.
     */
    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
