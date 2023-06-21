package com.wrthompsonjr.classroom.model.user;

import com.wrthompsonjr.classroom.data.UserRepository;
import com.wrthompsonjr.classroom.data.UserRoleRepository;
import com.wrthompsonjr.classroom.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRoleTest {

    private static final String EMAIL = "fakeEmail01@Test.com";
    private static final String ENCODED_PASSWORD = "fakePassword01!";
    private static final String USER = "user";
    private static final String USER_DESCRIPTION = "Default User Role";
    private static final String STUDENT = "student";
    private static final String STUDENT_DESCRIPTION = "Student Role";
    private static final String TEACHER = "teacher";
    private static final String TEACHER_DESCRIPTION = "Teacher Role";
    private static final String ADMIN = "admin";
    private static final String ADMIN_DESCRIPTION = "Administrator Role";

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRoleRepository userRoleRepo;

    @Autowired
    private UserRepository userRepo;

    User underTest;
    User user1;
    User user2;
    UserRole userRole;
    UserRole student;
    UserRole teacher;
    UserRole admin;

    @BeforeEach
    public void setUp() {
        entityManager.clear();

        // New User
        underTest = new User(EMAIL, ENCODED_PASSWORD);
        user1 = new User("user1@test.com", ENCODED_PASSWORD);
        user2 = new User("user2@test.com", ENCODED_PASSWORD);

        // New User Roles
        userRole = new UserRole(USER, USER_DESCRIPTION);
        student = new UserRole(STUDENT, STUDENT_DESCRIPTION);
        teacher = new UserRole(TEACHER, TEACHER_DESCRIPTION);
        admin = new UserRole(ADMIN, ADMIN_DESCRIPTION);

        // Save the user roles in the repository
        userRoleRepo.saveAll(Arrays.asList(userRole, student, teacher, admin));

        // Assign a user role to the user
        underTest.setUserRole(userRole);
        user1.setUserRole(student);
        user2.setUserRole(student);

        // Save the user in the repository
        userRepo.saveAll(Arrays.asList(underTest, user1, user2));
    }

    @Test
    public void testCreateUserRole() {
        entityManager.persist(userRole);
        entityManager.flush();

        UserRole savedUserRole = userRoleRepo.findById(userRole.getId()).orElse(null);

        assertThat(savedUserRole).isNotNull();
        assertThat(savedUserRole.getName()).isEqualTo(userRole.getName());
        assertThat(savedUserRole.getDescription()).isEqualTo(userRole.getDescription());
    }

    @Test
    public void testAssignUserRoleToUser() {
        // Create a new UserRole
        entityManager.persist(userRole);
        entityManager.flush();

        // Create a new User
        underTest.setUserRole(userRole);
        entityManager.persist(underTest);
        entityManager.flush();

        // Retrieve the saved User from the repository
        User savedUser = userRepo.findById(underTest.getId()).orElse(null);

        // Assert that the User has been assigned the UserRole
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getUserRole()).isEqualTo(userRole);
    }

    @Test
    public void testRemoveUserRoleFromUser() {
        // Retrieve the user from the repository
        User retrievedUser = userRepo.findById(underTest.getId()).orElse(null);

        // Retrieve the user role from the repository
        UserRole retrievedUserRole = userRoleRepo.findById(userRole.getId()).orElse(null);

        // Ensure both user and user role are not null
        assertNotNull(retrievedUser);
        assertNotNull(retrievedUserRole);

        // Remove the user role from the user's user role
        retrievedUser.setUserRole(null);

        // Save the updated user in the repository
        userRepo.save(retrievedUser);

        // Retrieve the user again to verify the changes
        User updatedUser = userRepo.findById(underTest.getId()).orElse(null);

        // Assert that the user role has been removed from the user
        assertNotNull(updatedUser);
        assertNull(updatedUser.getUserRole());
    }

    @Test
    public void shouldRemoveRoleFromUserAndReassignUserRole() {
        // Assign User role to the user
        underTest.setUserRole(userRole);

        // Save the updated user in the repository
        userRepo.save(underTest);

        // Retrieve the user from the repository
        User updatedUser = userRepo.findById(underTest.getId()).orElse(null);

        // Assert that the user has been reassigned to the User role
        assertThat(updatedUser).isNotNull();
        assertThat(updatedUser.getUserRole()).isEqualTo(userRole);
    }

    @Test
    public void shouldRemoveUserRoleFromOneUser() {
        // Remove user role from user1
        user1.setUserRole(userRole);

        // Save the updated user1 in the repository
        userRepo.save(user1);

        // Retrieve the updated user1 from the repository
        User updatedUser1 = userRepo.findById(user1.getId()).orElse(null);

        // Retrieve the other users from the repository
        User retrievedUnderTest = userRepo.findById(underTest.getId()).orElse(null);
        User retrievedUser2 = userRepo.findById(user2.getId()).orElse(null);

        // Assert that the student role has been removed from user1
        assertThat(updatedUser1).isNotNull();
        assertThat(updatedUser1.getUserRole()).isEqualTo(userRole);

        // Assert that the user role is still assigned to underTest and user2
        assertThat(retrievedUnderTest).isNotNull();
        assertThat(retrievedUnderTest.getUserRole()).isEqualTo(userRole);

        assertThat(retrievedUser2).isNotNull();
        assertThat(retrievedUser2.getUserRole()).isEqualTo(student);
    }

    @Test
    public void testRetrieveUsersByRoleName() {
        // Assign the "student" role to user1 and user2
        underTest.setUserRole(student);
        user1.setUserRole(student);

        // Assign the "teacher" role to user3
        user2.setUserRole(teacher);

        // Save the users in the repository
        userRepo.saveAll(List.of(underTest, user1, user2));

        // Retrieve users with the "student" role
        List<User> students = userRepo.findUsersByRoleName(STUDENT);

        // Assert that the list of students is not empty
        assertThat(students).isNotEmpty();

        // Assert that the list of students contains user1 and user2
        assertThat(students).contains(underTest, user1);

        // Assert that user3 is not in the list of students
        assertThat(students).doesNotContain(user2);
    }

}
