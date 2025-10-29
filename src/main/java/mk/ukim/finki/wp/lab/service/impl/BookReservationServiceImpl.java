package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.repository.BookReservationRepository;
import mk.ukim.finki.wp.lab.service.BookReservationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookReservationServiceImpl implements BookReservationService {

    private final BookReservationRepository bookReservationRepository;

    public BookReservationServiceImpl(BookReservationRepository bookReservationRepository) {
        this.bookReservationRepository = bookReservationRepository;
    }

    @Override
    public BookReservation placeReservation(String bookTitle, String readerName, String readerAddress, int numberOfCopies) {
       BookReservation reservation = new BookReservation(bookTitle,readerName,readerAddress,(long)numberOfCopies);
       return this.bookReservationRepository.save(reservation);
    }

    @Override
    public List<BookReservation> findByBookTitle(String bookTitle) {
        return DataHolder.reservations.stream()
                .filter(r -> r.getBookTitle().equals(bookTitle))
                .toList();
    }


}
