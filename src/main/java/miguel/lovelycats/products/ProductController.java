package miguel.lovelycats.products;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import miguel.lovelycats.service.UploadFileService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.MalformedURLException;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final UploadFileService uploadFileService;

    @GetMapping({ "/products", "/list-products" })
    public String listProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    // Compatibilidad
    @GetMapping("/vsc-product")
    public String redirectVsc() {
        return "redirect:/products";
    }

    @GetMapping("/product-detail")
    public String productDetail(@RequestParam Long id, Model model) {
        productService.getProductById(id).ifPresent(p -> model.addAttribute("product", p));
        return "product-detail";
    }

    // Imagenes
    @GetMapping("/uploads/product/{filename:.+}")
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

    @GetMapping("/add-product")
    public String showAddProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    // Simplificado
}
