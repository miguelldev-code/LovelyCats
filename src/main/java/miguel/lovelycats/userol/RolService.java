package miguel.lovelycats.userol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {

    @Autowired
    private RoleRepository roleRepository;

    public Role findRoleByName(String roleName) {
        return roleRepository.findByName(roleName);
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public Role getOrCreateUserRole() {
        return getOrCreateRole("ROLE_USER");
    }

    public Role getOrCreateAdminRole() {
        return getOrCreateRole("ROLE_ADMIN");
    }

    private Role getOrCreateRole(String roleName) {
        Role role = roleRepository.findByName(roleName);
        if (role == null) {
            role = new Role(roleName);
            roleRepository.save(role);
        }
        return role;
    }
}
