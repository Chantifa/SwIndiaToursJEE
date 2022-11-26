package ch.swindiatours.view.controller;

import ch.swindiatours.model.Booking;
import ch.swindiatours.model.BookingState;
import ch.swindiatours.model.Customer;
import ch.swindiatours.services.BookingService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet for paying single order using HTTP GET, no actual payment is done but simulated status change
 *
 * @author chant
 * @version 1.0
 */
@WebServlet("/BookingPaid")
public class BookingPayServlet extends HttpServlet {

    /**
     * GET Method to pay an order, only works when user (Benutzer) is signed in.
     *
     * @param request  -
     * @param response forward to booking.html when successfull or forward to login.html if no user signed in
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
            String userId = request.getParameter("customer");
            if (!userId.isEmpty()) {
                // Create order if none existing
                try {
                    Booking booking = bookingService.findById(userId);
                    if (booking.getBookingState() == BookingState.PLACED) {
                        booking.setBookingState(BookingState.PAID);
                        bookingService.remove(booking);
                        bookingService.create(booking);
                    }
                } catch (Exception ex) {

                }
            }
            dispatcher = request.getRequestDispatcher("booking.html");
        } else {
            dispatcher = request.getRequestDispatcher("login.html");
        }
        dispatcher.forward(request, response);
    }
}

