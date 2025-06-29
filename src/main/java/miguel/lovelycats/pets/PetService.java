package miguel.lovelycats.pets;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService implements IPetService {

    @Autowired
    private PetRepository petRepository;

    @Override
    public List<Pet> getPetsByUser(String user) {
        return petRepository.findByUserName(user);
    }

    @Override
    public Optional<Pet> getPetById(long id) {
        return petRepository.findById(id);
    }

    //
    @Override
    public void updatePet(Pet pet) {
        petRepository.save(pet);
    }

    @Override
    public void addPet(String name, String namePet, int age, String gender, String description, String status, Date adoptionDate, String image, boolean isDone) {
        petRepository.save(new Pet(name, namePet, age, gender, description, status, adoptionDate, image, isDone));
    }

    public void deletePet(long id) {
        Optional<Pet> pet = petRepository.findById(id);
        if (pet.isPresent()) {
            petRepository.delete(pet.get());
        }
    }

    @Override
    public void savePet(Pet pet) {
        petRepository.save(pet);
    }
}
