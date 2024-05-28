package co.edu.usco.pw.springboot_crud01.pets;


import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IPetService {

    List<Pet> getPetsByUser(String user);

    Optional<Pet> getPetById(long id);

    void updatePet(Pet pet);

    void addPet(String name, String namePet, int age, String gender, String description, String status, Date adoptionDate, String image, boolean isDone);

    void deletePet(long id);

    void savePet(Pet pet);


}
