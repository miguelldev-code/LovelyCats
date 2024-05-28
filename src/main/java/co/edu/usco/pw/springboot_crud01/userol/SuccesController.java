package co.edu.usco.pw.springboot_crud01.userol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.List;

@Controller
public class SuccesController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/welcome")
    public String welcomeUser(Model model) {
        String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        Users userInfo = userService.getData(currentUserName);
        Collection<rol> roles = userInfo.getRoles();

        for (rol rol : roles) {
            model.addAttribute("rol", rol.getRolNombre());
        }

        model.addAttribute("usuario", userInfo);
        return "welcome";
    }

    @GetMapping("/welcome/admin")
    public String welcomeAdmin(Model model) {
        List<Users> todos = userRepository.findAll();
        model.addAttribute("usuarios", todos);
        return "admin";
    }
}
