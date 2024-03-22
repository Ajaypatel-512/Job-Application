package com.practise.FirstJobApp.job.service;

import com.practise.FirstJobApp.job.entity.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
}
