package model;

import javax.persistence.*;
import java.util.List;


@Entity
public class Book {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @Column
    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    //referencedColumnName = The name of the column referenced by this foreign key column.
    @JoinColumn(name = "authorId")
    private Author author;


    @OneToMany(mappedBy = "book")
    private List<Review> review;

    public Book() {
    }
    public Book(String title) {
        this.title = title;
    }
    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String bookName) {
        this.title = bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + title + '\'' +
                ", author=" + author +
                ", review=" + review +
                '}';
    }
}
