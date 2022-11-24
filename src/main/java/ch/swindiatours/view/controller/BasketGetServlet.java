package ch.swindiatours.view.controller;

import ch.swindiatours.model.Booking;
import ch.swindiatours.model.BookingPos;
import ch.swindiatours.model.Customer;
import ch.swindiatours.services.BookingPosService;
import ch.swindiatours.services.BookingService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

/**
 * Servlet for getting basket of logged-in user using HTTP Post
 *
 * @author chant
 * @version 1.0
 */
@WebServlet("/BasketGet")
public class BasketGetServlet extends HttpServlet {

    /**
     * POST request to get the basket, only valid if Benutzer signed in
     *
     * @param request  forward to login.html if no valid Signin
     * @param response Formwatted HTML of the basket with list of items tours)
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        PrintWriter out = response.getWriter();


        // Check if user is logged in
        if (customer != null) {
            // Try getting the pending order
            BookingService bookingService = new BookingService();
            Booking booking = (Booking) session.getAttribute("cart");

            // Check for orders in DB
            if (booking == null) {
                try {
                    booking = bookingService.findById(booking.getBookingId().toString());
                } catch (Exception e) {
                    booking = null;
                }
            }

            if (booking == null) {
                out.println("<h2> Warenkorb leer</h2>");
            } else {
                BigDecimal totalPrice = BigDecimal.valueOf(0);
                BookingPosService bookingPosService = new BookingPosService();
                List<BookingPos> bookingPosList = bookingPosService.findAllByOrder(booking);

                out.println("<div class=\"container\">");
                out.println("<div class=\"row\">");
                out.println("<div class=\"col\"><b>description</b></div>");
                out.println("<div class=\"col\"><b>tour price</b></div>");
                out.println("<div class=\"col\"><b>qunatity</b></div>");
                out.println("<div class=\"col\"><b>total price</b></div>");
                out.println("</div>");
                for (BookingPos i : bookingPosList) {
                    out.println("<div class=\"row\">");
                    out.println("<div class=\"col\">" + i.getTourId().getTitel() + "</div>");
                    out.println("<div class=\"col\">" + i.getTourId().getPrice() + "</div>");
                    out.println("<div class=\"col\">" + i.getQuantity() + "</div>");
                    out.println("<div class=\"col\">" + i.getPrice() + " CHF</div>");
                    out.println("</div>");
                    totalPrice = i.getPriceTotal();
                }
                booking.setPrice(totalPrice);
                session.setAttribute("cart", booking);
                out.println("</div>"); // End container

                out.println("<h2>Booking: " + booking.getBookingId() + "</h2>");
                out.println("<h2>Orderdate: " + booking.getBookingDate().toLocalDate() + "</h2>");
                out.println("<h2>Bestellung Total: " + totalPrice + " CHF</h2>");
                out.println("<h2><a href=\"OrderPlace\">order</a></h2>");
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
            dispatcher.forward(request, response);
        }
    }
}

