package miguel.lovelycats.cart;

import miguel.lovelycats.products.ProductService;
import miguel.lovelycats.products.Product;
import jakarta.servlet.http.HttpSession; // javax -> jakarta
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final ProductService productService;

    @GetMapping
    public String viewCart(Model model, HttpSession session) {
        List<CartItem> cart = getCartFromSession(session);
        model.addAttribute("cart", cart);
        model.addAttribute("total", calculateTotal(cart));
        return "cart"; // src/main/resources/templates/cart.html
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable long id, HttpSession session) {
        Optional<Product> productOpt = productService.getProductById(id);
        if (productOpt.isPresent()) {
            List<CartItem> cart = getCartFromSession(session);
            Product product = productOpt.get();

            boolean exists = false;
            for (CartItem item : cart) {
                if (item.getProduct().getId() == product.getId()) { // == para primitivos/wrapper
                    item.setQuantity(item.getQuantity() + 1);
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                cart.add(new CartItem(product, 1));
            }
        }
        return "redirect:/products";
    }

    @GetMapping("/remove/{id}")
    public String removeFromCart(@PathVariable long id, HttpSession session) {
        List<CartItem> cart = getCartFromSession(session);
        cart.removeIf(item -> item.getProduct().getId() == id);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(HttpSession session) {
        session.setAttribute("cart", new ArrayList<CartItem>());
        return "redirect:/products?checkout=success";
    }

    @SuppressWarnings("unchecked")
    private List<CartItem> getCartFromSession(HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    private double calculateTotal(List<CartItem> cart) {
        return cart.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }
}
