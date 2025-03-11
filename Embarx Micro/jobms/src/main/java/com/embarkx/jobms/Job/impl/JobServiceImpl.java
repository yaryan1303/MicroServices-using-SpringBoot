package com.embarkx.FirstJobApp.Job.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.embarkx.FirstJobApp.Job.Job;
import com.embarkx.FirstJobApp.Job.JobRepository;
import com.embarkx.FirstJobApp.Job.JobService;

@Service
public class JobServiceImpl implements JobService {

  @Autowired
  private JobRepository jobRepository;

  @Override
  public List<Job> getAllJobs() {
    return jobRepository.findAll();
  }

  @Override
  public Job getJobById(Long id) {
    return jobRepository.findById(id).orElse(null);
  }

  @Override
  public void addJob(Job job) {
    jobRepository.save(job);

  }

  @Override
  public Job updateJob(Long id, Job job) {
    Job existingJob = getJobById(id);
    if (existingJob == null) {
      return null;
    }
    existingJob.setId(job.getId());
    existingJob.setTitle(job.getTitle());
    existingJob.setDescription(job.getDescription());
    existingJob.setMinSalary(job.getMinSalary());
    existingJob.setMaxSalary(job.getMaxSalary());
    existingJob.setLocation(job.getLocation());

    jobRepository.save(existingJob);

    return existingJob;
  }

  @Override
  public boolean deleteJob(Long id) {
    Job existingJob = getJobById(id);
    if (existingJob == null) {
      return false;
    }
    jobRepository.deleteById(id);
    return true;

  }

}
