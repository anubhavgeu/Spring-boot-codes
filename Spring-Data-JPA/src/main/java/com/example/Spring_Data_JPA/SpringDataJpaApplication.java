package com.example.Spring_Data_JPA;

import com.example.Spring_Data_JPA.model.Student;
import com.example.Spring_Data_JPA.repo.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);

        StudentRepo repo = context.getBean(StudentRepo.class);

//        Student s1 = context.getBean(Student.class);
        Student s2 = context.getBean(Student.class);
//        Student s3 = context.getBean(Student.class);
//
//        s1.setRollNo(1);
//        s1.setName("Anubhav");
//        s1.setMarks(75);
//
        s2.setRollNo(2);
        s2.setName("Nivedita");
        s2.setMarks(100);
//
//        s3.setRollNo(3);
//        s3.setName("Abhishek");
//        s3.setMarks(80);
//
//        repo.save(s1);
//        repo.save(s2);
//        repo.save(s3);


        // to find all the data;
//        System.out.println(repo.findAll());
//        Optional<Student> s = repo.findById(4);
//        System.out.println(s.orElse(new Student()));
//        System.out.println(repo.findByName("Nivedita"));
//        System.out.println(repo.findByMarksGreaterThan(79));

//        update s2
        repo.save(s2);
        repo.delete(s2);
	}

}
