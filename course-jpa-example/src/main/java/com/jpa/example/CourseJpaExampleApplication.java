package com.jpa.example;

import com.jpa.example.entities.User;
import com.jpa.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CourseJpaExampleApplication implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;


	public static void main(String[] args) {
		SpringApplication.run(CourseJpaExampleApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
//        System.out.println("Saving user");
//        User user = new User();
//        user.setUserId(123);
//        user.setAge(18);
//        user.setActive(true);
//        user.setName("Anubhav");
//        user.setEmail("abc@gmail.com");
//        userRepository.save(user);
//        System.out.println("user saved");

//        List<User> all = userRepository.findAll();
//        for(User u: all) {
//            System.out.println(u.getName());
//        }


    }
}
