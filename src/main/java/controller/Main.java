package controller;

import model.Author;
import model.Book;
import model.Review;
import service.AuthorService;
import service.BookService;
import service.ReviewService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AuthorService authorService = new AuthorService();
        BookService bookService = new BookService();
        ReviewService reviewService = new ReviewService();

        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("1-For create a author");
            System.out.println("2-For assign author to book");
            System.out.println("3-For assign review to book");
            System.out.println("4-For create a book");
            System.out.println("5-For update an author");
            System.out.println("6-For update a book");
            System.out.println("7-For update a review");


            switch (in.nextInt()) {
                case 1:
                    System.out.println("Give first name");
                    String firstName = in.next();
                    System.out.println("Give last name");
                    String lastName = in.next();
                    Author author = new Author(firstName, lastName);
                    authorService.create(author);
                    break;
                case 2:
                    System.out.println("Give book id");
                    int bookId = in.nextInt();
                    System.out.println("Give author id");
                    int authorId = in.nextInt();
                    bookService.assignAuthorToBook(authorId, bookId);
                    break;
                case 3:
                    in.nextLine();
                    System.out.println("Give review description");
                    String reviewDescription = in.nextLine();
                    System.out.println("Give book id");
                    int bookId2 = in.nextInt();
                    Review review = new Review(reviewDescription);
                    bookService.assignReviewToBook(review, bookId2);
                    break;
                case 4:
                    in.nextLine();
                    System.out.println("Give book name");
                    String bookName = in.nextLine();
                    Book book = new Book(bookName);
                    bookService.create(book);
                    break;
                case 5:
                    in.nextLine();
                    System.out.println("Give a new first name for author to be updated");
                    String firstNameUpdate = in.nextLine();
                    System.out.println("Give a new last name for author to be updated");
                    String lastNameUpdate = in.nextLine();
                    System.out.println("Give the author id");

                    Author author1 = authorService.findById(Integer.parseInt(in.nextLine()));
                    Author authorUpdate = new Author(firstNameUpdate, lastNameUpdate);
                    authorService.update(author1, authorUpdate);
                    break;
                case 6:
                    in.nextLine();
                    System.out.println("New name for the book to be updated");
                    String bookNameToBeUpdated = in.nextLine();
                    System.out.println("Give book id to be updated");
                    Book bookToUpdate = bookService.findById(Integer.parseInt(in.nextLine()));
                    Book bookToBeUpdated = new Book(bookNameToBeUpdated);
                    bookService.update(bookToUpdate, bookToBeUpdated);
                    break;
                case 7:
                    in.nextLine();
                    System.out.println("New review to update");
                    String reviewExistedToBeUpdated = in.nextLine();
                    System.out.println("Give review id to be updated");
                    Review reviewToUpdate = reviewService.findById(Integer.parseInt(in.nextLine()));
                    Review reviewToBeUpdated = new Review(reviewExistedToBeUpdated);
                    reviewService.update(reviewToUpdate,reviewToBeUpdated);
                    break;
                case 8:

                    break;
                case 0:
                    System.out.println(0);
                    break;
            }
        }


    }
}
