package com.wrthompsonjr.classroom.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

}
