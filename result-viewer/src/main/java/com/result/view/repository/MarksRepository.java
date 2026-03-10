package com.result.view.repository;

import com.result.view.entity.Marks;
import com.result.view.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarksRepository extends JpaRepository<Marks,Long> {
    List<Marks> findByStudent(Student student);
}
