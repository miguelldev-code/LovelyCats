package co.edu.usco.pw.springboot_crud01.controller;

import co.edu.usco.pw.springboot_crud01.userol.UserService;
import co.edu.usco.pw.springboot_crud01.userol.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WelcomeController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    //---------------------------------------------------------------------------------------

    @GetMapping("/")
    public String Welcome(Model model) {
        return "welcome";
    }


    @GetMapping("/login")
    public String LoginPage() {
        return "login";
    }

    //---------------------------------------------------------------------------------------

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        try {
            UserDetails userDetails = userService.loadUserByUsername(username);
            if (passwordEncoder.matches(password, userDetails.getPassword())) {
                return "redirect:/welcome";
            } else {
                model.addAttribute("error", "Nombre de usuario o contraseña incorrectos");
                return "login";
            }
        } catch (UsernameNotFoundException e) {
            model.addAttribute("error", "Nombre de usuario o contraseña incorrectos");
            return "login";
        }
    }

    //---------------------------------------------------------------------------------------

    @GetMapping("/register")
    public String registro(Model model) {
        try {
            Users user = userService.registro();
            model.addAttribute("REGISTRO", user);
            return "register";
        } catch (Exception e) {
            return "register";
        }
    }

    @PostMapping("/register")
    public String registro(@ModelAttribute Users user) {
        try {
            String encodedPassword = passwordEncoder.encode(user.getUserPassword());
            user.setUserPassword(encodedPassword);

            userService.registerNewUser(user);

            return "redirect:/login";
        } catch (Exception e) {
            return "register";
        }
    }

    //---------------------------------------------------------------------------------------

    @GetMapping("/service")
    public String service(Model model) {
        return "service";
    }
}
