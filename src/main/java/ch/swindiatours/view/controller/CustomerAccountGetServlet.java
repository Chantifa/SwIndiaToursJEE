package ch.swindiatours.view.controller;

import ch.swindiatours.model.Customer;
import ch.swindiatours.model.Role;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet for account information of user using HTTP POST.
 *
 * @author chant
 * @version 1.0
 */
@WebServlet("/CustomerAccountGet")
public class CustomerAccountGetServlet extends HttpServlet {
    /**
     * POST Method to get user account information
     *
     * @param request  -
     * @param response HTML formatted string of user information
     *                 Forward to login.html if no valid user signed in
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        PrintWriter out = response.getWriter();
        if (customer != null) {
            out.println("<p>");
            out.println("<br>userid: " + customer.getUserId());
            out.println("firstname: " + customer.getFirstName());
            out.println("<br>lastname: " + customer.getLastName());
            out.println("<br>role: " + Role.getDescriptionRole(Role.valueOf(customer.getRole())));
            out.println("<br>email: " + customer.getEmail());
            out.println("</p>");
        } else {
            // No valid user -> only allow registration/signing and search possible
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
            dispatcher.forward(request, response);
        }
    }
}
