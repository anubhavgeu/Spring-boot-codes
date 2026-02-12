package com.course.management.course_jdbc_example;

import com.course.management.course_jdbc_example.dao.CategoryDao;
import com.course.management.course_jdbc_example.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CourseJdbcExampleApplication implements CommandLineRunner {

    @Autowired
    private CategoryDao categoryDao;

	public static void main(String[] args) {
		SpringApplication.run(CourseJdbcExampleApplication.class, args);

	}

    @Override
    public void run(String... args) throws Exception {
//        Category category = new Category();
//        category.setId(101L);
//        category.setDescription("This is the description of that ronaldo is the goat");
//        category.setTitle("Ronnyy....");
//        Category savedCategory = categoryDao.save(category);
//        System.out.println("Category created with id " + savedCategory.getId());

//        categoryDao.delete(101L);

//        List<Category> all = categoryDao.getAll();
//        for (Category c: all) {
//            System.out.println(c.getId() + " " + c.getDescription());
//        }

//        Category categoryById = categoryDao.get(1L);
//        System.out.println(categoryById.getDescription());
    }
}
