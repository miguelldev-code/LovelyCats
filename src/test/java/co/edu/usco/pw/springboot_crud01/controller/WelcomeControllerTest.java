package co.edu.usco.pw.springboot_crud01.controller;

import co.edu.usco.pw.springboot_crud01.userol.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class WelcomeControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private Model model;

    @InjectMocks
    private WelcomeController welcomeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testLogin_Successful() {
        String username = "testUser";
        String password = "testPassword";
        String encodedPassword = "encodedTestPassword";

        UserDetails mockUserDetails = User.builder()
                .username(username)
                .password(encodedPassword)
                .roles("USER")
                .build();

        when(userService.loadUserByUsername(username)).thenReturn(mockUserDetails);
        when(passwordEncoder.matches(password, encodedPassword)).thenReturn(true);

        String result = welcomeController.login(username, password, model);

        assertEquals("redirect:/welcome", result);
    }

    @Test
    void testLogin_IncorrectPassword() {
        String username = "testUser";
        String password = "incorrectPassword";
        String encodedPassword = "encodedTestPassword";

        UserDetails mockUserDetails = User.builder()
                .username(username)
                .password(encodedPassword)
                .roles("USER")
                .build();

        when(userService.loadUserByUsername(username)).thenReturn(mockUserDetails);
        when(passwordEncoder.matches(password, encodedPassword)).thenReturn(false);

        String result = welcomeController.login(username, password, model);

        assertEquals("login", result);
        verify(model).addAttribute("error", "Nombre de usuario o contraseña incorrectos");
    }

    @Test
    void testLogin_UserNotFound() {
        String username = "nonExistentUser";
        String password = "somePassword";

        when(userService.loadUserByUsername(username)).thenThrow(new UsernameNotFoundException("User not found"));

        String result = welcomeController.login(username, password, model);

        assertEquals("login", result);
        verify(model).addAttribute("error", "Nombre de usuario o contraseña incorrectos");
    }
}
