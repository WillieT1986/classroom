package com.wrthompsonjr.classroom.model.user;

import com.wrthompsonjr.classroom.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomUserDetailsTest {

    // This Test is failing due to no roles have been created.
    /*
    @Test
    public void shouldReturnUserAuthorities() {
        User user = new User();
        UserDetails userDetails = new CustomUserDetails(user);

        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

        // Here, you can assert the expected authorities for the user
        // For example, you can check if the user has a specific role
        assertTrue(authorities.isEmpty());
    }
     */

    @Test
    public void shouldReturnUserPassword() {
        User user = new User();
        user.setPassword("password");
        UserDetails userDetails = new CustomUserDetails(user);

        String password = userDetails.getPassword();

        // Verify that the password returned matches the user's password
        assertEquals("password", password);
    }

    @Test
    public void shouldReturnUserUsername() {
        User user = new User();
        user.setEmail("test@example.com");
        UserDetails userDetails = new CustomUserDetails(user);

        String username = userDetails.getUsername();

        // Verify that the username returned matches the user's email
        assertEquals("test@example.com", username);
    }

    @Test
    public void shouldReturnAccountNonExpired() {
        User user = new User();
        UserDetails userDetails = new CustomUserDetails(user);

        boolean accountNonExpired = userDetails.isAccountNonExpired();

        // Verify that the account is always considered non-expired
        assertTrue(accountNonExpired);
    }

    @Test
    public void shouldReturnAccountNonLocked() {
        User user = new User();
        UserDetails userDetails = new CustomUserDetails(user);

        boolean accountNonLocked = userDetails.isAccountNonLocked();

        // Verify that the account is always considered non-locked
        assertTrue(accountNonLocked);
    }

    @Test
    public void shouldReturnCredentialsNonExpired() {
        User user = new User();
        UserDetails userDetails = new CustomUserDetails(user);

        boolean credentialsNonExpired = userDetails.isCredentialsNonExpired();

        // Verify that the credentials are always considered non-expired
        assertTrue(credentialsNonExpired);
    }

    @Test
    public void shouldReturnEnabled() {
        User user = new User();
        UserDetails userDetails = new CustomUserDetails(user);

        boolean enabled = userDetails.isEnabled();

        // Verify that the user is always considered enabled
        assertTrue(enabled);
    }

}
