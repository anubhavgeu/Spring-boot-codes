package com.example.SpringJDBC;

import com.example.SpringJDBC.model.Student;
import com.example.SpringJDBC.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
        Student s = context.getBean(Student.class);
        s.setRollNo(5);
        s.setName("Vaibhav");
        s.setMarks(56);
        StudentService service = context.getBean(StudentService.class);
        service.addStudent(s);

        List<Student> studentList = service.getStudents();
        System.out.println(studentList);
	}

}
