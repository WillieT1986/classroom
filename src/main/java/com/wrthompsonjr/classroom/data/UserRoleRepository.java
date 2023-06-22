package com.wrthompsonjr.classroom.data;

import com.wrthompsonjr.classroom.model.User;
import com.wrthompsonjr.classroom.model.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    @Query("SELECT ur FROM UserRole ur WHERE ur.name = :name")
    UserRole findUserRoleByName(@Param("name") String name);

    @Query("SELECT u FROM User u WHERE u.userRole.name = :roleName")
    List<User> findUsersByRoleName(String roleName);

}
