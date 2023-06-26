package com.wrthompsonjr.classroom.model.user;

import com.wrthompsonjr.classroom.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class UserProfileTest {

    User user;

    UserProfile underTest;

    @BeforeEach
    public void setUp() {
        // New User
        user = new User();

        // New User Profile
        underTest = new UserProfile();
    }

    @Test
    public void testSetAndGetId() {
        // Test setting and getting the ID property of UserProfile
        // Create a test ID value
        Long id = 1L;

        // Assert that the ID property is null
        assertNull(underTest.getId());

        // Set the ID property to the test ID value
        underTest.setId(id);

        // Assert that the ID property is equal to the test ID value
        assertEquals(id, underTest.getId());
    }

    @Test
    public void testSetAndGetFirstName() {
        // Test setting and getting the firstName property of UserProfile
        String firstName = "John";

        // Assert that the firstName property is null
        assertNull(underTest.getFirstName());

        // Set the firstName property to the test firstName value
        underTest.setFirstName(firstName);

        // Assert that the firstName property is equal to the test firstName value
        assertEquals(firstName, underTest.getFirstName());
    }

    @Test
    public void testSetAndGetMiddleName() {
        // Test setting and getting the middleName property of UserProfile
        String middleName = "Robert";

        // Assert that the middleName property is null
        assertNull(underTest.getMiddleName());

        // Set the middleName property to the test middleName value
        underTest.setMiddleName(middleName);

        // Assert that the middleName property is equal to the test middleName value
        assertEquals(middleName, underTest.getMiddleName());
    }

    @Test
    public void testSetAndGetLastName() {
        // Test setting and getting the lastName property of UserProfile
        String lastName = "Doe";

        // Assert that the lastName property is null
        assertNull(underTest.getLastName());

        // Set the lastName property to the test lastName value
        underTest.setLastName(lastName);

        // Assert that the lastName property is equal to the test lastName value
        assertEquals(lastName, underTest.getLastName());
    }

    @Test
    public void testSetAndGetSuffix() {
        // Test setting and getting the suffix property of UserProfile
        String suffix = "Jr.";

        // Assert that the suffix property is null
        assertNull(underTest.getSuffix());

        // Set the suffix property to the test suffix value
        underTest.setSuffix(suffix);

        // Assert that the suffix property is equal to the test suffix value
        assertEquals(suffix, underTest.getSuffix());
    }

    @Test
    public void testSetAndGetDateOfBirth() {
        // Test setting and getting the dateOfBirth property of UserProfile
        LocalDate dateOfBirth = LocalDate.of(1990, 5, 15);

        // Assert that the dateOfBirth property is null
        assertNull(underTest.getDateOfBirth());

        // Set the dateOfBirth property to the test dateOfBirth value
        underTest.setDateOfBirth(dateOfBirth);

        // Assert that the dateOfBirth property is equal to the test dateOfBirth value
        assertEquals(dateOfBirth, underTest.getDateOfBirth());
    }

    @Test
    public void testSetAndGetGender() {
        // Test setting and getting the gender property of UserProfile
        Gender gender = Gender.MALE;

        // Assert that the Gender property is null
        assertNull(underTest.getGender());

        // Set the Gender property to the test gender value
        underTest.setGender(gender);

        // Assert that the gender property is equal to the test gender value
        assertEquals(gender, underTest.getGender());
    }

    @Test
    public void testSetAndGetAddress() {
        // Test setting and getting the address property of UserProfile
        Address address = new Address();

        // Assert that the address property is null
        assertNull(underTest.getAddress());

        // Set the address property to the test address value
        underTest.setAddress(address);

        // Assert that the address property is equal to the test address value
        assertEquals(address, underTest.getAddress());
    }

    @Test
    public void testSetAndGetUser() {
        // Test setting and getting the user property of UserProfile
        assertNull(underTest.getUser());

        // Set the user property to the test user value
        underTest.setUser(user);

        // Assert that the user property is equal to the test user value
        assertEquals(user, underTest.getUser());
    }

    @Test
    public void testSetAndGetLastUpdatedBy() {
        // Test setting and getting the lastUpdatedBy property of UserProfile
        String lastUpdatedBy = "admin";

        // Assert that the lastUpdatedBy property is null
        assertNull(underTest.getLastUpdatedBy());

        // Set the lastUpdatedBy property to the test lastUpdatedBy value
        underTest.setLastUpdatedBy(lastUpdatedBy);

        // Assert that the lastUpdatedBy property is equal to the test lastUpdatedBy value
        assertEquals(lastUpdatedBy, underTest.getLastUpdatedBy());
    }

    @Test
    public void testSetAndGetLastUpdatedTimestamp() {
        // Test setting and getting the lastUpdatedTimestamp property of UserProfile
        LocalDateTime lastUpdatedTimestamp = LocalDateTime.now();

        // Assert that the lastUpdatedTimestamp property is null
        assertNull(underTest.getLastUpdatedTimestamp());

        // Set the lastUpdatedTimestamp property to the test lastUpdatedTimestamp value
        underTest.setLastUpdatedTimestamp(lastUpdatedTimestamp);

        // Assert that the lastUpdatedTimestamp property is equal to the test lastUpdatedTimestamp value
        assertEquals(lastUpdatedTimestamp, underTest.getLastUpdatedTimestamp());
    }

    @Test
    public void testToString() {
        // Test the toString method of UserProfile
        // Set the properties of the UserProfile
        underTest.setId(1L);
        underTest.setFirstName("John");
        underTest.setLastName("Doe");

        // Define the expected string representation of the UserProfile object
        String expectedString = "UserProfile{" +
                "id=1, " +
                "firstName='John', " +
                "middleName='null', " +
                "lastName='Doe', " +
                "suffix='null', " +
                "dateOfBirth=null, " +
                "gender=null, " +
                "address=null, " +
                "lastUpdatedBy='null', " +
                "lastUpdatedTimestamp=null" +
                "}";

        // Assert that the toString method returns the expected string
        assertEquals(expectedString, underTest.toString());
    }

    @Test
    public void testConstructor() {
        // Test the constructor of UserProfile
        // Create a new UserProfile object
        String firstName = "John";
        String lastName = "Doe";
        LocalDate dateOfBirth = LocalDate.of(1990, 5, 15);
        Gender gender = Gender.MALE;
        Address address = new Address();

        // Create a new UserProfile object using the constructor
        UserProfile userProfile = new UserProfile(firstName, null, lastName, null, dateOfBirth, gender, address);

        // Assert that the properties of the UserProfile object are equal to the test values
        assertEquals(firstName, userProfile.getFirstName());
        assertNull(userProfile.getMiddleName());
        assertEquals(lastName, userProfile.getLastName());
        assertNull(userProfile.getSuffix());
        assertEquals(dateOfBirth, userProfile.getDateOfBirth());
        assertEquals(gender, userProfile.getGender());
        assertEquals(address, userProfile.getAddress());
    }

    @Test
    public void testUserAssociation() {
        // Test the association between UserProfile and User
        // Set the user property of UserProfile to the test user
        underTest.setUser(user);
        user.setUserProfile(underTest);

        // Assert that the user property of UserProfile is equal to the test user
        assertEquals(user, underTest.getUser());
        assertEquals(underTest, user.getUserProfile());
    }

    @Test
    public void testLastUpdatedByAndTimestamp() {
        // Test the lastUpdatedBy and lastUpdatedTimestamp properties of UserProfile
        String lastUpdatedBy = "admin";
        LocalDateTime lastUpdatedTimestamp = LocalDateTime.now();

        // Set the lastUpdatedBy and lastUpdatedTimestamp using the setter methods
        underTest.setLastUpdatedBy(lastUpdatedBy);
        underTest.setLastUpdatedTimestamp(lastUpdatedTimestamp);

        // Verify that the lastUpdatedBy and lastUpdatedTimestamp properties are equal to the test values
        assertEquals(lastUpdatedBy, underTest.getLastUpdatedBy());
        assertEquals(lastUpdatedTimestamp, underTest.getLastUpdatedTimestamp());
    }

    @Test
    public void testDeepCopy() {
        // Test creating a deep copy of UserProfile
        // Set the test values for the UserProfile properties
        String firstName = "John";
        String lastName = "Doe";
        LocalDate dateOfBirth = LocalDate.of(1990, 5, 15);
        Gender gender = Gender.MALE;
        Address address = new Address();

        // Create a new UserProfile object using the constructor
        UserProfile userProfile = new UserProfile(firstName, null, lastName, null, dateOfBirth, gender, address);
        // Create a deep copy of the UserProfile object
        UserProfile copy = userProfile.deepCopy();

        // Assert that the copy is not the same object as the original
        assertNotSame(userProfile, copy);
        assertEquals(userProfile.getFirstName(), copy.getFirstName());
        assertEquals(userProfile.getLastName(), copy.getLastName());
        assertEquals(userProfile.getDateOfBirth(), copy.getDateOfBirth());
        assertEquals(userProfile.getGender(), copy.getGender());
        assertNotSame(userProfile.getAddress(), copy.getAddress());
        assertEquals(userProfile.getAddress(), copy.getAddress());
    }

}
