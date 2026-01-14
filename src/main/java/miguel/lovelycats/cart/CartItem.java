package miguel.lovelycats.cart;

import miguel.lovelycats.products.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    private Product product;
    private int quantity;

    public double getTotalPrice() {
        if (product != null && product.getPrice() != null) {
            return product.getPrice() * quantity;
        }
        return 0.0;
    }
}
