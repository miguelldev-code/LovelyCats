package miguel.lovelycats.products;

import java.util.Optional;
import java.util.List;


public interface IProductService {

    List<Product> getProductByUser(String user);

    Optional<Product> getProductById(long id);

    void updateProduct(Product product);

    void addProduct(String nameProduct, String description, String price, String image);

    void deleteProduct(long id);

    void saveProduct(Product product);


}
