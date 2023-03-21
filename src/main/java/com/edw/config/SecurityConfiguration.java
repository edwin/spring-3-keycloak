package com.edw.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * <pre>
 *     com.edw.config.SecurityConfiguration
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 21 Mar 2023 20:16
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private KeycloakJwtAuthenticationConverter keycloakJwtAuthenticationConverter;
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(keycloakJwtAuthenticationConverter);

        http.oauth2Login().userInfoEndpoint();

        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http
                .authorizeHttpRequests()
                            .requestMatchers("/unauthenticated").permitAll()
                            .requestMatchers("/oauth2/**").permitAll()
                            .anyRequest()
                                .authenticated();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("password")
                        .roles("USER")
                        .build();
        return new InMemoryUserDetailsManager(user);
    }
}
