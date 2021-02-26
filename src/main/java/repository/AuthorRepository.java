package repository;

import model.Author;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.io.Serializable;
import java.util.List;

public class AuthorRepository implements RepositoryInterface<Author> {



    @Override
    public List<Author> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Author> result = session.createQuery("Select a From Author a").getResultList();
        session.close();
        return result;
    }

    @Override
    public Author findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Author author = session.find(Author.class, id);
        session.close();
        return author;
    }

    @Override
    public int create(Author author) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Serializable result = session.save(author);
        int res = Integer.parseInt(result.toString());
        transaction.commit();
        session.close();
        return res;
    }
    @Override
    public void update(Author author) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(author);
        transaction.commit();
        session.close();
    }
    public void update(Author author, Author authorToBeChanged) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Author author1 = session.get(Author.class, author.getAuthorId());
        author1.setFirstName(authorToBeChanged.getFirstName());
        author1.setLastName(authorToBeChanged.getLastName());
        session.update(author1);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Author author) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(author);
        transaction.commit();
        session.close();
    }


}
