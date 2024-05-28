package co.edu.usco.pw.springboot_crud01.products;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> getProductByUser(String user) {
        return productRepository.findByUserName(user);
    }

    @Override
    public Optional<Product> getProductById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void addProduct(String nameProduct, String description, String price, String image) {
        productRepository.save(new Product(nameProduct, description, price, image));
    }

    @Override
    public void deleteProduct(long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.delete(product.get());
        }

    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}
