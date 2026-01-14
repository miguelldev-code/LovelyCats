package miguel.lovelycats.userol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolService rolService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User getData(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    // Método legacy o para inicialización
    public User registro() {
        if (userRepository.findByEmail("miguelldev").isPresent()) {
            return userRepository.findByEmail("miguelldev").get();
        }

        String hashedPassword = passwordEncoder.encode("79199122");
        Role adminRole = rolService.getOrCreateAdminRole();

        User usuario = new User("Miguel", "Ortiz", "miguelldev", hashedPassword, Arrays.asList(adminRole));
        return userRepository.save(usuario);
    }

    // Nuevo Admin por defecto
    public void createDefaultAdmin() {
        String email = "admin@lovelycats.com";
        if (userRepository.findByEmail(email).isEmpty()) {
            Role adminRole = rolService.getOrCreateAdminRole();
            User admin = new User();
            admin.setFirstName("Admin");
            admin.setLastName("System");
            admin.setEmail(email);
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRoles(Arrays.asList(adminRole));
            userRepository.save(admin);
            System.out.println("ADMIN USER CREATED: " + email + " / admin123");
        }
    }

    public User registerNewUser(User user) {
        Role userRole = rolService.getOrCreateUserRole();
        user.setRoles(Arrays.asList(userRole));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public List<User> buscarTodos() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario o contraseña no válidos"));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                mapRoles(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRoles(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
