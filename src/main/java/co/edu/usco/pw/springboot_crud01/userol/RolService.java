package co.edu.usco.pw.springboot_crud01.userol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {

    @Autowired
    private RoleRepository roleRepository;

    public rol findRoleByName(String roleName) {
        return roleRepository.findByRolNombre(roleName);
    }

    public rol saveRole(rol role) {
        return roleRepository.save(role);
    }
}
