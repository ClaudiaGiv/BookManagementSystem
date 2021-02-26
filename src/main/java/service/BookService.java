package service;

import repository.AuthorRepository;
import repository.BookRepository;
import repository.ReviewRepository;
import model.Author;
import model.Book;
import model.Review;

import java.util.ArrayList;
import java.util.List;

public class BookService {


    BookRepository bookRepository;
    ReviewRepository reviewRepository;
    AuthorRepository authorRepository;


    //final project
    public BookService(BookRepository bookRepository, ReviewRepository reviewRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.reviewRepository = reviewRepository;
        this.authorRepository = authorRepository;
    }

    public BookService() {
        bookRepository = new BookRepository();
        reviewRepository = new ReviewRepository();
        authorRepository = new AuthorRepository();
    }

    public Book findById(int id) {
        return bookRepository.findById(id);
    }

    //find all
    public List<Book> findAll() {
        return bookRepository.findAll();
    }


    public int create(Book book) {
        int result = bookRepository.create(book);
        return result;
    }

    public void update(Book book, Book bookToBeChanged) {
        bookRepository.update(book, bookToBeChanged);
    }

    public void update(Book book) {
        bookRepository.update(book);
    }

    public void delete(Book book) {
        bookRepository.delete(book);
    }

    public void assignReviewToBook(int reviewId, int bookId) {
        Book b = bookRepository.findById(bookId);
        Review r = reviewRepository.findById(reviewId);
        List<Review> reviewList = new ArrayList<>();
        reviewList.add(r);
        b.setReview(reviewList);
        r.setBook(b);
        bookRepository.update(b);
    }

    public void assignReviewToBook(Review review, int bookId) {
        Book b = bookRepository.findById(bookId);
        List<Review> reviewList = new ArrayList<>();
        reviewList.add(review);
        b.setReview(reviewList);
        review.setBook(b);
        reviewRepository.create(review);
        bookRepository.update(b);
    }

    public void assignAuthorToBook(int authorId, int bookId) {

        Book b = bookRepository.findById(bookId);
        Author a = authorRepository.findById(authorId);
        b.setAuthor(a);
        bookRepository.update(b);

    }
}
