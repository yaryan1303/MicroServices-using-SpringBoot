package com.embarkx.FirstJobApp.Review;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

  private ReviewService reviewService;

  public ReviewController(ReviewService reviewService) {
    this.reviewService = reviewService;
  }

  @GetMapping("/reviews")
  private ResponseEntity<List<Reviews>> getAllReviews(@PathVariable Long companyId) {
    List<Reviews> reviews = reviewService.getAllReviews(companyId);
    return ResponseEntity.ok(reviews);
  }

  @PostMapping("/reviews")
  private ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Reviews review) {
    reviewService.addReview(companyId, review);
    return ResponseEntity.ok("Review added successfully");
  }

  @GetMapping("/reviews/{reviewId}")
  private ResponseEntity<Reviews> getReviewById(@PathVariable Long companyId, @PathVariable Long reviewId) {
    Reviews review = reviewService.getReviewById(companyId, reviewId);
    return ResponseEntity.ok(review);
  }

  @PutMapping("/reviews/{reviewId}")
  private ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId,
      @RequestBody Reviews review) {
    reviewService.updateReview(companyId, reviewId, review);
    return ResponseEntity.ok("Review updated successfully");
  }

  @DeleteMapping("/reviews/{reviewId}")
  private ResponseEntity<String> DeleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
    reviewService.deleteReview(companyId, reviewId);
    return ResponseEntity.ok("Review Deleted successfully");
  }

}
