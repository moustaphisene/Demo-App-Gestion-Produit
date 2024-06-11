package sn.xdshoot.demoinventoryservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {
    private JwtAuthConverter jwtAuthConverter;

    public SecurityConfiguration(JwtAuthConverter jwtAuthConverter) {
        this.jwtAuthConverter = jwtAuthConverter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf->csrf.disable())
                .cors(Customizer.withDefaults())
                .headers(h-> h.frameOptions(fo->fo.disable()))
                .authorizeHttpRequests(auth -> auth.requestMatchers("/swagger-ui.html","/swagger-ui/**", "/v3/**","/h2-console/**").permitAll()) //Permettre l'authentification a tous le momnde sur cette patte
                //.authorizeHttpRequests(ar->ar.requestMatchers("/api/products").hasAuthority("ADMIN"))
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .oauth2ResourceServer(o2rs->o2rs.jwt(jwt->jwt.jwtAuthenticationConverter(jwtAuthConverter)))
                .build();

    }
    @Bean
    UrlBasedCorsConfigurationSource corsConfiguration(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setExposedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",configuration);
        return source;

    }

}
