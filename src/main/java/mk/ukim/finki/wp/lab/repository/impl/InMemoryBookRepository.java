package mk.ukim.finki.wp.lab.repository.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.repository.BookRepository;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryBookRepository implements BookRepository {

    @Override
    public List<Book> findAll() {
        return DataHolder.books;
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return DataHolder.books.stream()
                .filter(b -> b.getTitle().contains(text) &&
                        b.getAverageRating() >= rating)
                .toList();
    }

    @Override
    public void delete(Long id) {
        DataHolder.books.removeIf(b -> b.getId().equals(id));
    }

    @Override
    public Optional<Book> findById(Long bookId) {
        return DataHolder.books.stream()
                .filter(b -> b.getId().equals(bookId))
                .findFirst();
    }

    @Override
    public Book save(Book book) {
        delete(book.getId());
        DataHolder.books.add(book);
        return book;
    }


}
