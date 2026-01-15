package miguel.lovelycats.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> { // Cambiado ID a Long
    List<Product> findByUserName(String user);

    // Búsqueda por nombre
    List<Product> findByNameProductContainingIgnoreCase(String name);

    // Filtrado por categoría
    List<Product> findByCategory(String category);

    // Filtrado por precio (opcional, para el futuro)
    List<Product> findByPriceBetween(Long min, Long max);
}
