package service;

import repository.BookRepository;
import repository.ReviewRepository;
import model.Review;

import java.util.List;

public class ReviewService {


    ReviewRepository reviewRepository = new ReviewRepository();
    BookRepository bookRepository = new BookRepository();


    public Review findById(int id) {
        return reviewRepository.findById(id);
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }


    public int create(Review review) {
        int result = reviewRepository.create(review);
        return result;
    }

    public void update(Review review) {
        reviewRepository.update(review);
    }

    public void update(Review review, Review reviewToBeChanged) {
        reviewRepository.update(review, reviewToBeChanged);
    }

    public void delete(Review review) {
        reviewRepository.delete(review);
    }
}
