package com.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    private final RoleConverter roleConverter;
    public SecurityConfig(RoleConverter roleConverter) {
        this.roleConverter = roleConverter;
    }
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity) {
        serverHttpSecurity
                .cors(e->e.disable())
                .csrf(e->e.disable())
                .authorizeExchange(authorizeExchangeSpec ->
                    authorizeExchangeSpec.pathMatchers(HttpMethod.GET).permitAll()
//                            .pathMatchers("/foods/**").hasRole("ADMIN")
                            .anyExchange().authenticated()
                )
                .oauth2ResourceServer(config->config.jwt(
                        jwt -> jwt.jwtAuthenticationConverter(roleExtractor())
                ));
        return serverHttpSecurity.build();
    }

    public Converter<Jwt, Mono<AbstractAuthenticationToken>> roleExtractor() {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(roleConverter);
        return new ReactiveJwtAuthenticationConverterAdapter(jwtAuthenticationConverter);
    }
}
