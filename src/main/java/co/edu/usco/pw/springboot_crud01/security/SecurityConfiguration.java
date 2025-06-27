package co.edu.usco.pw.springboot_crud01.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import co.edu.usco.pw.springboot_crud01.userol.UserService;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // Páginas públicas
                .antMatchers("/", "/login", "/register", "/resources/**", "/h2-console/**").permitAll()

                // Páginas accesibles para cualquier usuario logueado (normal o admin)
                .antMatchers("/welcome").hasAnyRole("USER", "ADMIN")

                // Panel solo visible para admin
                .antMatchers("/admin/**", "/welcome/admin", "/list-pets", "/add-pet", "/update-pet", "/delete-pet",
                        "/list-products", "/add-product", "/update-product", "/delete-product")
                .hasRole("ADMIN")

                // Bloquea cualquier otra ruta que no esté arriba
                .anyRequest().authenticated()

                .and()
                // Login controlado por Spring
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/welcome", true)
                .permitAll()

                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}