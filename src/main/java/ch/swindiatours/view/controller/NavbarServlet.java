package ch.swindiatours.view.controller;

import ch.swindiatours.model.Customer;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import static ch.swindiatours.model.Role.CUSTOMER;

/**
 * Servlet for getting the navigation bar using HTTP POST.
 *
 * @author chant
 * @version 1.0
 */
@WebServlet(name="navbar", value="/navbar")
public class NavbarServlet extends HttpServlet {

    /**
     * POST request to get navigation bar.
     * Only reigstered users get to see options, unregistered users only see reigstering and signin
     *
     * @param request  -
     * @param response containing HTML of navbar to be displayed
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        PrintWriter out = response.getWriter();
        out.println("<ul class=\"navbar-nav\">");
        // Registered user -> more options available
        if (customer != null) {
            out.print("<li class=\"nav-item\"><a class=\"nav-link\" href=\"basket.jsp\">basket</a></li>");
            out.print("<li class=\"nav-item\"><a class=\"nav-link\" href=\"orders.jps\">Bookings</a></li>");
            out.print("<li class=\"nav-item\"><a class=\"nav-link\" href=\"account.jsp\">account</a></li>");
            if (!customer.getRole().equals(CUSTOMER)) {
                out.print("<li class=\"nav-item\"><a class=\"nav-link\" href=\"tour.jsp\">Add tour</a></li>");
            }
            out.print("<li class=\"nav-item\"><a class=\"nav-link\" href=\"UserLogout\">logout</a></li>");
        } else {// Not registered user -> only allow registration/signing and search possible
            out.print("<li class=\"nav-item\"><a class=\"nav-link\" href=\"login.jsp\">login</a></li>");
            out.print("<li class=\"nav-item\"><a class=\"nav-link\" href=\"register.jsp\">registration</a></li>");
        }
        out.println("</ul>");
    }
}
