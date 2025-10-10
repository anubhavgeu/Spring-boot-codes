package com.example.Spring_data_rest_demo.repo;

import com.example.Spring_data_rest_demo.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

}
