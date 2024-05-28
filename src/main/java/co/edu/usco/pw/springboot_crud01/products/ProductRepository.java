package co.edu.usco.pw.springboot_crud01.products;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByUserName(String user);
}
