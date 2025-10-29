package mk.ukim.finki.wp.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.service.BookReservationService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;
import org.thymeleaf.web.IWebExchange;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "PastReservationsServlet", urlPatterns = "/pastReservations")
public class PastReservationsServlet extends HttpServlet {

    private final BookReservationService bookReservationService;
    private final org.thymeleaf.spring6.SpringTemplateEngine springTemplateEngine;

    public PastReservationsServlet(BookReservationService bookReservationService,
                                   org.thymeleaf.spring6.SpringTemplateEngine springTemplateEngine) {
        this.bookReservationService = bookReservationService;
        this.springTemplateEngine = springTemplateEngine;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);

        String bookTitle = req.getParameter("bookTitle");

        List<BookReservation> reservations =
                this.bookReservationService.findByBookTitle(bookTitle);

        context.setVariable("reservations",reservations);
        context.setVariable("bookTitle",bookTitle);

        springTemplateEngine.process("pastReservations.html", context, resp.getWriter());


    }
}
