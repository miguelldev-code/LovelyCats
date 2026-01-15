package miguel.lovelycats.pets;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import miguel.lovelycats.service.UploadFileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;
    private final UploadFileService uploadFileService;

    @GetMapping({ "/adopt", "/list-pets" })
    public String listPets(Model model) {
        model.addAttribute("pets", petService.getAllPets());
        return "adopt";
    }

    @GetMapping("/pet-detail")
    public String petDetail(@org.springframework.web.bind.annotation.RequestParam Long id, Model model) {
        petService.getPetById(id).ifPresent(pet -> model.addAttribute("pet", pet));
        return "pet-detail";
    }

    @GetMapping("/adoption-form")
    public String adoptionForm(@org.springframework.web.bind.annotation.RequestParam Long id, Model model) {
        petService.getPetById(id).ifPresent(pet -> model.addAttribute("pet", pet));
        return "adoption-form";
    }

    // Compatibilidad
    @GetMapping("/adopte")
    public String redirectAdopt() {
        return "redirect:/adopt";
    }

    @GetMapping("/add-pet")
    public String showAddPet(Model model) {
        model.addAttribute("pet", new Pet());
        return "pet-form";
    }

    // Más métodos CRUD se agregarían aquí si fueran necesarios
}
