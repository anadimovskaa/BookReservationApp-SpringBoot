package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.service.AuthorService;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {


    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping()
    public String getBooksPage(@RequestParam(required = false)
                               String error,
                               Model model){
        if(error != null){
            model.addAttribute("error",error);
        }

        List<Book> books;
        books= bookService.listAll();
        model.addAttribute("books",books);
        return "listBooks";
    }


    @GetMapping("/book-form")
    public String getAddBookPage(Model model){
        model.addAttribute("authors", authorService.findAll());
        return "book-form";
    }

    @GetMapping("/book-form/{bookId}")
    public String getEditBookForm(@PathVariable Long bookId, Model model){
//        if(bookId == null){
//            return "redirect:/books?error=BookNotFound";
//        }
//        Book book = bookService.findById(bookId);
//        model.addAttribute("bookId", book.getId());
//        model.addAttribute("title", book.getTitle());
//        model.addAttribute("genre", book.getGenre());
//        model.addAttribute("averageRating", book.getAverageRating());
//        model.addAttribute("authorId", book.getAuthor().getId());
        model.addAttribute("book", bookService.findById(+bookId));
        model.addAttribute("authors", authorService.findAll());
        return "book-form";
    }


    @PostMapping("/edit/{bookId}")
    public String editBook(@PathVariable Long bookId,
                           @RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId
    ) {
        bookService.update(bookId, title, genre, averageRating, authorId);
        return "redirect:/books";
    }


    @GetMapping("/add-form")
    public String addBookPage(Model model){
        model.addAttribute("authors",authorService.findAll());
        return "book-form";
    }

    @PostMapping("/add")
    public String saveBook(
                           @RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId) {

        bookService.create(title,genre,averageRating,authorId);
        return "redirect:/books";
    }


    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.delete(id);
        return "redirect:/books";
    }

    @PostMapping("/like/{id}")
    public String likeBook(@PathVariable Long id) {
        bookService.likeBook(id);
        return "redirect:/books";
    }
}
