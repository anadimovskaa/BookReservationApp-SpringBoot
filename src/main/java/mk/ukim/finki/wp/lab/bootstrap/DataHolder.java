package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.model.BookReservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books = null;
    public static List<BookReservation> reservations = new ArrayList<>();

    @PostConstruct
    public void init(){
        books = new ArrayList<>();

        books.add(new Book("To Kill a Mockingbird", "Classic / Coming-of-age", 4.26));
        books.add(new Book("1984", "Dystopian", 4.19));
        books.add(new Book("Pride and Prejudice", "Romance / Classic", 4.29));
        books.add(new Book("The Great Gatsby", "Classic / Tragedy", 3.93));
        books.add(new Book("Harry Potter and the Sorcerer’s Stone", "Fantasy", 4.47));
        books.add(new Book("The Hobbit", "Fantasy / Adventure", 4.28));
        books.add(new Book("The Catcher in the Rye", "Coming-of-age", 3.81));
        books.add(new Book("The Lord of the Rings", "Epic Fantasy", 4.50));
        books.add(new Book("The Kite Runner", "Historical Fiction", 4.34));
        books.add(new Book("The Da Vinci Code", "Thriller / Mystery", 3.90));

    }
}
