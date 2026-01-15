package miguel.lovelycats.products;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProductByUser(String user) {
        return productRepository.findByUserName(user);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public void addProduct(String nameProduct, String description, Long price, String image) {
        // Nota: Price cambiado a Long según nueva entidad
        Product product = new Product();
        product.setNameProduct(nameProduct);
        product.setDescription(description);
        product.setPrice(price);
        product.setImage(image);
        productRepository.save(product);
    }

    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findByNameProductContainingIgnoreCase(String name) {
        return productRepository.findByNameProductContainingIgnoreCase(name);
    }

    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }
}
