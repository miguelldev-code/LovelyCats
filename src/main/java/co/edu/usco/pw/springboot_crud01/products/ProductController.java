package co.edu.usco.pw.springboot_crud01.products;


import javax.validation.Valid;

import co.edu.usco.pw.springboot_crud01.pets.Pet;
import co.edu.usco.pw.springboot_crud01.service.IUploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.validation.Valid;
import java.net.MalformedURLException;

@Controller
public class ProductController {


    @Autowired
    private IProductService productService;

    @Autowired
    private IUploadFileService uploadFileService;

    //---------------------------------------------------------------
    @RequestMapping(value = "/list-products", method = RequestMethod.GET)
    public String showProducts(ModelMap model) {
        String name = getLoggedInUserName(model);
        model.put("product", productService.getProductByUser(name));
        return "products/list-products";
    }

    private String getLoggedInUserName(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }

        return principal.toString();
    }

    //---------------------------------------------------------------
    @GetMapping(value = "/uploads/product/{filename}")
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


    @RequestMapping(value = "/add-product", method = RequestMethod.GET)
    public String showAddProductPage(ModelMap model) {
        model.addAttribute("product", new Product());
        return "products/product";
    }

    @RequestMapping(value = "/add-product", method = RequestMethod.POST)
    public String addProduct(ModelMap model, @Valid @ModelAttribute("product") Product product, BindingResult result, @RequestParam("file") MultipartFile image, RedirectAttributes flash, SessionStatus status) throws Exception {
        if (result.hasErrors()) {
            return "products/product";
        } else {
            if (!image.isEmpty()) {
                if (product.getId() > 0 && product.getImage() != null && product.getImage().length() > 0) {
                    uploadFileService.delete(product.getImage());
                }
                String uniqueFileName = uploadFileService.copy(image);
                product.setImage(uniqueFileName);
            }
            product.setUserName(getLoggedInUserName(model));
            productService.saveProduct(product);
            return "redirect:/list-products";
        }
    }

    //---------------------------------------------------------------
    @RequestMapping(value = "/delete-product", method = RequestMethod.GET)
    public String deleteProduct(@RequestParam long id) {
        productService.deleteProduct(id);
        return "redirect:/list-products";
    }

    //---------------------------------------------------------------
    @RequestMapping(value = "/update-product", method = RequestMethod.GET)
    public String showUpdateProductPage(@RequestParam long id, ModelMap model) {
        Product product = productService.getProductById(id).get();
        model.put("product", product);
        return "products/product";
    }

    //---------------------------------------------------------------
    @RequestMapping(value = "/update-product", method = RequestMethod.POST)
    public String updateProduct(ModelMap model, @Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "products/product";
        }
        productService.updateProduct(product);
        return "redirect:/list-products";
    }


    @RequestMapping(value = "/vsc-product", method = RequestMethod.GET)
    public String showVscroducts(ModelMap model) {
        String name = getLoggedInUserName(model);
        model.put("product", productService.getProductByUser(name));
        return "vsc-product";
    }

    @RequestMapping(value = "/add-vsc-product", method = RequestMethod.GET)
    public String showAddVscProductPage(ModelMap model) {
        model.addAttribute("product", new Product());
        return "products/product";
    }

    @RequestMapping(value = "/add-vsc-product", method = RequestMethod.POST)
    public String addPVscroduct(ModelMap model, @Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "products/product";
        }
        product.setUserName(getLoggedInUserName(model));
        productService.saveProduct(product);
        return "redirect:/vsc-product";
    }


}
