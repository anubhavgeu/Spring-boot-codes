package com.jpa.example;

import com.jpa.example.dto.UserType;
import com.jpa.example.entities.User;
import com.jpa.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseJpaExampleApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void testUser() {
        User user = new User();
        user.setUserId(1010);
        user.setName("Anubhav Singh");
        user.setEmail("anubhavs@gmail.com");
        user.setType(UserType.STUDENT);
        user.setAge(30);
        user.setActive(true);

        User save = userService.save(user);
        System.out.println(save.getName());
    }

    @Test
    public void getUserTest() {
        User user = userService.get(1010);
        System.out.println(user.getName());
    }
}
