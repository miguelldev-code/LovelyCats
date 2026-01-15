package miguel.lovelycats.pets;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "pet")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Cambiado strategy a IDENTITY para PostgreSQL y Spring Boot 3

    private String userName; // FK lógica
    private String namePet;
    private int age;
    private String gender;
    private String description;
    private String status;
    private Date adoptionDate;
    private String image;

    // Nuevos campos para mejorar la información
    private String breed; // Raza
    private boolean vaccinated;
    private boolean sterilized;
    private String location;
}
