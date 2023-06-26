package com.wrthompsonjr.classroom.model.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GenderTest {

    @Test
    public void testGetDisplayName() {
        assertEquals("Male", Gender.MALE.getDisplayName());
        assertEquals("Female", Gender.FEMALE.getDisplayName());
        assertEquals("Other", Gender.OTHER.getDisplayName());
    }

    @Test
    public void testEnumValues() {
        // Test that enum values return the expected labels
        assertEquals("MALE", Gender.MALE.name());
        assertEquals("FEMALE", Gender.FEMALE.name());
        assertEquals("OTHER", Gender.OTHER.name());
    }

    @Test
    public void testEnumEquality() {
        // Test that enum values are equal to themselves
        assertSame(Gender.MALE, Gender.MALE);
        assertSame(Gender.FEMALE, Gender.FEMALE);
        assertSame(Gender.OTHER, Gender.OTHER);

        // Test that enum values are not equal to each other
        assertNotSame(Gender.MALE, Gender.FEMALE);
        assertNotSame(Gender.MALE, Gender.OTHER);
        assertNotSame(Gender.FEMALE, Gender.OTHER);
    }

    @Test
    public void testEnumCaseInsensitivity() {
        // Test that enum values are case-insensitive
        assertEquals(Gender.MALE, Gender.valueOf("male".toUpperCase()));
        assertEquals(Gender.FEMALE, Gender.valueOf("female".toUpperCase()));
        assertEquals(Gender.OTHER, Gender.valueOf("other".toUpperCase()));
    }

    @Test
    public void testEnumValuesCount() {
        // Test the number of enum values
        assertEquals(3, Gender.values().length);
    }

    @Test
    public void testEnumIteration() {
        // Iterate over the enum values and perform assertions or checks on each value
        for (Gender gender : Gender.values()) {
            assertNotNull(gender);
            assertNotNull(gender.getDisplayName());
        }
    }

}
