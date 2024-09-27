package com.example.jwt.core.security;

import com.example.jwt.core.security.helpers.JwtProperties;
import com.example.jwt.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

/**
 * Konfiguriert die Web-Sicherheit für die Anwendung.
 */
@Configuration
@EnableMethodSecurity
@EnableJpaAuditing(auditorAwareRef = "userAware")
@RequiredArgsConstructor
@Slf4j
public class WebSecurityConfig {

  private final UserService userService;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;
  private final JwtProperties jwtProperties;

  /**
   * Definiert die Sicherheitsfilterkette.
   *
   * @param http das HttpSecurity-Objekt zum Konfigurieren der Sicherheitsfilterkette
   * @return die konfigurierte SecurityFilterChain
   * @throws Exception falls eine Konfigurationsfehler auftritt
   */
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    log.info("Konfiguriere Sicherheitsfilterkette");

    return http
            .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers(HttpMethod.POST, "/users/login").permitAll()
                    .requestMatchers(HttpMethod.POST, "/users/register").permitAll()
                    .anyRequest().authenticated()
            )
            .addFilterAfter(
                    new CustomAuthenticationFilter(
                            new AntPathRequestMatcher("/users/login", "POST"),
                            authenticationManager(),
                            jwtProperties
                    ),
                    UsernamePasswordAuthenticationFilter.class
            )
            .addFilterAfter(
                    new CustomAuthorizationFilter(userService, jwtProperties),
                    UsernamePasswordAuthenticationFilter.class
            )
            .sessionManagement(session -> session
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .cors(cors -> cors
                    .configurationSource(corsConfigurationSource())
            )
            .csrf(AbstractHttpConfigurer::disable)
            .build();
  }

  /**
   * Konfiguriert die CORS-Einstellungen.
   *
   * @return die CorsConfigurationSource
   */
  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    log.info("Konfiguriere CORS");

    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(List.of("*"));
    configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
    configuration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
    configuration.setExposedHeaders(List.of("Authorization"));

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);

    return source;
  }

  /**
   * Definiert den AuthenticationManager mit einem DaoAuthenticationProvider.
   *
   * @return der konfigurierte AuthenticationManager
   */
  @Bean
  public AuthenticationManager authenticationManager() {
    log.info("Erstelle AuthenticationManager");

    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setPasswordEncoder(bCryptPasswordEncoder);
    provider.setUserDetailsService(userService);

    return new ProviderManager(provider);
  }
}
