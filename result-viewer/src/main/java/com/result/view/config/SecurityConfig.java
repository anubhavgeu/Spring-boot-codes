package com.result.view.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
//        httpSecurity.authorizeHttpRequests(httpRequest -> {
//            httpRequest.requestMatchers("/admin/add-result").authenticated();
//            httpRequest.requestMatchers("/admin/add-result-action").authenticated();
//            httpRequest.anyRequest().permitAll();
//        });
//        httpSecurity.authorizeHttpRequests(httpRequest ->
//            httpRequest.requestMatchers("/admin/add-result").authenticated()
//                    .requestMatchers("/admin/add-result-action").authenticated()
//                    .anyRequest().permitAll()
//        ).formLogin(Customizer.withDefaults());
        httpSecurity.authorizeHttpRequests(httpRequest ->
                httpRequest.requestMatchers("/admin/add-result").authenticated()
                        .requestMatchers("/admin/add-result-action").authenticated()
                        .anyRequest().permitAll()
        ).formLogin(formLogin ->
            formLogin.loginPage("/user-login")
                    .loginProcessingUrl("/do-login")
                    .successForwardUrl("/admin/add-result")
                    .failureForwardUrl("/user-login")
                    .permitAll(true)
        )
                .logout(logout ->
                        logout.logoutUrl("/user-logout")
                                .logoutSuccessUrl("/user-login?logout")
                                .permitAll())
        ;
        return httpSecurity.build();
    }
}
