package co.edu.usco.pw.springboot_crud01.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        // Logs para depuración
        System.out.println("Usuario autenticado: " + authentication.getName());
        System.out.println("Roles asignados: " + authorities);

        // Redirección basada en el rol
        String redirectUrl = "/welcome"; // Redirección por defecto

        for (GrantedAuthority authority : authorities) {
            String role = authority.getAuthority();
            if ("ROLE_ADMIN".equals(role)) {
                redirectUrl = "/welcome/admin";
                break; // Prioriza admin si el usuario tiene múltiples roles
            } else if ("ROLE_USER".equals(role)) {
                redirectUrl = "/welcome";
            }
        }

        response.sendRedirect(redirectUrl);
    }
}
