package mk.ukim.finki.wp.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.service.BookReservationService;
import mk.ukim.finki.wp.lab.service.BookService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "BookReservationServlet" , urlPatterns = "/bookReservation")
public class BookReservationServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final BookReservationService bookReservationService;
    private final BookService bookService;

    public BookReservationServlet(SpringTemplateEngine springTemplateEngine, BookReservationService bookReservationService, BookService bookService) {
        this.springTemplateEngine = springTemplateEngine;
        this.bookReservationService = bookReservationService;
        this.bookService = bookService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);

        context.setVariable("ipAddress", req.getRemoteAddr());
        context.setVariable("readerName",((BookReservation) req.getSession().getAttribute("lastReservation")).getReaderName());
        context.setVariable("bookTitle",((BookReservation) req.getSession().getAttribute("lastReservation")).getBookTitle());
        context.setVariable("numCopies",((BookReservation) req.getSession().getAttribute("lastReservation")).getNumberOfCopies());

        springTemplateEngine.process("reservationConfirmation.html",context,resp.getWriter());
    }
}
