package miguel.lovelycats.userol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    // Método legacy para mantener compatibilidad lógica si se usa en otros lados,
    // pero redirigiendo a email
    default User findByUserUser(String username) {
        return findByEmail(username).orElse(null);
    }
}
