package com.example.spring_security_1.model;

public class Student {
    private Integer id;
    private String name;
    private String tech;

    Student() {}

    public Student(Integer id, String name, String tech) {
        this.id = id;
        this.name = name;
        this.tech = tech;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}
