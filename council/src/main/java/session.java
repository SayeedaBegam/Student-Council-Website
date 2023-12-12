import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.*;

/**
 * Servlet implementation class session
 */
public class session extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public session() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the user's email and password from the login form
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Check if the email and password are valid
        if (isValid(email, password)) {

            // Create a new session for the user
            HttpSession session = request.getSession();
            session.setAttribute("email", email);

            // Redirect the user to the events page
            response.sendRedirect("events.html");

        } else {
            // If the email and password are not valid, show an error message and redirect to the login page
            request.setAttribute("errorMessage", "Invalid email or password");
            RequestDispatcher rd = request.getRequestDispatcher("login.html");
            rd.forward(request, response);
        }
	}
	private boolean isValid(String email, String password) {
        // Perform validation logic here (e.g. check against a database)
        // Return true if the email and password are valid, false otherwise
        return true;
    }

}
