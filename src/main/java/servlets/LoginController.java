package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import interfaces.UserDAOImplement;
import entities.User;
import entities.AppConstants;


@WebServlet(name = "LoginServlet", urlPatterns = { "/", "/login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDAOImplement usuarioDAO = new UserDAOImplement();
	public LoginController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (doesValidSessionExist(request)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(AppConstants.REDIRECT_HOME_PAGE);
			dispatcher.forward(request, response);
			return;
		}

		request.getRequestDispatcher(AppConstants.LOGIN_PAGE).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (!usuarioDAO.login(email, password)) {
			request.setAttribute("error",AppConstants.LOGIN_ERROR);
			response.sendRedirect(request.getContextPath() + AppConstants.LOGIN_PAGE);
			return;
		}

		HttpSession session = request.getSession(true);// create session
		User user = usuarioDAO.findByEmail(email);
		session.setAttribute(AppConstants.SESSION_USER, user);
		response.sendRedirect("pages/user-list.jsp");
	}
	


	private boolean doesValidSessionExist(HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null) {

			User user = (User) session.getAttribute(AppConstants.SESSION_USER);

			if (user != null) {
				return true;
			}

		}
		return false;
	}
	

	
	
}
