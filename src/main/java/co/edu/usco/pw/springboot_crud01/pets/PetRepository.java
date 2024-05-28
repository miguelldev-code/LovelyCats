package co.edu.usco.pw.springboot_crud01.pets;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByUserName(String user);
}
