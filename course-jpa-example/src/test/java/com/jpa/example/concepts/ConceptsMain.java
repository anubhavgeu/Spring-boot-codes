package com.jpa.example.concepts;

import com.jpa.example.entities.Laptop;
import com.jpa.example.entities.User;
import com.jpa.example.repository.LaptopRepository;
import com.jpa.example.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConceptsMain {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LaptopRepository laptopRepository;

//    @Test
//    public void testSaveOneToOne() {
//        User user = userRepository.findById(1010).orElseThrow(() -> new RuntimeException("User not found"));
//        Laptop laptop = new Laptop();
//        laptop.setModel("Apple Mac Air M4");
//        laptop.setAbout("This is the latest macbook air");
//        laptop.setUser(user);
//        laptopRepository.save(laptop);
//        System.out.println("Laptop added");
//    }

//    @Test
//    public void testGetOneToOne() {
//        User user = userRepository.findById(1010).orElseThrow(() -> new RuntimeException("User not found"));
//        System.out.println(user.getName());
//        Laptop laptop = user.getLaptop();
//        System.out.println(laptop.getId() + " | " + laptop.getModel() + " | " + laptop.getAbout());
//
//
//        Laptop laptop1 = laptopRepository.findById(1).orElseThrow();
//        System.out.println(laptop1.getModel());
//        User user1 = laptop1.getUser();
//        System.out.println(user1.getName());
//    }

    @Test
    @Transactional
    public void saveOneOneToMany() {
        User  u = userRepository.findById(1010).orElseThrow();
        Laptop laptop = new Laptop();
        laptop.setModel("Macbook air M3");
        laptop.setAbout("This is the macbook air M3");
        Laptop laptop1 = new Laptop();
        laptop1.setModel("Macbook air M4");
        laptop1.setAbout("This is the macbook air M4");

        u.getLaptops().add(laptop1);
        u.getLaptops().add(laptop);
        laptop1.setUser(u);
        laptop.setUser(u);

        userRepository.save(u);
        System.out.println("User updated");
    }
}
