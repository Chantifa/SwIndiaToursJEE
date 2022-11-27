package ch.swindiatours.view.controller;

import ch.swindiatours.model.Booking;
import ch.swindiatours.model.Customer;
import ch.swindiatours.model.BookingState;
import ch.swindiatours.model.Role;
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
import java.util.List;

/**
 * Servlet for getting all orders using HTTP POST.
 *
 * @author chanti
 * @version 1.0
 */
@WebServlet("/BookingGet")
public class BookingGetServlet extends HttpServlet {

    /**
     * POST Method to get all bookings in a formatted HTML list. Showing only bookings of user if role = Rollen.CUSTOMER
     * If role = Role.ADMIN then show all orders in system
     *
     * @param request  -
     * @param response HTML formatted string showing all orders
     *                 Forward to "login.jsp" if no valid user signed in
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
            List<Booking> bookings;

            // Create order if none existing
            try {
                if (customer.getRole().equals(Role.CUSTOMER)) {
                    bookings = bookingService.findByUser(customer);
                } else {
                    bookings = bookingService.findAll();
                }
            } catch (Exception ex) {
                bookings = null;
            }

            if (bookings == null) {
                out.println("<h2> Nothing booked </h2>");
            } else {
                out.println("<div class=\"container\">");
                out.println("<div class=\"row\">");
                if (customer.getRole() != Role.CUSTOMER.toString())
                    out.println("<div class=\"col\"><b>customer</b></div>");
                out.println("<div class=\"col\"><b>booking</b></div>");
                out.println("<div class=\"col\"><b>booking date</b></div>");
                out.println("<div class=\"col\"><b>total price</b></div>");
                out.println("<div class=\"col\"><b>status</b></div>");
                out.println("<div class=\"col\"><b>action</b></div>");
                out.println("</div>");
                for (Booking i : bookings) {
                    out.println("<div class=\"row\">");
                    if (customer.getRole() != Role.CUSTOMER.toString())
                        out.println("<div class=\"col\">" + i.getCustomerId().getEmail() + "</div>");
                    out.println("<div class=\"col\"><a target=\"_blank\" href=\"OrderGet?orderId=" + i.getBookingId() + "\">" + i.getBookingId() + "</a></div>");
                    out.println("<div class=\"col\">" + i.getBookingDate().toLocalDate() + "</div>");
                    out.println("<div class=\"col\">" + i.getPrice() + "</div>");
                    out.println("<div class=\"col\">" + BookingState.getDescription(i.getBookingState()) + "</div>");
                    switch (i.getBookingState()) {
                        case CREATED:
                            out.println("<div class=\"col\"><a href=\"OrderPlace\">ordered</a></div>");
                            break;
                        case PLACED:

                            out.println("<div class=\"col\"><a href=\"BookingPay?bookingId=" + i.getBookingId() + "\">paid</a></div>");
                            break;
                        case PAID:
                            if (customer.getRole() == Role.ADMIN.toString()) {
                                out.println("<div class=\"col\"><a href=\"tourBooked?orderId=" + i.getBookingId() + "\">booked</a></div>");
                            } else {
                                out.println("<div class=\"col\">Tracking... please wait</div>");
                            }
                            break;
                        case BOOKED:
                            out.println("<div class=\"col\">Retour?</div>");
                            break;
                    }
                    out.println("</div>");
                }
                out.println("</div>"); // End container
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
}

