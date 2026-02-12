package com.course.management.course_jdbc_example.dao;


import com.course.management.course_jdbc_example.entities.Category;
import com.course.management.course_jdbc_example.utils.CategoryRowMapper;
import jakarta.annotation.PostConstruct;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS categories (id INT PRIMARY KEY, title VARCHAR(100) NOT NULL, description VARCHAR(500))";
        jdbcTemplate.update(createTableQuery);
        System.out.println("Table created: ");
    }

    // save category
    public Category save(Category category) {
        String query = "INSERT INTO categories (id,title,description) VALUES (?,?,?)";
        int rows = jdbcTemplate.update(
                query,
                category.getId(),
                category.getTitle(),
                category.getDescription()
        );
        System.out.println(rows + " affected");
        return category;
    }

    // update category
    public Category update(Long categoryId, Category newCat) {
        String query = "UPDATE categories SET title = ?, description = ? WHERE id = ?";
        int updatedRows = jdbcTemplate.update(
                query,
                newCat.getTitle(),
                newCat.getDescription(),
                categoryId
        );
        System.out.println(updatedRows + " rows updated.");
        newCat.setId(categoryId);
        return newCat;
    }

    // get all category;
    public List<Category> getAll() {
        String query = "SELECT * FROM categories";
//        return jdbcTemplate.queryForList(query, Category.class);
        return jdbcTemplate.query(query,new CategoryRowMapper());
    }



    // get single category by id;

    public Category get(Long categoryId) {
        String query = "SELECT * FROM categories WHERE id = ?";
//        return jdbcTemplate.queryForObject(query,Category.class,categoryId);
        return jdbcTemplate.queryForObject(query,new CategoryRowMapper(),categoryId);
    }

    // delete query;
    public void delete(Long categoryId) {
        String query = "DELETE FROM categories WHERE id = ?";
        jdbcTemplate.update(query,categoryId);
    }
}
