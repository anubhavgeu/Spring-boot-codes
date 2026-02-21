package com.substring.foodie.substring_foodie.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Student {
    private String name;
    private int age;
    private List<Subject> subjectList;
    private Department department;

}
