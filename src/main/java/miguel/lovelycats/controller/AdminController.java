package miguel.lovelycats.controller;

import miguel.lovelycats.userol.UserService;
import miguel.lovelycats.products.ProductService;
import miguel.lovelycats.pets.PetService;
import miguel.lovelycats.products.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;
    private final ProductService productService;
    private final PetService petService;

    @GetMapping
    public String adminIndex() {
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.buscarTodos());
        return "admin/users";
    }

    @GetMapping("/users/create")
    public String createUser(Model model) {
        model.addAttribute("user", new miguel.lovelycats.userol.User());
        return "admin/user-form";
    }

    @GetMapping("/users/edit/{id}")
    public String editUser(@org.springframework.web.bind.annotation.PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "admin/user-form";
    }

    @org.springframework.web.bind.annotation.PostMapping("/users/save")
    public String saveUser(miguel.lovelycats.userol.User user) {
        // En un caso real, manejar password y roles con más cuidado
        if (user.getId() != null) {
            // Update simplificado
            miguel.lovelycats.userol.User existing = userService.getUserById(user.getId());
            existing.setFirstName(user.getFirstName());
            existing.setLastName(user.getLastName());
            existing.setEmail(user.getEmail());
            // No actualizamos password aqui por simplicidad en este paso
            userService.updateUser(existing);
        } else {
            userService.registerNewUser(user);
        }
        return "redirect:/admin/users";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@org.springframework.web.bind.annotation.PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }

    // Products
    @GetMapping("/products")
    public String listAdminProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "admin/products";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@org.springframework.web.bind.annotation.PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/admin/products";
    }

    // Pets
    @GetMapping("/pets")
    public String listAdminPets(Model model) {
        model.addAttribute("pets", petService.getAllPets());
        return "admin/pets";
    }

    @GetMapping("/pets/delete/{id}")
    public String deletePet(@org.springframework.web.bind.annotation.PathVariable Long id) {
        petService.deletePet(id);
        return "redirect:/admin/pets";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Statistics
        long totalUsers = userService.countUsers();
        long totalProducts = productService.findAll().size(); // In a real app, use count()
        long totalPets = petService.getAllPets().size(); // In a real app, use count()

        // Calculate Inventory Value
        List<Product> products = productService.findAll();
        double totalInventoryValue = products.stream()
                .mapToDouble(Product::getPrice)
                .sum();

        model.addAttribute("totalUsers", totalUsers);
        model.addAttribute("totalProducts", totalProducts);
        model.addAttribute("totalPets", totalPets);
        model.addAttribute("totalInventoryValue", totalInventoryValue);

        return "admin/dashboard";
    }
}
