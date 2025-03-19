package com.jarvis.ultron.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/swagger-ui.html",
                                "/api/health" // Allow public access to health check
                        ).permitAll()
                        .anyRequest().authenticated() // Secure all other endpoints
                )
                .csrf(csrf -> csrf.disable()) // Disable CSRF for non-browser clients
                .httpBasic(httpBasic -> httpBasic.disable()) // Disable basic auth
                .logout(logout -> logout.disable()); // Disable logout functionality if not needed

        return http.build();
    }
}