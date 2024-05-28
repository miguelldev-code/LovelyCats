package co.edu.usco.pw.springboot_crud01.userol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {

    @Autowired
    private RoleRepository roleRepository;

    // Método para encontrar un rol por su nombre
    public rol findRoleByName(String roleName) {
        return roleRepository.findByRolNombre(roleName);
    }

    // Método para guardar un nuevo rol
    public rol saveRole(rol role) {
        return roleRepository.save(role);
    }
}
