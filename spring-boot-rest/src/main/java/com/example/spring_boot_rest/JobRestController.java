package com.example.spring_boot_rest;


import com.example.spring_boot_rest.model.JobPost;
import com.example.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service;


    @GetMapping(path = "jobPosts", produces = {"/application/json"})
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }


    @GetMapping("jobPost/{post}")
    public JobPost getJob(@PathVariable("postId") int postId) { // post sending in URL and accepting as postId in the functions;
        return service.getJob(postId);
    }


    @PostMapping(path = "jobPost", consumes = {"/application/xml"})
    public JobPost addJob(@RequestBody JobPost jobPost) {
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }


    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId) {
        service.deleteJob(postId);
        return "Deleted";
    }
}
