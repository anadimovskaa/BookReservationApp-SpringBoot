package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.BookReservation;

import java.util.List;
import java.util.Optional;

public interface BookReservationService {
    BookReservation placeReservation
            (String bookTitle, String readerName,
             String readerAddress, int numberOfCopies);

    List<BookReservation> findByBookTitle(String bookTitle);
}
