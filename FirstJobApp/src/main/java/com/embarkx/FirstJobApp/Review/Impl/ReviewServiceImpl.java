package com.embarkx.FirstJobApp.Review.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.embarkx.FirstJobApp.Company.CompanyService;
import com.embarkx.FirstJobApp.Review.ResourceNotFoundException;
import com.embarkx.FirstJobApp.Review.ReviewRepository;
import com.embarkx.FirstJobApp.Review.ReviewService;
import com.embarkx.FirstJobApp.Review.Reviews;

@Service
public class ReviewServiceImpl implements ReviewService {

  private ReviewRepository reviewRepository;
  @Autowired
  private CompanyService companyService;

  public ReviewServiceImpl(ReviewRepository reviewRepository) {
    this.reviewRepository = reviewRepository;
  }

  @Override
  public List<Reviews> getAllReviews(Long companyId) {
    List<Reviews> reviews = reviewRepository.findByCompanyId(companyId);
    return reviews;

  }

  @Override
  public Reviews getReviewById(Long CompanyId, Long id) {

    return reviewRepository.findById(id).filter((review) -> review.getCompany().getId().equals(CompanyId))
        .orElseThrow(() -> new RuntimeException("Review not found"));

  }

  @Override
  public void addReview(Long companyId, Reviews review) {
    review.setCompany(companyService.getCompanyById(companyId));
    reviewRepository.save(review);

  }

  @Override
  public Reviews updateReview(Long companyId, Long id, Reviews review) {
    Optional<Reviews> existingReview = reviewRepository.findById(id);

    if (existingReview.isPresent()) {
      Reviews updatedReview = existingReview.get();

      // Ensure the review belongs to the right company
      if (!updatedReview.getCompany().getId().equals(companyId)) {
        throw new ResourceNotFoundException("Review not found for this company");
      }

      // Update the fields
      updatedReview.setDescription(review.getDescription());
      updatedReview.setRating(review.getRating());

      return reviewRepository.save(updatedReview);
    } else {
      throw new ResourceNotFoundException("Review not found");
    }
  }

  @Override
  public boolean deleteReview(Long companyId, Long id) {
    Optional<Reviews> existingReview = reviewRepository.findById(id);

    if (existingReview.isPresent()) {
      Reviews review = existingReview.get();

      // Ensure the review belongs to the right company
      if (!review.getCompany().getId().equals(companyId)) {
        throw new ResourceNotFoundException("Review not found for this company");
      }

      reviewRepository.delete(review);
      return true;
    } else {
      throw new ResourceNotFoundException("Review not found");
    }
  }

}
