package miguel.lovelycats.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> { // Cambiado ID a Long
    List<Product> findByUserName(String user);
}
