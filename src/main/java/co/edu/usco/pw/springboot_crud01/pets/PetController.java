package co.edu.usco.pw.springboot_crud01.pets;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;

import co.edu.usco.pw.springboot_crud01.service.IUploadFileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.core.io.Resource;


@Controller
public class PetController {

    @Autowired
    private IPetService petService;

    @Autowired
    private IUploadFileService uploadFileService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date - dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }


    @RequestMapping(value = "/list-pets", method = RequestMethod.GET)
    public String showPets(ModelMap model) {
        String name = getLoggedInUserName(model);
        model.put("pet", petService.getPetsByUser(name));
        return "pets/list-pets";
    }

    private String getLoggedInUserName(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }

        return principal.toString();
    }


    @GetMapping(value = "/uploads/{filename}")
    public ResponseEntity<Resource> goImage(@PathVariable String filename) {
        Resource resource = null;
        try {
            resource = uploadFileService.load(filename);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }


    @RequestMapping(value = "/add-pet", method = RequestMethod.GET)
    public String showAddPetPage(ModelMap model) {
        model.addAttribute("pet", new Pet());
        return "pets/pet";
    }

    @RequestMapping(value = "/add-pet", method = RequestMethod.POST)
    public String addPet(ModelMap model, @Valid @ModelAttribute("pet") Pet pet, BindingResult result, @RequestParam("file") MultipartFile image, RedirectAttributes flash, SessionStatus status) throws Exception {
        if (result.hasErrors()) {
            return "pets/pet";
        } else {
            if (!image.isEmpty()) {
                if (pet.getId() > 0 && pet.getImage() != null && pet.getImage().length() > 0) {
                    uploadFileService.delete(pet.getImage());
                }
                String uniqueFileName = uploadFileService.copy(image);
                pet.setImage(uniqueFileName);
            }
            pet.setUserName(getLoggedInUserName(model));
            petService.savePet(pet);
            return "redirect:/list-pets";
        }
    }

    @RequestMapping(value = "/delete-pet", method = RequestMethod.GET)
    public String deletePet(@RequestParam long id) {
        petService.deletePet(id);
        return "redirect:/list-pets";
    }

    @RequestMapping(value = "/update-pet", method = RequestMethod.GET)
    public String showUpdatePetPage(@RequestParam long id, ModelMap model) {
        Pet pet = petService.getPetById(id).get();
        model.put("pet", pet);
        return "pets/pet";
    }

    @RequestMapping(value = "/update-pet", method = RequestMethod.POST)
    public String updatePet(ModelMap model, @Valid Pet pet, BindingResult result) {
        if (result.hasErrors()) {
            return "pets/pet";
        }
        petService.updatePet(pet);
        return "redirect:/list-pets";
    }


    @RequestMapping(value = "/adopte", method = RequestMethod.GET)
    public String showAdoptePage(ModelMap model) {
        String name = getLoggedInUserName(model);
        model.put("pet", petService.getPetsByUser(name));
        return "adopte";
    }


    @RequestMapping(value = "/add-adopte", method = RequestMethod.GET)
    public String showAddAdoptePage(ModelMap model) {
        model.addAttribute("pet", new Pet());
        return "pets/pet";
    }

    @RequestMapping(value = "/add-adopte", method = RequestMethod.POST)
    public String addAdopt(ModelMap model, @Valid Pet pet, BindingResult result) {
        if (result.hasErrors()) {
            return "pets/pet";
        }
        pet.setUserName(getLoggedInUserName(model));
        petService.savePet(pet);
        return "redirect:/adopte";
    }


}
