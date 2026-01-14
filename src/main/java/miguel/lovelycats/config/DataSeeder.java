package miguel.lovelycats.config;

import miguel.lovelycats.pets.Pet;
import miguel.lovelycats.pets.PetRepository;
import miguel.lovelycats.products.Product;
import miguel.lovelycats.products.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final PetRepository petRepository;

    public DataSeeder(ProductRepository productRepository, PetRepository petRepository) {
        this.productRepository = productRepository;
        this.petRepository = petRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        seedProducts();
        seedPets();
    }

    private void seedProducts() {
        if (productRepository.count() == 0) {
            List<Product> products = new ArrayList<>();
            products.add(new Product(0, "admin@lovelycats.com", "Comida Premium Gato",
                    "Alimento balanceado alta calidad", 50000L, "food.jpg"));
            products.add(new Product(0, "admin@lovelycats.com", "Rascador Torre", "Rascador de 3 niveles", 120000L,
                    "scratcher.jpg"));
            products.add(new Product(0, "admin@lovelycats.com", "Juguete Ratón", "Ratón de peluche con catnip", 15000L,
                    "mouse.jpg"));
            products.add(new Product(0, "admin@lovelycats.com", "Cama Suave", "Cama acolchada para gatos", 80000L,
                    "bed.jpg"));
            products.add(new Product(0, "admin@lovelycats.com", "Collar Reflectivo", "Collar de seguridad nocturna",
                    25000L, "collar.jpg"));
            products.add(
                    new Product(0, "admin@lovelycats.com", "Arena Aglomerante", "Bolsa de 10kg", 45000L, "litter.jpg"));
            products.add(new Product(0, "admin@lovelycats.com", "Fuente de Agua", "Fuente eléctrica silenciosa", 90000L,
                    "fountain.jpg"));
            products.add(new Product(0, "admin@lovelycats.com", "Transportadora", "Caja transportadora plástica",
                    70000L, "carrier.jpg"));
            products.add(new Product(0, "admin@lovelycats.com", "Cepillo Carda", "Cepillo para eliminar pelo muerto",
                    20000L, "brush.jpg"));
            products.add(new Product(0, "admin@lovelycats.com", "Snacks Salmon", "Premios sabor salmón", 12000L,
                    "snacks.jpg"));

            productRepository.saveAll(products);
            System.out.println("DATA SEEDER: 10 Products Created");
        }
    }

    private void seedPets() {
        if (petRepository.count() == 0) {
            List<Pet> pets = new ArrayList<>();
            // Pet(id, userName, namePet, age, gender, description, status, adoptionDate,
            // image)
            // Note: id is auto-generated

            Pet p1 = new Pet();
            p1.setUserName("admin@lovelycats.com");
            p1.setNamePet("Michi");
            p1.setAge(2);
            p1.setGender("M");
            p1.setDescription("Gato juguetón y cariñoso");
            p1.setStatus("Disponible");
            p1.setImage("cat1.jpg");
            pets.add(p1);

            Pet p2 = new Pet();
            p2.setUserName("admin@lovelycats.com");
            p2.setNamePet("Luna");
            p2.setAge(1);
            p2.setGender("H");
            p2.setDescription("Gatita tranquila");
            p2.setStatus("Disponible");
            p2.setImage("cat2.jpg");
            pets.add(p2);

            Pet p3 = new Pet();
            p3.setUserName("admin@lovelycats.com");
            p3.setNamePet("Simba");
            p3.setAge(4);
            p3.setGender("M");
            p3.setDescription("Le gusta dormir mucho");
            p3.setStatus("Disponible");
            p3.setImage("cat3.jpg");
            pets.add(p3);

            Pet p4 = new Pet();
            p4.setUserName("admin@lovelycats.com");
            p4.setNamePet("Nala");
            p4.setAge(3);
            p4.setGender("H");
            p4.setDescription("Muy sociable");
            p4.setStatus("Disponible");
            p4.setImage("cat4.jpg");
            pets.add(p4);

            Pet p5 = new Pet();
            p5.setUserName("admin@lovelycats.com");
            p5.setNamePet("Garfield");
            p5.setAge(5);
            p5.setGender("M");
            p5.setDescription("Ama la lasaña (y el atún)");
            p5.setStatus("Disponible");
            p5.setImage("cat5.jpg");
            pets.add(p5);

            Pet p6 = new Pet();
            p6.setUserName("admin@lovelycats.com");
            p6.setNamePet("Pelusa");
            p6.setAge(1);
            p6.setGender("H");
            p6.setDescription("Pequeña y adorable");
            p6.setStatus("Disponible");
            p6.setImage("cat6.jpg");
            pets.add(p6);

            petRepository.saveAll(pets);
            System.out.println("DATA SEEDER: 6 Pets Created");
        }
    }
}
