/*  The UserRepositoryTest class is a JUnit test class for the UserRepository interface.
    It contains test methods to verify the functionality of the repository,
    such as creating a new user and retrieving users from the database.

    - William R Thompson Jr. (06/16/2023)
*/

package com.wrthompsonjr.classroom.data;

import com.wrthompsonjr.classroom.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepo;

    @Test
    @Transactional  // Apply the @Transactional annotation to make the test transactional
    @Rollback  // Add the @Rollback annotation to roll back the changes made during the test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("testEmail0003@Yahoo.com");
        user.setPassword("TestPassword2027!");

        // Set the creation date
        user.setCreationDate(LocalDateTime.now());

        User savedUser = userRepo.save(user);
        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
    }
}
