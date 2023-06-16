package com.wrthompsonjr.classroom.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private static final String EMAIL = "testEmail@hotmail.com";
    private static final String ENCODED_PASSWORD = "password";

    User underTest;

    @BeforeEach
    public void setUp() {
        underTest = new User(EMAIL, ENCODED_PASSWORD);
    }

    @Test
    public void shouldInstantiateAUserClass() {
        assertNotNull(underTest);
    }

    @Test
    public void shouldConstructAndReturnAnEmailAndPassword() {
        String check2 = underTest.getEmail();
        String check3 = underTest.getPassword();
        assertEquals(EMAIL, check2);
        assertEquals(ENCODED_PASSWORD, check3);
    }

    @Test
    public void testCreateDateIsSet() {
        LocalDateTime currentTime = LocalDateTime.now();

        // Assert that the creationDate is set within a reasonable range of the current time
        assertNotNull(underTest.getCreationDate());
        assertTrue(underTest.getCreationDate().isAfter(currentTime.minusSeconds(1)));
        assertTrue(underTest.getCreationDate().isBefore(currentTime.plusSeconds(1)));
    }

    @Test
    public void testLastLoginDateIsUpdated() {
        LocalDateTime initialLastLoginDate = underTest.getLastLoginDate();

        // Simulate a login action
        underTest.setLastLoginDate(LocalDateTime.now());

        // Assert that the lastLoginDate has been updated
        assertNotEquals(initialLastLoginDate, underTest.getLastLoginDate());
    }

}
