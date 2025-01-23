package org.example.exercicesreactifs.exo10.jwt.config;


import org.example.exercicesreactifs.exo10.jwt.JwtAuthentificationFilter;
import org.example.exercicesreactifs.exo10.jwt.JwtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    private final JwtService jwtService;

    public SecurityConfig(final JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        AuthenticationWebFilter jwtWebFilter = new AuthenticationWebFilter(authenticationManager());
        jwtWebFilter.setServerAuthenticationConverter(new JwtAuthentificationFilter(jwtService));

        return http
                .authorizeExchange()
                .pathMatchers(HttpMethod.GET, "/api/rooms","/api/rooms/**").permitAll()
                .pathMatchers(HttpMethod.POST, "/api/rooms").hasRole("ADMIN")
                .pathMatchers(HttpMethod.POST, "/api/rooms/**").hasRole("ADMIN")
                .pathMatchers(HttpMethod.PUT, "/api/rooms/**").hasRole("ADMIN")
                .pathMatchers(HttpMethod.DELETE, "/api/rooms/**").hasRole("ADMIN")
                .pathMatchers("/api/auth/**").permitAll()
                .anyExchange().permitAll()
                .and()
                .addFilterAt(jwtWebFilter, SecurityWebFiltersOrder.AUTHENTICATION)
                .csrf().disable()
                .build();
    }

    @Bean
    public ReactiveAuthenticationManager authenticationManager() {
        return authentication -> {
            if (authentication instanceof UsernamePasswordAuthenticationToken) {
                return Mono.just(authentication);
            }
            return Mono.empty();
        };
    }


}
