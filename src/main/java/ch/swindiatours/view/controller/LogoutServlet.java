package ch.swindiatours.view.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet for log-out of current user using HTTP GET.
 *
 * @author chant
 * @version 1.0
 */
@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {

    /**
     * GET Method to log out user
     *
     * @param request
     * @param response forward to index.jsp
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final HttpSession session = request.getSession();
        final RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        //Benutzer benutzer = (Benutzer) session.getAttribute("benutzer");
        //if (benutzer != null) {
        session.removeAttribute("customer");
        //}
        dispatcher.forward(request, response);
    }
}
