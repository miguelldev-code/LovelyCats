package miguel.lovelycats;

import miguel.lovelycats.userol.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LovelyCatsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LovelyCatsApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(UserService userService) {
        return args -> {
            userService.createDefaultAdmin();
        };
    }

}
