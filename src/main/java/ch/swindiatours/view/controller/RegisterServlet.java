package ch.swindiatours.view.controller;

import ch.swindiatours.model.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet(name="register", value="/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String firstname = request.getParameter("firstname");
        String pwd = request.getParameter("password");
        String lastname = request.getParameter("lastname");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        UUID id = UUID.randomUUID();

        Customer c = new Customer();

        c.setUsername(firstname, lastname);
        c.setFirstname(firstname);
        c.setLastname(lastname);
        c.setPassowrd(pwd);
        c.setCity(city);
        c.setId(id.hashCode());
        c.setStreet(street);

        request.getRequestDispatcher("register.jsp").include(request, response);
        out.print("<center><p>Please Enter Valid Details to Register</p></center>");
        //this executes when fields are left blank
    }
}
