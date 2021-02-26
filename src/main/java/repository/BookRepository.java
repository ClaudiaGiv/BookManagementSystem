package repository;

import model.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


import java.io.Serializable;
import java.util.List;

public class BookRepository implements RepositoryInterface<Book> {


    @Override
    public List<Book> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Book> result = session.createQuery("Select b From Book b").getResultList();
        session.close();
        return result;
    }

    @Override
    public Book findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Book book = session.find(Book.class, id);
        session.close();
        return book;
    }

    @Override
    public int create(Book book) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Serializable result = session.save(book);
        int res = Integer.parseInt(result.toString());
        transaction.commit();
        session.close();
        return res;
    }




    public void update(Book book, Book bookToBeChanged) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Book book1 = session.get(Book.class, book.getBookId());
        book1.setTitle(bookToBeChanged.getTitle());
        session.update(book1);
        transaction.commit();
        session.close();
    }

    public void update(Book book) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(book);
        transaction.commit();
        session.close();
    }


    @Override
    public void delete(Book book) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(book);
        transaction.commit();
        session.close();
    }

}
