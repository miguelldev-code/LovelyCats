package miguel.lovelycats.pets;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    public List<Pet> getPetsByUser(String user) {
        return petRepository.findByUserName(user);
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Optional<Pet> getPetById(long id) {
        return petRepository.findById(id);
    }

    public void updatePet(Pet pet) {
        petRepository.save(pet);
    }

    public void addPet(String namePet, int age, String gender, String description, String status, Date adoptionDate,
            String image) {
        Pet pet = new Pet();
        pet.setNamePet(namePet);
        pet.setAge(age);
        pet.setGender(gender);
        pet.setDescription(description);
        pet.setStatus(status);
        pet.setAdoptionDate(adoptionDate);
        pet.setImage(image);
        petRepository.save(pet);
    }

    public void deletePet(long id) {
        petRepository.deleteById(id);
    }

    public void savePet(Pet pet) {
        petRepository.save(pet);
    }
}
