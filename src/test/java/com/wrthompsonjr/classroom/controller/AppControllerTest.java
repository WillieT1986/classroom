package com.wrthompsonjr.classroom.controller;

import com.wrthompsonjr.classroom.data.UserRepository;
import com.wrthompsonjr.classroom.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AppControllerTest {

    @InjectMocks
    AppController underTest;

    @Mock
    UserRepository userRepo;

    @Mock
    Model model;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldReturnHomePage() {
        String result = underTest.viewHomePage();
        assertEquals("index", result);
    }

    @Test
    public void shouldShowRegistrationForm() {
        User user = new User();
        when(model.addAttribute("user", user)).thenReturn(model);

        String result = underTest.showRegistrationForm(model);

        verify(model).addAttribute("user", user);
        assertEquals("signup_form", result);
    }

    @Test
    public void shouldProcessRegister() {
        User user = new User();
        user.setPassword("password");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        when(userRepo.save(user)).thenReturn(user);

        String result = underTest.processRegister(user);

        // Verify that the user's password has been encoded
        verify(userRepo).save(user);
        assertEquals("register_success", result);
    }

    @Test
    public void shouldListUsers() {
        List<User> userList = new ArrayList<>();
        when(userRepo.findAll()).thenReturn(userList);

        String result = underTest.listUsers(model);

        // Verify that the list of users is added to the model
        verify(model).addAttribute("listUsers", userList);
        assertEquals("users", result);
    }


}
