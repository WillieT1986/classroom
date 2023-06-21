/*  The UserRepository interface is a Spring Data repository for managing User entities.
    It extends the JpaRepository interface, providing CRUD operations and other querying capabilities.
    The repository allows interacting with the underlying database table for User entities.

    - William R Thompson Jr. (06/16/2023)
*/

package com.wrthompsonjr.classroom.data;

import com.wrthompsonjr.classroom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.userRole.name = :roleName")
    List<User> findUsersByRoleName(@Param("roleName") String roleName);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);

}
