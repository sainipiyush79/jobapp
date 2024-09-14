package com.sainipi.jobapp.job.impl;

import com.sainipi.jobapp.job.Job;
import com.sainipi.jobapp.job.JobService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) { // this constructor will autowired no need to create instance Object
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try{
            jobRepository.deleteById(id);
                    return true;
        }catch (EmptyResultDataAccessException e){
            return false;
        }

    }

    @Override
    public boolean updateJobById(Long id, Job job) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent()){
            Job job1 = jobOptional.get();

                if(job1.getId().equals(id)){
                   job1.setTitle(job.getTitle());
                    job1.setDescription(job.getDescription());
                    job1.setLocation(job.getLocation());
                    job1.setMaxSalary(job.getMaxSalary());
                    job1.setMinSalary(job.getMinSalary());
                    jobRepository.save(job1);
                    return true;
                }

        }
        return false;
    }

}

