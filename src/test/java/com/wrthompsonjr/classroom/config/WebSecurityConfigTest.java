package com.wrthompsonjr.classroom.config;

import com.wrthompsonjr.classroom.model.user.CustomUserDetailsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

public class WebSecurityConfigTest {

    @InjectMocks
    WebSecurityConfig underTest;

    @Mock
    DataSource dataSource;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void userDetailsService_ShouldReturnCustomUserDetailsService() {
        // When calling the userDetailsService method
        UserDetailsService result = underTest.userDetailsService();

        // Then a new instance of CustomUserDetailsService should be returned
        assertInstanceOf(CustomUserDetailsService.class, result);
    }

    @Test
    public void passwordEncoder_ShouldReturnBCryptPasswordEncoder() {
        // When calling the passwordEncoder method
        BCryptPasswordEncoder result = underTest.passwordEncoder();

        // Then a new instance of BCryptPasswordEncoder should be returned
        assertInstanceOf(BCryptPasswordEncoder.class, result);
    }

    /* getUserDetailsService() has protected access in WebSecurityConfig
       getPasswordEncoder() has protected access in WebSecurityConfig
    @Test
    public void authenticationProvider_ShouldReturnDaoAuthenticationProviderWithDependenciesSet() {
        // When calling the authenticationProvider method
        DaoAuthenticationProvider result = underTest.authenticationProvider();

        // Then a new instance of DaoAuthenticationProvider should be returned
        assertInstanceOf(DaoAuthenticationProvider.class, result);

        // And the dependencies should be set
        assertSame(underTest.userDetailsService(), result.getUserDetailsService());
        assertSame(underTest.passwordEncoder(), result.getPasswordEncoder());
    } */

    /* Cannot mock/spy HttpSecurity because it is a final class
    @Test
    public void configure_ShouldConfigureHttpSecurity() throws Exception {
        // Given an HttpSecurity mock
        HttpSecurity http = mock(HttpSecurity.class);

        // When calling the configure method
        underTest.configure(http);

        // Then the HttpSecurity should be properly configured
        http.authorizeRequests()
                .antMatchers("/users").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .usernameParameter("email")
                .defaultSuccessUrl("/users")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll();
    } */

}
