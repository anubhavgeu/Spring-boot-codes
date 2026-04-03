package com.substring.foodie.controller.example;


import com.substring.foodie.playload.example.Department;
import com.substring.foodie.playload.example.Student;
import com.substring.foodie.playload.example.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @RequestMapping("/single")
    public Student getStudent() {

        Department department = new Department();
        department.setDepartmentCode("CS");
        department.setDepartmentName("Computer Science");

        Subject subject1 = new Subject();
        subject1.setSubjectCode("DS101");
        subject1.setTitle("Data Structures");

        Subject subject2 = new Subject();
        subject2.setSubjectCode("DBMS201");
        subject2.setTitle("Database Management System");

        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);

        Student student = new Student();
        student.setName("Anubhav");
        student.setAge(18);
        student.setSubjects(subjects);
        student.setDepartment(department);
        return student;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {

        List<Student> studentList = new ArrayList<>();

        // Predefined Departments
        Department cs = new Department();
        cs.setDepartmentCode("CS");
        cs.setDepartmentName("Computer Science");

        Department it = new Department();
        it.setDepartmentCode("IT");
        it.setDepartmentName("Information Technology");

        Department mech = new Department();
        mech.setDepartmentCode("ME");
        mech.setDepartmentName("Mechanical");

        // Predefined Subjects
        Subject ds = new Subject();
        ds.setSubjectCode("DS101");
        ds.setTitle("Data Structures");

        Subject dbms = new Subject();
        dbms.setSubjectCode("DB201");
        dbms.setTitle("DBMS");

        Subject os = new Subject();
        os.setSubjectCode("OS301");
        os.setTitle("Operating System");

        Subject math = new Subject();
        math.setSubjectCode("M101");
        math.setTitle("Mathematics");

        Subject thermodynamics = new Subject();
        thermodynamics.setSubjectCode("ME201");
        thermodynamics.setTitle("Thermodynamics");

        // Student 1
        Student s1 = new Student();
        s1.setName("Anubhav");
        s1.setAge(20);
        s1.setDepartment(cs);
        s1.setSubjects(List.of(ds, dbms));

        // Student 2
        Student s2 = new Student();
        s2.setName("Rahul");
        s2.setAge(21);
        s2.setDepartment(it);
        s2.setSubjects(List.of(os, math));

        // Student 3
        Student s3 = new Student();
        s3.setName("Amit");
        s3.setAge(22);
        s3.setDepartment(mech);
        s3.setSubjects(List.of(thermodynamics, math));

        // Student 4
        Student s4 = new Student();
        s4.setName("Priya");
        s4.setAge(19);
        s4.setDepartment(cs);
        s4.setSubjects(List.of(ds, os));

        // Student 5
        Student s5 = new Student();
        s5.setName("Sneha");
        s5.setAge(21);
        s5.setDepartment(it);
        s5.setSubjects(List.of(dbms, math));

        // Student 6
        Student s6 = new Student();
        s6.setName("Karan");
        s6.setAge(23);
        s6.setDepartment(mech);
        s6.setSubjects(List.of(thermodynamics));

        // Student 7
        Student s7 = new Student();
        s7.setName("Neha");
        s7.setAge(20);
        s7.setDepartment(cs);
        s7.setSubjects(List.of(ds, dbms, os));

        // Student 8
        Student s8 = new Student();
        s8.setName("Rohit");
        s8.setAge(22);
        s8.setDepartment(it);
        s8.setSubjects(List.of(os));

        // Student 9
        Student s9 = new Student();
        s9.setName("Simran");
        s9.setAge(19);
        s9.setDepartment(mech);
        s9.setSubjects(List.of(math, thermodynamics));

        // Student 10
        Student s10 = new Student();
        s10.setName("Arjun");
        s10.setAge(21);
        s10.setDepartment(cs);
        s10.setSubjects(List.of(dbms));

        studentList.addAll(List.of(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10));

        return studentList;
    }
}
