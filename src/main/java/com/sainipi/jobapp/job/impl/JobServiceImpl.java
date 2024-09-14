package com.sainipi.jobapp.job.impl;

import com.sainipi.jobapp.job.Job;
import com.sainipi.jobapp.job.JobService;
import org.springframework.stereotype.Component;
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
}
