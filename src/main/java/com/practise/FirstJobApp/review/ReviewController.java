package com.practise.FirstJobApp.review;

import com.practise.FirstJobApp.review.entity.Review;
import com.practise.FirstJobApp.review.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId,@RequestBody Review review){
        boolean isReviewed = reviewService.addReview(companyId, review);
        if (isReviewed)
            return new ResponseEntity<>("Review added successfully", HttpStatus.OK);
        return new ResponseEntity<>("Review Not Saved", HttpStatus.NOT_FOUND);

    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId,@PathVariable Long reviewId){
        Review reviews = reviewService.getReviews(companyId, reviewId);
        if (reviews  != null)
            return new ResponseEntity<>(reviews,HttpStatus.OK);
        return new ResponseEntity<>(reviews,HttpStatus.NOT_FOUND);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,@PathVariable Long reviewId,@RequestBody Review review){
        boolean b = reviewService.updateReview(companyId, reviewId, review);
        if (b) return new ResponseEntity<>("Review updated successfully",HttpStatus.OK);
        return new ResponseEntity<>("Review Not updated",HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId,@PathVariable Long reviewId){
        boolean b = reviewService.deleteReview(companyId, reviewId);
        if (b) return new ResponseEntity<>("Review deleted successfully",HttpStatus.OK);
        return new ResponseEntity<>("Review Not deleted",HttpStatus.NOT_FOUND);
    }

}
