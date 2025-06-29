package miguel.lovelycats.userol;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserDetService extends UserDetailsService {

    public List<Users> buscarTodos();

}
