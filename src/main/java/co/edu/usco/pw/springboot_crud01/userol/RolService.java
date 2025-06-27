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

    public rol getOrCreateUserRole() {
        rol role = roleRepository.findByRolNombre("ROLE_USER");
        if (role == null) {
            role = new rol("ROLE_USER");
            roleRepository.save(role);
        }
        return role;
    }

    public rol getOrCreateAdminRole() {
        rol role = roleRepository.findByRolNombre("ROLE_ADMIN");
        if (role == null) {
            role = new rol("ROLE_ADMIN");
            roleRepository.save(role);
        }
        return role;
    }


}
