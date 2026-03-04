package com.substring.foodie.substring_foodie.controller;

import com.substring.foodie.substring_foodie.dto.FileData;
import com.substring.foodie.substring_foodie.dto.RestaurantDto;
import com.substring.foodie.substring_foodie.service.FileService;
import com.substring.foodie.substring_foodie.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
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
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {
    @Value("${restaurant.file.path}")
    private String bannerFolderPath;
    private Logger logger = LoggerFactory.getLogger(RestaurantController.class);

    private final RestaurantService restaurantService;
    private final FileService fileService;

    public RestaurantController(RestaurantService restaurantService, FileService fileService) {
        this.restaurantService = restaurantService;
        this.fileService = fileService;
    }

    @PostMapping("/add")
    public ResponseEntity<RestaurantDto> add(@RequestBody RestaurantDto restaurantDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurantService.add(restaurantDto));
    }

    @PutMapping("/{restaurantId}")
    public ResponseEntity<RestaurantDto> update(
            @RequestBody RestaurantDto restaurantDto,
            @PathVariable String restaurantId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(restaurantService.update(restaurantDto, restaurantId));
    }

    @GetMapping("/")
    public ResponseEntity<Page<RestaurantDto>> findAll(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size,
            @RequestParam(value = "sortBy", required = false, defaultValue = "name") String sortBy,
            @RequestParam(value = "sortDir", required = false, defaultValue = "desc") String sortDir
    ) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page,size,sort);
        return ResponseEntity.ok(restaurantService.getAll(pageable));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<RestaurantDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(restaurantService.getById(id));
    }

    @DeleteMapping("/deleteRestaurant/{id}")
    public void delete(@PathVariable String id) {
        restaurantService.delete(id);
    }

    @GetMapping("/searchByKeyword/{keyword}")
    public ResponseEntity<List<RestaurantDto>> searchByKeyword(@PathVariable String keyword) {
        return ResponseEntity.ok(restaurantService.searchByName(keyword));
    }

    @GetMapping("/getOpenRestaurant")
    public ResponseEntity<Page<RestaurantDto>> getOpenRestaurant(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size,
            @RequestParam(value = "sortBy", required = false, defaultValue = "name") String sortBy,
            @RequestParam(value = "sortDir", required = false, defaultValue = "desc") String sortDir
    ) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page,size,sort);
        return ResponseEntity.ok(restaurantService.getOpenRestaurant(pageable));
    }

    @GetMapping("/getOpenRestaurantAtGivenTime")
    public ResponseEntity<List<RestaurantDto>> getOpenRestaurantAtCurrentTime(
            @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime time
    ) {
        return ResponseEntity.ok(restaurantService.getOpenRestaurantAtGivenTime(time));
    }

    // API to handle restaurant banner;
    // take restaurantId to attach banner in that restaurant;
    @PostMapping("/upload-banner/{restaurantId}")
    public ResponseEntity<RestaurantDto> uploadFile(
            @RequestParam("banner") MultipartFile banner,
            @PathVariable String restaurantId
    ) throws IOException {
        logger.info("Upload banner file");
        logger.info(banner.getOriginalFilename());
        logger.info(banner.getContentType());
        logger.info(banner.getName());
//        String pathFile = "uploads/restaurant_banners/" + banner.getOriginalFilename();
//        FileData fileData = fileService.uploadFile(banner, pathFile);
        RestaurantDto restaurantDto = restaurantService.uploadBanner(banner, restaurantId);
        return ResponseEntity.ok(restaurantDto);
    }

    @GetMapping("/{restaurantId}/banner")
    public ResponseEntity<Resource> serveFile(@PathVariable String restaurantId) throws MalformedURLException, FileNotFoundException {
        RestaurantDto restaurantDto = restaurantService.getById(restaurantId);
        String fullPath = bannerFolderPath+restaurantDto.getBanner();
        Path filePath = Paths.get(fullPath);
        Resource resource = new UrlResource(filePath.toUri());
        if (!resource.exists()) {
            throw new FileNotFoundException("File not found: " + fullPath);
        }
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(resource);
    }
}
