package com.substring.foodie.food.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ProjectConfig {


//    public TestConfig
    @Bean
    @Profile("dev")
    public TestConfig testConfig() {
        return new TestConfig();
    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    @LoadBalanced // This is the magic part for the builder
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        // Use the builder injected above which now has the LoadBalancer filter
        return builder
                .baseUrl(AppConstants.RESTAURANT_SERVICE_URL) // "lb://RESTAURANT-SERVICE"[cite: 8]
                .build();
    }
}
