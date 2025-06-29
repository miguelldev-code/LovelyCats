package miguel.lovelycats.pets;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String userName;
    private String namePet;
    private int age;
    private String gender;
    private String description;
    private String status;
    private Date adoptionDate;
    private String image;


    public Pet() {
        super();
    }

    public Pet(long id, String user, String namePet, int age, String gender, String description, String status, Date adoptionDate, String image, boolean isDone) {
        this.id = id;
        this.userName = user;
        this.namePet = namePet;
        this.age = age;
        this.gender = gender;
        this.description = description;
        this.status = status;
        this.adoptionDate = adoptionDate;
        this.image = image;

    }


    public Pet(String name, String namePet, int age, String gender, String description, String status, Date adoptionDate, String image, boolean isDone) {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNamePet() {
        return namePet;
    }

    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAdoptionDate() {
        return adoptionDate;
    }

    public void setAdoptionDate(Date adoptionDate) {
        this.adoptionDate = adoptionDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
