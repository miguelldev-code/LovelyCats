package miguel.lovelycats.userol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<rol, Long> {
    rol findByRolNombre(String rolNombre);
}
