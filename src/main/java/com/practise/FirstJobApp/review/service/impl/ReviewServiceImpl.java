package com.practise.FirstJobApp.review.service.impl;

import com.practise.FirstJobApp.company.entity.Company;
import com.practise.FirstJobApp.company.service.CompanyService;
import com.practise.FirstJobApp.review.entity.Review;
import com.practise.FirstJobApp.review.repository.ReviewRepository;
import com.practise.FirstJobApp.review.service.ReviewService;
import org.springframework.stereotype.Service;

import java.sql.Struct;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }


    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long id, Review review) {
        Company company = companyService.findCompanyById(id);
        if (company != null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReviews(Long companyId, Long reviewId) {
        List<Review> reviewList = reviewRepository.findByCompanyId(companyId);

        return reviewList.stream().filter(
                review -> review.getId().equals(reviewId))
                .findFirst().orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review review) {
        if (companyService.findCompanyById(companyId) != null){
            review.setCompany(companyService.findCompanyById(companyId));
            review.setId(reviewId);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if (companyService.findCompanyById(companyId) != null
        && reviewRepository.existsById(reviewId)){
            Review review = reviewRepository.findById(reviewId).orElse(null);
            Company company = review.getCompany();
            company.getReviews().remove(review);
            companyService.updateCompany(companyId,company);
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }
}
