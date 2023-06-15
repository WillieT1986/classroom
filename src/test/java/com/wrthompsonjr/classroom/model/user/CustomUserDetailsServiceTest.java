package com.wrthompsonjr.classroom.model.user;

import com.wrthompsonjr.classroom.data.UserRepository;
import com.wrthompsonjr.classroom.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class CustomUserDetailsServiceTest {

    @InjectMocks
    CustomUserDetailsService underTest;

    @Mock
    UserRepository userRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void loadUserByUsername_WhenUserExists_ShouldReturnCustomUserDetails() {
        // Given a user email
        String email = "test@example.com";

        // And a user with the given email exists in the repository
        User user = new User();
        user.setEmail(email);
        when(userRepo.findByEmail(email)).thenReturn(user);

        // When attempting to load the user by their username/email
        UserDetails userDetails = underTest.loadUserByUsername(email);

        // Then a non-null CustomUserDetails object should be returned
        assertNotNull(userDetails);

        // And the returned UserDetails object should be an instance of CustomUserDetails
        assertTrue(userDetails instanceof CustomUserDetails);

        // And the username of the returned UserDetails should match the user's email
        assertEquals(user.getEmail(), userDetails.getUsername());
    }

    @Test
    public void loadUserByUsername_WhenUserDoesNotExist_ShouldThrowUsernameNotFoundException() {
        // Given a non-existent user email
        String email = "nonexistent@example.com";

        // And no user with the given email exists in the repository
        when(userRepo.findByEmail(email)).thenReturn(null);

        // Then attempting to load the user by their username/email should throw a UsernameNotFoundException
        assertThrows(UsernameNotFoundException.class, () -> {
            underTest.loadUserByUsername(email);
        });
    }

}
