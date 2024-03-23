package com.practise.FirstJobApp.job.repository;

import com.practise.FirstJobApp.job.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {

}
