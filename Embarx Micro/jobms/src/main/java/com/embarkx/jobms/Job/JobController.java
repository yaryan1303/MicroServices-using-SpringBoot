package com.embarkx.FirstJobApp.Job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {

  @Autowired
  private JobService jobService;

  @GetMapping("/jobs")
  public ResponseEntity<List<Job>> getAllJobs() {
    return ResponseEntity.ok(jobService.getAllJobs());
  }

  @PostMapping("/jobs")
  public ResponseEntity<String> addJob(@RequestBody Job job) {
    jobService.addJob(job);

    return new ResponseEntity<>("Job added successfully", HttpStatus.CREATED);
  }

  @GetMapping("/jobs/{id}")
  public ResponseEntity<Job> getJobbyId(@PathVariable Long id) {
    Job job = jobService.getJobById(id);
    if (job == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
      return ResponseEntity.ok(job);
    }

  }

  @DeleteMapping("/jobs/{id}")
  public ResponseEntity<String> deleteJob(@PathVariable Long id) {
    boolean isDeleted = jobService.deleteJob(id);
    if (!isDeleted) {
      return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
  }

  @PutMapping("/jobs/{id}")
  public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job job) {

    jobService.updateJob(id, job);
    return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
  }

}
