package ma.enset.patientsmvc.sec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/").permitAll() // Permet l'accès libre à la page d'accueil
                        .requestMatchers("/admin/**").hasRole("ADMIN") // Seuls les admins ont accès
                        .requestMatchers("/user/**").hasRole("USER") // Seuls les utilisateurs ont accès
                        .requestMatchers("/index/**").hasAnyRole("USER", "ADMIN") // Autoriser les admins et les utilisateurs
                        .anyRequest().authenticated() // Tous les autres doivent être connectés

                )
                .exceptionHandling(exception -> exception
                        .accessDeniedPage("/403") // Redirige les accès refusés vers "/403"
                )
                .formLogin();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin123")) // Mot de passe encodé pour "admin"
                .roles("ADMIN")
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("password")) // Mot de passe encodé
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin,user);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
