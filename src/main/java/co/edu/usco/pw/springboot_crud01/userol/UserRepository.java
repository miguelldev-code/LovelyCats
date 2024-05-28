package co.edu.usco.pw.springboot_crud01.userol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @Query("SELECT u FROM Users u WHERE u.UserUser = ?1")
    public Users findByUserUser(String username);

    @Query("SELECT u FROM Users u WHERE  u.UserUser = ?1 and u.UserPassword=?2")
    public Users findUsersByUserUserAndUserPassword(String user, String password);


}
