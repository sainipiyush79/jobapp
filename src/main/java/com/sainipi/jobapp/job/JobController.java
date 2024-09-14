package com.sainipi.jobapp.job;

import com.sainipi.jobapp.job.impl.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {

    private final JobServiceImpl jobService;

    @Autowired
    public JobController(JobServiceImpl jobService) {
        this.jobService = jobService;
    }


    @GetMapping("/jobs")
    public ResponseEntity<List<Job> > findAll() {
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);
         return new ResponseEntity<>("job Successfully created", HttpStatus.CREATED);


    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job = jobService.getJobById(id);
        if(job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("jobs/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
        boolean deleted = jobService.deleteJobById(id);
        if(deleted){
            return new ResponseEntity<>("job Deleted created", HttpStatus.OK);
        }
        return new ResponseEntity<>("job Not Found", HttpStatus.OK);
    }

    @PutMapping("jobs/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Job job) {
        boolean updated = jobService.updateJobById(id, job);
        if(updated){
            return new ResponseEntity<>("job Successfully updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("job Not Found", HttpStatus.NOT_FOUND);
    }

}
