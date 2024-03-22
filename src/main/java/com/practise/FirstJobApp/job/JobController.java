package com.practise.FirstJobApp.job;

import com.practise.FirstJobApp.entity.Job;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class JobController {

    private List<Job> jobs = new ArrayList<>();

    @GetMapping("/jobs")
    public List<Job> findAll(){
        return jobs;
    }
}
