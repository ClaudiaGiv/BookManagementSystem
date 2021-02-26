package service;

import repository.AuthorRepository;
import model.Author;

import java.util.List;

public class AuthorService {


    AuthorRepository authorRepository = new AuthorRepository();

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author findById(int id) {
        return authorRepository.findById(id);
    }


    public int create(Author author) {
        int result = authorRepository.create(author);
        return result;
    }

    public void update(Author author, Author authorToBeChanged) {
        authorRepository.update(author, authorToBeChanged);
    }
    public void update(Author author){
        authorRepository.update(author);
    }

    public void delete(Author author) {
        authorRepository.delete(author);
    }



}
