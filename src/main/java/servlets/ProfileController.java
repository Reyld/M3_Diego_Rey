package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.IUserDAO;
import interfaces.UserDAOImplement;
import entities.User;
import entities.AppConstants;


@WebServlet(name = "ProfileServlet", urlPatterns = { "/profile" })
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserDAO usuarioDAO = new UserDAOImplement();

		
    public ProfileController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null || action.length() == 0) 
			action = AppConstants.ACTION_RETRIEVE;
		
		switch (action) {
			case AppConstants.ACTION_RETRIEVE:
				retrieve(request, response);
				break;
			default:
				retrieve(request, response);
		}
	}



	private void retrieve(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User usuario = (User) request.getSession().getAttribute("user");
		User user = usuarioDAO.findOne(Long.valueOf(usuario.getId()));
		request.setAttribute("user", user);
		request.getRequestDispatcher(AppConstants.CREATE_USER_PAGE).forward(request, response);		
	}

	// solo actualiza, no crea
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setId(Long.valueOf(request.getParameter("id")));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		usuarioDAO.update(user);
		
	}

}
