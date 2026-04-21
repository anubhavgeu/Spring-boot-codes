package com.substring.foodie.food.service.external;

import com.substring.foodie.food.dto.RestaurantDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class RestWebClientService {
    private WebClient webClient;
    public RestWebClientService(WebClient webClient) {
        this.webClient = webClient;
    }
    public RestaurantDto getById(String restaurantId) {
        return webClient
                .get()
                .uri("/api/v1/restaurants/{id}", restaurantId)
                .retrieve()
                .bodyToMono(RestaurantDto.class)
                .block();
    }

    public List<RestaurantDto> getAllRestaurants() {
        return webClient
                .get()
                .uri("/api/v1/restaurants/")
                .retrieve()
                .bodyToFlux(RestaurantDto.class)
                .collectList()
                .block();
    }

    public RestaurantDto createRestaurant(RestaurantDto restaurantDto) {
        return webClient
                .post()
                .uri("/api/v1/restaurants/")
                .bodyValue(restaurantDto)
                .retrieve()
                .bodyToMono(RestaurantDto.class)
                .block();
    }

    // get by id - flux
    public Mono<RestaurantDto> getResById(String restaurantId) {
        return webClient
                .get()
                .uri("/api/v1/restaurants/{id}",restaurantId)
                .retrieve()
                .bodyToMono(RestaurantDto.class);
    }

    public Flux<RestaurantDto> getAllRestaurantsNonBlocking() {
        return webClient
                .get()
                .uri("/api/v1/restaurants")
                .retrieve()
                .bodyToFlux(RestaurantDto.class);
    }
}
