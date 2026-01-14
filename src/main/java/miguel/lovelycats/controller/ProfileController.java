package miguel.lovelycats.controller;

import miguel.lovelycats.userol.User;
import miguel.lovelycats.userol.UserService;
import miguel.lovelycats.service.UploadFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class ProfileController {

    private final UserService userService;
    private final UploadFileService uploadFileService;

    @GetMapping("/profile")
    public String profile(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getData(auth.getName());
        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("/profile")
    public String updateProfile(@ModelAttribute User user, @RequestParam("file") MultipartFile file) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.getData(auth.getName());

        // Update basic info
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());

        // Update Image
        if (!file.isEmpty()) {
            try {
                // Delete old image if exists and not default? (Optional logic)
                String uniqueFilename = uploadFileService.copy(file);
                currentUser.setImage(uniqueFilename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        userService.updateUser(currentUser);
        return "redirect:/profile?success";
    }

    // Serve User Images
    @GetMapping("/uploads/user/{filename:.+}")
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        try {
            Resource file = uploadFileService.load(filename);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                    .body(file);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
