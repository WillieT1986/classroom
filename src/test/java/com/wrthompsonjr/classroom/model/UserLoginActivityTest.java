/*  The UserLoginActivityTest class is a JUnit test class for the UserLoginActivity class.
    It contains test methods to verify the behavior of the UserLoginActivity class,
    such as checking if the login status is set correctly.

    - William R Thompson Jr. (06/16/2023)
*/

package com.wrthompsonjr.classroom.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class UserLoginActivityTest {

    private static final String EMAIL = "testEmail@hotmail.com";
    private static final String ENCODED_PASSWORD = "password";

    User user;

    UserLoginActivity userLoginActivity;

    @BeforeEach
    public void setUp() {
        user = new User(EMAIL, ENCODED_PASSWORD);
        userLoginActivity = new UserLoginActivity();
    }

    @Test
    public void testCreateUserLoginActivity() {
        // Create a login activity
        LocalDateTime loginDate = LocalDateTime.now();
        boolean loginStatus = true;
        UserLoginActivity userLoginActivity = new UserLoginActivity(loginDate, loginStatus, user);

        // Verify the login activity properties
        assertThat(userLoginActivity.getLoginDate()).isEqualTo(loginDate);
        assertThat(userLoginActivity.isLoginStatus()).isEqualTo(loginStatus);
        assertThat(userLoginActivity.getUser()).isEqualTo(user);
    }

    @Test
    public void testSettersAndGetters() {
        // Set the login activity properties
        LocalDateTime loginDate = LocalDateTime.now();
        boolean loginStatus = true;
        userLoginActivity.setLoginDate(loginDate);
        userLoginActivity.setLoginStatus(loginStatus);
        userLoginActivity.setUser(user);

        // Verify the login activity properties using getters
        assertThat(userLoginActivity.getLoginDate()).isEqualTo(loginDate);
        assertThat(userLoginActivity.isLoginStatus()).isEqualTo(loginStatus);
        assertThat(userLoginActivity.getUser()).isEqualTo(user);
    }

}
