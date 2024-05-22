package co.edu.usco.pw.springboot_crud01.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("admin").password("admin").roles("ADMIN")
                .and()
                .withUser("student").password("student").roles("STUDENT")
                .and()
                .withUser("professor").password("professor").roles("PROFESSOR")
                .and()
                .withUser("maintenance").password("maintenance").roles("MAINTENANCE");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login", "/h2-console/**").permitAll() // Permitir acceso a ciertas URLs sin autenticación
                .antMatchers("/student/**").hasRole("STUDENT") // Solo estudiantes pueden acceder a recursos de estudiantes
                .antMatchers("/professor/**").hasRole("PROFESSOR") // Solo profesores pueden acceder a recursos de profesores
                .antMatchers("/maintenance/**").hasRole("MAINTENANCE") // Solo personal de mantenimiento puede acceder a recursos de mantenimiento
                .antMatchers("/*todo*/**").hasRole("ADMIN") // Solo el administrador puede acceder a recursos de administración
                .anyRequest().authenticated() // Cualquier otra solicitud requiere autenticación
                .and()
                .formLogin()// Esto permite que tu controlador maneje las solicitudes a /login; // Configuración de inicio de sesión basado en formulario
                .loginPage("/login")
                .loginProcessingUrl("/login");

        http.csrf().disable(); // Desactivar CSRF
        http.headers().frameOptions().disable(); // Desactivar opciones de frame para H2 Console
    }
}


