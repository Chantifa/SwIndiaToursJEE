package ch.swindiatours.view.controller;

import ch.swindiatours.model.Customer;
import ch.swindiatours.model.Booking;
import ch.swindiatours.model.BookingState;
import ch.swindiatours.services.BookingService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Servlet for placing a single order using HTTP GET.
 *
 * @author chant
 * @version 1.0
 */
@WebServlet("/OrderPlace")
public class BookingPlacedServlet extends HttpServlet {

    /**
     * GET Method to place an order, removing the order from basket and open it to payment.
     *
     * @param request  -
     * @param response if all successfull forward to booking.html, if no user signed in forward to login.html
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        RequestDispatcher dispatcher;
        // Check if user is logged in
        if (customer != null) {
            // Try getting the pending order
            BookingService bookingService = new BookingService();
            Booking booking = (Booking) session.getAttribute("basket");

            // Create order if none existing
            if (booking != null) {
                BigDecimal price = booking.getPrice();
                booking = bookingService.findById(customer.getUserId().toString());
                booking.setBookingState(BookingState.PLACED);
                booking.setPrice(price);

                bookingService.remove(booking);
                bookingService.create(booking);
                session.removeAttribute("basket");
            }
            dispatcher = request.getRequestDispatcher("booking.html");
        } else {
            dispatcher = request.getRequestDispatcher("login.html");
        }
        dispatcher.forward(request, response);
    }
}

