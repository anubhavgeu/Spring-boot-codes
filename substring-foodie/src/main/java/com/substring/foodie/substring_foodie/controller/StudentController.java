package com.substring.foodie.substring_foodie.controller;

import com.substring.foodie.substring_foodie.dto.Department;
import com.substring.foodie.substring_foodie.dto.Student;
import com.substring.foodie.substring_foodie.dto.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @RequestMapping("/single")
    public Student getStudent() {
        // department;
        Department department = new Department();
        department.setDepartmentCode("CS");
        department.setDepartmentName("Computer Science");


        // subject;
        Subject subject1 = new Subject();
        subject1.setSubjectCode("DS");
        subject1.setTitle("Data Structures");
        Subject subject2 = new Subject();
        subject2.setSubjectCode("OS");
        subject2.setTitle("Operating System");
        List<Subject> subjectList = new ArrayList<>();
        subjectList.add(subject1);
        subjectList.add(subject2);


        Student student = new Student();
        student.setAge(21);
        student.setName("Anubhav");
        student.setDepartment(department);
        student.setSubjectList(subjectList);
        return student;
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();

        Student s1 = new Student();
        s1.setName("Alice Smith");
        s1.setAge(20);
        Department d1 = new Department();
        d1.setDepartmentName("Computer Science");
        d1.setDepartmentCode("CS");
        s1.setDepartment(d1);
        Subject sub1 = new Subject();
        sub1.setTitle("Data Structures");
        sub1.setSubjectCode("CS201");
        s1.setSubjectList(List.of(sub1));
        studentList.add(s1);

        Student s2 = new Student();
        s2.setName("Bob Johnson");
        s2.setAge(22);
        Department d2 = new Department();
        d2.setDepartmentName("Mathematics");
        d2.setDepartmentCode("MATH");
        s2.setDepartment(d2);
        Subject sub2 = new Subject();
        sub2.setTitle("Calculus III");
        sub2.setSubjectCode("MAT301");
        s2.setSubjectList(List.of(sub2));
        studentList.add(s2);

        Student s3 = new Student();
        s3.setName("Charlie Brown");
        s3.setAge(19);
        Department d3 = new Department();
        d3.setDepartmentName("Physics");
        d3.setDepartmentCode("PHYS");
        s3.setDepartment(d3);
        Subject sub3 = new Subject();
        sub3.setTitle("Quantum Mechanics");
        sub3.setSubjectCode("PHY405");
        s3.setSubjectList(List.of(sub3));
        studentList.add(s3);

        Student s4 = new Student();
        s4.setName("Diana Prince");
        s4.setAge(21);
        Department d4 = new Department();
        d4.setDepartmentName("History");
        d4.setDepartmentCode("HIST");
        s4.setDepartment(d4);
        Subject sub4 = new Subject();
        sub4.setTitle("World War II");
        sub4.setSubjectCode("HIS202");
        s4.setSubjectList(List.of(sub4));
        studentList.add(s4);

        Student s5 = new Student();
        s5.setName("Ethan Hunt");
        s5.setAge(23);
        Department d5 = new Department();
        d5.setDepartmentName("Mechanical Engineering");
        d5.setDepartmentCode("MECH");
        s5.setDepartment(d5);
        Subject sub5 = new Subject();
        sub5.setTitle("Thermodynamics");
        sub5.setSubjectCode("MEC310");
        s5.setSubjectList(List.of(sub5));
        studentList.add(s5);

        Student s6 = new Student();
        s6.setName("Fiona Gallagher");
        s6.setAge(20);
        Department d6 = new Department();
        d6.setDepartmentName("Biology");
        d6.setDepartmentCode("BIO");
        s6.setDepartment(d6);
        Subject sub6 = new Subject();
        sub6.setTitle("Genetics");
        sub6.setSubjectCode("BIO205");
        s6.setSubjectList(List.of(sub6));
        studentList.add(s6);

        Student s7 = new Student();
        s7.setName("George Costanza");
        s7.setAge(24);
        Department d7 = new Department();
        d7.setDepartmentName("Architecture");
        d7.setDepartmentCode("ARCH");
        s7.setDepartment(d7);
        Subject sub7 = new Subject();
        sub7.setTitle("Urban Planning");
        sub7.setSubjectCode("ARC401");
        s7.setSubjectList(List.of(sub7));
        studentList.add(s7);

        Student s8 = new Student();
        s8.setName("Hannah Abbott");
        s8.setAge(19);
        Department d8 = new Department();
        d8.setDepartmentName("Chemistry");
        d8.setDepartmentCode("CHEM");
        s8.setDepartment(d8);
        Subject sub8 = new Subject();
        sub8.setTitle("Organic Chemistry");
        sub8.setSubjectCode("CHE301");
        s8.setSubjectList(List.of(sub8));
        studentList.add(s8);

        Student s9 = new Student();
        s9.setName("Ian Malcolm");
        s9.setAge(22);
        Department d9 = new Department();
        d9.setDepartmentName("Philosophy");
        d9.setDepartmentCode("PHIL");
        s9.setDepartment(d9);
        Subject sub9 = new Subject();
        sub9.setTitle("Ethics");
        sub9.setSubjectCode("PHI101");
        s9.setSubjectList(List.of(sub9));
        studentList.add(s9);

        Student s10 = new Student();
        s10.setName("Julia Child");
        s10.setAge(21);
        Department d10 = new Department();
        d10.setDepartmentName("Culinary Arts");
        d10.setDepartmentCode("CUL");
        s10.setDepartment(d10);
        Subject sub10 = new Subject();
        sub10.setTitle("French Cuisine");
        sub10.setSubjectCode("CUL202");
        s10.setSubjectList(List.of(sub10));
        studentList.add(s10);

        return studentList;
    }

    @RequestMapping("/wish/{message}/for/{username}")
    public String wish(@PathVariable String username, @PathVariable String message) {
        return "Wishing: " + username + " " + message;
    }
}
