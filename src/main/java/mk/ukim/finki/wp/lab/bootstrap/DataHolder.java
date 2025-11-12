package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.model.BookReservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books = null;
    public static List<Author> authors= null;
    public static List<BookReservation> reservations = new ArrayList<>();

    @PostConstruct
    public void init(){
        books = new ArrayList<>();
        authors= new ArrayList<>();

        authors.add(new Author(
                "George", "Orwell", "United Kingdom",
                "Author of 1984 and Animal Farm."
        ));

        authors.add(new Author(
                "Jane", "Austen", "United Kingdom",
                "Known for Pride and Prejudice and Emma."
        ));

        authors.add(new Author(
                "Fyodor", "Dostoevsky", "Russia",
                "Wrote Crime and Punishment and The Brothers Karamazov."
        ));

        books.add(new Book("To Kill a Mockingbird", "Classic / Coming-of-age", 4.26,authors.get(1),0));
        books.add(new Book("1984", "Dystopian", 4.19,authors.get(0),0));
        books.add(new Book("Pride and Prejudice", "Romance / Classic", 4.29,authors.get(2),0));
        books.add(new Book("The Great Gatsby", "Classic / Tragedy", 3.93,authors.get(0),0));
        books.add(new Book("Harry Potter and the Sorcerer’s Stone", "Fantasy", 4.47,authors.get(1),0));
        books.add(new Book("The Hobbit", "Fantasy / Adventure", 4.28,authors.get(2),0));
        books.add(new Book("The Catcher in the Rye", "Coming-of-age", 3.81,authors.get(0),0));
        books.add(new Book("The Lord of the Rings", "Epic Fantasy", 4.50,authors.get(1),0));
        books.add(new Book("The Kite Runner", "Historical Fiction", 4.34,authors.get(2),0));
        books.add(new Book("The Da Vinci Code", "Thriller / Mystery", 3.90,authors.get(0),0));


    }
}
