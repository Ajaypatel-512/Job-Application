package com.practise.FirstJobApp.review.service;

import com.practise.FirstJobApp.review.entity.Review;

import java.util.List;

public interface ReviewService {
        List<Review> getAllReviews(Long companyId);
        boolean addReview(Long id, Review review);
        Review getReviews(Long companyId, Long reviewId);
        boolean updateReview(Long companyId, Long reviewId, Review review);
        boolean deleteReview(Long companyId, Long reviewId);
}
