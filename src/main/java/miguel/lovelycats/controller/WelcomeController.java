package miguel.lovelycats.controller;

import miguel.lovelycats.userol.User;
import miguel.lovelycats.userol.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class WelcomeController {

    private final UserService userService;
    private final miguel.lovelycats.products.ProductService productService;
    private final miguel.lovelycats.pets.PetService petService;

    @GetMapping("/")
    public String welcome(Model model) {
        // Mostrar los primeros 4 productos como "Destacados"
        model.addAttribute("featuredProducts", productService.findAll().stream().limit(4).toList());
        // Mostrar las primeras 4 mascotas como "Recientes"
        model.addAttribute("recentPets", petService.getAllPets().stream().limit(4).toList());
        return "welcome";
    }

    @GetMapping("/welcome")
    public String welcomeAlias() {
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        try {
            userService.registerNewUser(user);
            return "redirect:/login?success";
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            return "redirect:/register?error=duplicate";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/register?error=generic";
        }
    }

    @GetMapping("/service")
    public String service() {
        return "service";
    }

    @GetMapping("/service/veterinary")
    public String serviceVeterinary() {
        return "service-veterinary";
    }

    @GetMapping("/service/boarding")
    public String serviceBoarding() {
        return "service-boarding";
    }

    @GetMapping("/service/spa")
    public String serviceSpa() {
        return "service-spa";
    }

    @GetMapping("/service/nutrition")
    public String serviceNutrition() {
        return "service-nutrition";
    }
}
