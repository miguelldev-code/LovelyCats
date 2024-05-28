package co.edu.usco.pw.springboot_crud01.userol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolService rolService;

    public Users getData(String user) {
        return userRepository.findByUserUser(user);
    }

    //Registro del admin
    public Users registro() {
        Users usuario = new Users("Miguel", "Ortiz", "miguelldev", "79199122",
                Arrays.asList(new rol("ROLE_ADMIN")));
        return userRepository.save(usuario);
    }

    public Users registerNewUser(Users users) {
        rol userRole = rolService.findRoleByName("ROLE_USER");

        Users newUser = new Users(
                users.getUserNombre(),
                users.getUserApellido(),
                users.getUserUser(),
                users.getUserPassword(),
                Arrays.asList(userRole)
        );

        return userRepository.save(newUser);
    }

    @Override
    public List<Users> buscarTodos() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUserUser(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario o contraseña no válidos");
        }

        return new User(user.getUserUser(), user.getUserPassword(), mapRoles(user.getRoles()));
    }

    // Mapeo de rol
    private Collection<? extends GrantedAuthority> mapRoles(Collection<rol> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRolNombre())).collect(Collectors.toList());
    }
}
