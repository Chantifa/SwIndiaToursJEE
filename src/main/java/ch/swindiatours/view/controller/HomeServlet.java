package ch.swindiatours.view.controller;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "home", value = "/home")
public class HomeServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Welcome To SwIndiaTours!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<nav></nav>");
        out.println("</body></html>");
    }
    public void destroy() {
    }
}