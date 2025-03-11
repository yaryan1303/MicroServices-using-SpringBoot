package com.embarkx.FirstJobApp.Review;

import java.util.List;

public interface ReviewService {

  List<Reviews> getAllReviews(Long companyId);

  Reviews getReviewById(Long companyId, Long id);

  void addReview(Long companyId, Reviews review);

  Reviews updateReview(Long companyId, Long id, Reviews review);

  boolean deleteReview(Long companyId, Long id);

}
