package com.example.JobApp;


import com.example.JobApp.model.JobPost;
import com.example.JobApp.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.JobApp.service.JobService;

@Controller
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping({"/", "/home"})
    public String home() {
        return "home";
    }

    @GetMapping("addjob")
    public String addJob() {
        return "addjob";
    }

    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost, Model model) {
        model.addAttribute("jobPost", jobPost);
        service.addJob(jobPost);
        return "success";
    }
}
