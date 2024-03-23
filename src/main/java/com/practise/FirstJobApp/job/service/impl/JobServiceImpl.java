package com.practise.FirstJobApp.job.service.impl;

import com.practise.FirstJobApp.job.entity.Job;
import com.practise.FirstJobApp.job.repository.JobRepository;
import com.practise.FirstJobApp.job.service.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
//    private List<Job> jobs = new ArrayList<>();
//    private Long nextId = 1L;

    private JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
//        job.setId(nextId++);
        jobRepository.save(job);
    }

    @Override
    public Job findJobById(Long id) {
//        for (Job job: jobs) {
//            if (job.getId().equals(id)){
//                return job;
//            }
//        }
        Optional<Job> job = jobRepository.findById(id);
        return job.orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
//        Iterator<Job> iterator = jobs.iterator();
//        while (iterator.hasNext()){
//            Job job = iterator.next();
//            if (job.getId().equals(id)){
//                iterator.remove();
//                return true;
//            }
//        }
//        return false;

        try {
            jobRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean updateJob(Long id, Job UpdatedJob) {
//        for (Job job: jobs) {
//            if (job.getId().equals(id)){
//                job.setTitle(UpdatedJob.getTitle());
//                job.setDescription(UpdatedJob.getDescription());
//                job.setMinSalary(UpdatedJob.getMinSalary());
//                job.setMaxSalary(UpdatedJob.getMaxSalary());
//                job.setLocation(UpdatedJob.getLocation());
//                return true;
//            }
//        }
//        return false;

        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()){
            jobRepository.save(jobOptional.get());
            return true;
        }
        return true;
    }
}
