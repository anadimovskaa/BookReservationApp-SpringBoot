package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Book;

import java.util.List;

public interface BookService {
    List<Book> listAll();

    List<Book> searchBooks(String text, Double rating);

    void delete(Long id);

    Book findById(Long bookId);

    Book create(String title, String genre, Double averageRating, Long authorId);

    Book update(Long id,String title, String genre, Double averageRating, Long authorId);

    void likeBook(Long id);
}
