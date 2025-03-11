package com.embarkx.FirstJobApp.Job;

import java.util.List;

public interface JobService {
  List<Job> getAllJobs();

  Job getJobById(Long id);

  void addJob(Job job);

  Job updateJob(Long id, Job job);

  boolean deleteJob(Long id);

}
