package com.sainipi.jobapp.job.impl;

import com.sainipi.jobapp.job.Job;
import com.sainipi.jobapp.job.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private final List<Job> jobs = new ArrayList<>();

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        if(job.getId() == null){
            return;
        }
        jobs.add(job);

    }

    @Override
    public Job getJobById(Long id) {
        for(Job job : jobs){
            if(job.getId().equals(id)){
                return job;
            }
        }
        return null;

    }

    @Override
    public boolean deleteJobById(Long id) {
        if(id != null){
            jobs.removeIf(job -> job.getId().equals(id));
            return true;

        }
        return false;
    }

    @Override
    public boolean updateJobById(Long id, Job job) {
        if(id != null){
            for(Job job1 : jobs){
                if(job1.getId().equals(id)){
                   job1.setTitle(job.getTitle());
                    job1.setDescription(job.getDescription());
                    job1.setLocation(job.getLocation());
                    job1.setMaxSalary(job.getMaxSalary());
                    job1.setMinSalary(job.getMinSalary());
                    return true;
                }
            }
        }
        return false;
    }

}

