package repository;

import model.Review;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.io.Serializable;
import java.util.List;

public class ReviewRepository implements RepositoryInterface<Review> {


    @Override
    public List<Review> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Review> result = session.createQuery("Select r From Review r").getResultList();
        session.close();
        return result;
    }

    @Override
    public Review findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Review review = session.find(Review.class, id);
        session.close();
        return review;
    }

    @Override
    public int create(Review review) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Serializable result = session.save(review);
        int res = Integer.parseInt(result.toString());
        transaction.commit();
        session.close();
        return res;
    }

    @Override
    public void update(Review review) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(review);
        transaction.commit();
        session.close();
    }
    public void update(Review review, Review reviewToBeChanged) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Review review1 = session.get(Review.class, review.getReviewId());
        review1.setDescription(reviewToBeChanged.getDescription());
        session.update(review1);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Review review) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(review);
        transaction.commit();
        session.close();
    }

}
