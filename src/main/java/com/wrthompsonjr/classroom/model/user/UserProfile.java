package com.wrthompsonjr.classroom.model.user;

import com.wrthompsonjr.classroom.model.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_profiles")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "suffix")
    private String suffix;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Embedded
    private Address address;

    @Column(name = "last_updated_by")
    private String lastUpdatedBy;

    @Column(name = "last_updated_timestamp")
    private LocalDateTime lastUpdatedTimestamp;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    /* CONSTRUCTORS */
    public UserProfile() {
    }

    public UserProfile(String firstName, String middleName, String lastName, String suffix, LocalDate dateOfBirth,
                       Gender gender, Address address) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
    }

    /* GETTERS */
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public Address getAddress() {
        return address;
    }

    public User getUser() {
        return user;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public LocalDateTime getLastUpdatedTimestamp() {
        return lastUpdatedTimestamp;
    }

    /* SETTERS */
    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public void setLastUpdatedTimestamp(LocalDateTime lastUpdatedTimestamp) {
        this.lastUpdatedTimestamp = lastUpdatedTimestamp;
    }

    /* OVERRIDE METHODS */
    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", suffix='" + suffix + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", address=" + address +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", lastUpdatedTimestamp=" + lastUpdatedTimestamp +
                '}';
    }

    /* UTILITY METHODS */
    public UserProfile deepCopy() {
        UserProfile copy = new UserProfile();
        copy.setId(this.id);
        copy.setFirstName(this.firstName);
        copy.setMiddleName(this.middleName);
        copy.setLastName(this.lastName);
        copy.setSuffix(this.suffix);
        copy.setDateOfBirth(this.dateOfBirth);
        copy.setGender(this.gender);
        copy.setAddress(this.address);
        copy.setLastUpdatedBy(this.lastUpdatedBy);
        copy.setLastUpdatedTimestamp(this.lastUpdatedTimestamp);
        // Copy any other mutable fields here

        /* Creates A New Instance Of Address With Copied Values */
        Address addressCopy = new Address();
        addressCopy.setAddressLine1(this.address.getAddressLine1());
        addressCopy.setAddressLine2(this.address.getAddressLine2());
        addressCopy.setCity(this.address.getCity());
        addressCopy.setState(this.address.getState());
        addressCopy.setPostalCode(this.address.getPostalCode());
        addressCopy.setCountry(this.address.getCountry());

        copy.setAddress(addressCopy);

        copy.setLastUpdatedBy(this.lastUpdatedBy);
        copy.setLastUpdatedTimestamp(this.lastUpdatedTimestamp);

        return copy;
    }

}
