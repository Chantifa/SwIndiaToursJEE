package ch.swindiatours.view.controller;

import ch.swindiatours.model.Customer;
import ch.swindiatours.services.CustomerService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
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

        final String firstname = request.getParameter("firstname");
        final String lastname = request.getParameter("lastname");
        final String pwd = request.getParameter("password");
        final String repeadpwd = request.getParameter("repeatepassword");

        final String email = request.getParameter("email");
        final String username = email;
        final UUID id = UUID.randomUUID();

        Customer c = new Customer();

        c.setFirstName(firstname);
        c.setLastName(lastname);
        c.setUsername(username);
        c.setEmail(email);
        c.setPassword(pwd);

        // Check if password repeat is correct
        if (!(lastname.isEmpty() || firstname.isEmpty() ||
                username.isEmpty() || email.isEmpty() ||
                pwd.isEmpty() || repeadpwd.isEmpty())) {
            if (checkPassword(pwd, repeadpwd)) {
                CustomerService customerService = new CustomerService();

                final HttpSession session = request.getSession();

                customerService.create(c);
                session.setAttribute("customer", c);

            }

            if (firstname.isEmpty() || lastname.isEmpty() || email.isEmpty() || pwd.isEmpty()) {
                request.getRequestDispatcher("register.jsp").include(request, response);
                out.print("<center><p>Please Enter Valid Details to Register</p></center>");
            } else {
                request.getRequestDispatcher("register_2.jsp").include(request, response);
            }
        }
    }
    /**
     * Check if both passwords are equal, if not deny registering
     * @param pwd the actual password
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
