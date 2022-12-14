package ch.swindiatours.view.controller;

import ch.swindiatours.model.Customer;
import ch.swindiatours.services.CustomerService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(name = "register", value = "/register")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CustomerService customerService;

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

        final String firstname = request.getParameter("firstname");
        final String lastname = request.getParameter("lastname");
        final String pwd = request.getParameter("password");
        final String repeadpwd = request.getParameter("repeatepassword");

        final String email = request.getParameter("email");
        final String username = email;

        Customer customer = new Customer();
        customer.setPassword(pwd);
        customer.setUsername(username);
        customer.setEmail(email);
        customer.setFirstName(firstname);
        customer.setLastName(lastname);
        // Check if password repeat is correct
        if (!(lastname.isEmpty() || firstname.isEmpty() ||
                username.isEmpty() || email.isEmpty() ||
                pwd.isEmpty() || repeadpwd.isEmpty())) {
            if (checkPassword(pwd, repeadpwd)) {

                final HttpSession session = request.getSession();

                customerService.create(customer);
                session.setAttribute("customer", customer);

            }

            if (firstname.isEmpty() || lastname.isEmpty() || email.isEmpty() || pwd.isEmpty()) {
                request.getRequestDispatcher("register.jsp").include(request, response);
                out.print("<center><p>Please Enter Valid Details to Register</p></center>");
            } else {
                request.getRequestDispatcher("index.jsp").include(request, response);
            }
        }
    }

    /**
     * Check if both passwords are equal, if not deny registering
     *
     * @param pwd       the actual password
     * @param repeatPwd the repeated password
     * @return true if both are same, false if both don't match
     */
    private boolean checkPassword(String pwd, String repeatPwd) {
        if (pwd != null) {
            return Objects.equals(pwd, repeatPwd);
        }
        return false;
    }


}
