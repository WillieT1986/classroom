package com.wrthompsonjr.classroom.model.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AddressTest {

    private static final String ADDRESS_LINE_1 = "123 Main St";
    private static final String ADDRESS_LINE_2 = "Apt 4B";
    private static final String CITY = "New York City";
    private static final String STATE = "New York";
    private static final String POSTAL_CODE = "12345";
    private static final String COUNTRY = "United States";

    Address underTest;
    Address address1;
    Address address2;

    @BeforeEach
    public void setUp() {
        underTest = new Address();
        address1 = new Address(ADDRESS_LINE_1, ADDRESS_LINE_2, CITY, STATE, POSTAL_CODE, COUNTRY);
        address2 = new Address(ADDRESS_LINE_1, ADDRESS_LINE_2, CITY, STATE, POSTAL_CODE, COUNTRY);

    }

    @Test
    public void testSetAndGetAddressProperties() {
        // Test setting and getting the address properties of Address
        // Ensure the address properties are initially null
        assertNull(underTest.getAddressLine1());
        assertNull(underTest.getAddressLine2());
        assertNull(underTest.getCity());
        assertNull(underTest.getState());
        assertNull(underTest.getPostalCode());
        assertNull(underTest.getCountry());

        // Set the address properties using the setter methods
        underTest.setAddressLine1(ADDRESS_LINE_1);
        underTest.setAddressLine2(ADDRESS_LINE_2);
        underTest.setCity(CITY);
        underTest.setState(STATE);
        underTest.setPostalCode(POSTAL_CODE);
        underTest.setCountry(COUNTRY);

        // Verify that the address properties are set correctly by using the getter methods
        assertEquals(ADDRESS_LINE_1, underTest.getAddressLine1());
        assertEquals(ADDRESS_LINE_2, underTest.getAddressLine2());
        assertEquals(CITY, underTest.getCity());
        assertEquals(STATE, underTest.getState());
        assertEquals(POSTAL_CODE, underTest.getPostalCode());
        assertEquals(COUNTRY, underTest.getCountry());
    }

    @Test
    public void testEquals() {
        // Test the equals method of Address
        // Verify that the two Address objects are equal
        assertEquals(address1, address2);
    }

    @Test
    public void testToString() {
        // Test the toString method of Address
        // Set properties of the Address object
        underTest.setAddressLine1("123 Main St");
        underTest.setAddressLine2("Apt 4B");
        underTest.setCity("City");
        underTest.setState("State");
        underTest.setPostalCode("12345");
        underTest.setCountry("Country");

        // Define the expected string representation of the Address object
        String expectedString = "Address{" +
                "addressLine1='123 Main St', " +
                "addressLine2='Apt 4B', " +
                "city='City', " +
                "state='State', " +
                "postalCode='12345', " +
                "country='Country'" +
                "}";

        // Verify that the toString method produces the expected string
        assertEquals(expectedString, underTest.toString());
    }

}
