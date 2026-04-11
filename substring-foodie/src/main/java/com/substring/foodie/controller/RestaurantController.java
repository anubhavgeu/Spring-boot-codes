package com.substring.foodie.controller;

import com.substring.foodie.dto.FileData;
import com.substring.foodie.dto.RestaurantDto;
import com.substring.foodie.service.FileService;
import com.substring.foodie.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {
    @Value("${restaurant.file.path}")
    private String bannerFolderPath;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final RestaurantService restaurantService;
    public RestaurantController(RestaurantService restaurantService) {

        this.restaurantService = restaurantService;
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDto> addRestaurant(@RequestBody RestaurantDto restaurantDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurantService.addRestaurant(restaurantDto));
    }

    @PutMapping("/updateRestaurant/{restaurantId}")
    public ResponseEntity<RestaurantDto> updateRestaurant(@PathVariable String restaurantId, @RequestBody RestaurantDto restaurantDto) {
        return ResponseEntity.status(HttpStatus.OK).body(restaurantService.updateRestaurant(restaurantDto, restaurantId));
    }

    @GetMapping("/getAllRestaurant")
    public ResponseEntity<Page<RestaurantDto>> getAllRestaurant(
            @RequestParam(value = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size,
            @RequestParam(value = "sortBy", required = false, defaultValue = "name") String sortBy,
            @RequestParam(value = "sortDir", required = false, defaultValue = "desc") String sortDir
    ) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, size, sort);
        return ResponseEntity.ok(restaurantService.getRestaurants(pageable));
    }


    @GetMapping("/getByName/{keyword}")
    public ResponseEntity<List<RestaurantDto>> getRestaurantByName(@PathVariable String keyword) {
        return ResponseEntity.ok(restaurantService.searchByName(keyword));
    }

    @GetMapping("/getOpenRestaurant")
    public ResponseEntity<Page<RestaurantDto>> getOpenRestaurant(
            @RequestParam(value = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size,
            @RequestParam(value = "sortBy", required = false, defaultValue = "name") String sortBy,
            @RequestParam(value = "sortDir", required = false, defaultValue = "asc") String sortDir
    ) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, size, sort);
        return ResponseEntity.ok(restaurantService.getOpenRestaurants(pageable));
    }

    @GetMapping("/getRestaurantById/{restaurantId}")
    public ResponseEntity<RestaurantDto> getRestaurantById(@PathVariable String restaurantId) {
        return ResponseEntity.ok(restaurantService.getRestaurantById(restaurantId));
    }

    @PostMapping("/upload-banner/{restaurantId}")
    public ResponseEntity<?> uploadFile(
            @RequestParam("banner") MultipartFile banner,
            @PathVariable String restaurantId
    ) throws IOException {
        logger.info("Uploading banner file: {}", banner.getOriginalFilename());
        logger.info("Get content type: {}", banner.getContentType());
        // call file service
        RestaurantDto restaurantDto = restaurantService.uploadBanner(banner, restaurantId);

        return new ResponseEntity<>(restaurantDto, HttpStatus.OK);
    }


    @GetMapping("/{restaurantId}/banner")
    public ResponseEntity<Resource> serveFile(@PathVariable String restaurantId) throws MalformedURLException, FileNotFoundException {
        RestaurantDto restaurantDto = restaurantService.getRestaurantById(restaurantId);
        String fullPath = bannerFolderPath + restaurantDto.getBanner();
        Path path = Paths.get(fullPath);
        Resource resource = new UrlResource(path.toUri());
        if (resource.exists()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(resource);
        }
        else {
            throw new FileNotFoundException("File not found " + fullPath);
        }
    }
}
