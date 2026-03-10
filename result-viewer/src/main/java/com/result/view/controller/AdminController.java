package com.result.view.controller;

import com.result.view.dto.StudentForm;
import com.result.view.entity.Student;
import com.result.view.repository.StudentRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private StudentRepository studentRepository;
    private ModelMapper modelMapper;
    public AdminController (StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }
    @GetMapping("/add-result")
    public String addResultForm(Model model) {
        StudentForm studentForm = new StudentForm();
        model.addAttribute("studentForm", studentForm);
        List<String> standardOptions = new ArrayList<>();
        standardOptions.add("CLASS 1");
        standardOptions.add("CLASS 2");
        standardOptions.add("CLASS 3");
        model.addAttribute("standardOptions", standardOptions);
        return "admin/add_result";
    }

    @PostMapping("/add-result-action")
    public String processedResultForm(
            @Valid @ModelAttribute StudentForm studentForm,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            List<String> standardOptions = new ArrayList<>();
            standardOptions.add("CLASS 1");
            standardOptions.add("CLASS 2");
            standardOptions.add("CLASS 3");
            model.addAttribute("standardOptions", standardOptions);
            return "admin/add_result";
        }


        Student student = modelMapper.map(studentForm, Student.class);
        student.setId(UUID.randomUUID().toString());
        Student savedStudent = studentRepository.save(student);
        return "redirect:/admin/add-result?message=Student added successfully";
    }
}
