package com.example.spring_security_1.model;

public class Student {
    private int id;
    private String name;
    private String technology;

    public Student(int i, String navin, String java) {
        this.id =  i;
        this.name = navin;
        this.technology = java;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", technology='" + technology + '\'' +
                '}';
    }

}
