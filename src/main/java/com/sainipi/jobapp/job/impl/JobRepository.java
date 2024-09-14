package com.sainipi.jobapp.job.impl;

import com.sainipi.jobapp.job.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job , Long> {

}
