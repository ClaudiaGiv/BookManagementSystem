package repository;

import java.util.List;

public interface RepositoryInterface<T> {

    List<T> findAll();

    T findById(int id);

    int create(T t);

    void update(T t);

    void delete(T t);


}
