package servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entities.User;
import interfaces.UserDAOImplement;
import interfaces.IUserDAO;



/**
 * Servlet implementation class UserController
 * 
 * http://localhost:8080/M3_Diego_Rey/UserController
 * 
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	// EntityManager
			EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("M3_Diego_Rey");
			EntityManager manager = managerFactory.createEntityManager();
			
			RequestDispatcher dispatcher = null;
			
			UserDAOImplement userDAO = new UserDAOImplement();
			

			protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				// Recupera los datos de usuarios de la base de datos, se los devolvemos al navegador
				String idString = request.getParameter("id");
		/*		Long id = Long.valueOf(idString);
				
				if (id != null) {
					User usuario = manager.find(User.class, id);
					if (usuario != null) {
						response.getWriter().append(usuario.toString());
						return;
					} else {
						response.getWriter().append("No se ha detectado el usuario " + id + " en la base de datos.");
					}
				}
	*/
				
				
				String action = request.getParameter("action");
				
				if (action == null) {
					action = "LIST";
				}
				
				
				switch (action) {
				
				
				case "LIST":
					userList(request, response);
					break;
					
				case "VIEW":
					userView(request, response);
					break;
				
				case "EDIT":
					userEdit(request, response);
					break;
					
				case "DELETE":
					deleteUser(request, response);
					break;
					
				default:
					userList(request, response);
					break;
				
				}
				
				
			}
			
			
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				
				// 1 - Recibimos datos del formulario de creación de usuario
					
					String id = request.getParameter("id");
					
				
					String firstname = request.getParameter("firstname");
					String lastname = request.getParameter("lastname");
					Integer age = Integer.valueOf(request.getParameter("age"));
					String email = request.getParameter("email");
					String password = request.getParameter("password");
					String nif = request.getParameter("nif");
					Boolean married = Boolean.valueOf(request.getParameter("married"));
					
					
				// 2 - Almacenamos en la base de datos. Para ello, creamos un nuevo usuario.
					
					User usuario = new User();

					usuario.setFirstname(firstname);
					usuario.setLastname(lastname);
					usuario.setAge(age);
					usuario.setEmail(email);
					usuario.setPassword(password);
					usuario.setNif(nif);
					//	usuario.setMarried(married);
					if (request.getParameter("married") != null && request.getParameter("married").equals("on")) {
						usuario.setMarried(true);
					} else {
						usuario.setMarried(false);
					}
					// 3 - Guardamos el objeto o actualizamos.
					
					if (id == null || id.isEmpty()) {
						if(userDAO.create(usuario)) {
							request.setAttribute("NOTIFICATION", "El usuario se ha creado correctamente.");
						}
						
					} else {
						usuario.setId(Long.parseLong(id));
							if(userDAO.update(usuario)) {
							request.setAttribute("NOTIFICATION", "El usuario se ha actualizado correctamente.");
							}
					}
					
					userList(request, response);

	}
		
			private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String id = request.getParameter("id");
				if(userDAO.delete(Long.parseLong(id))) {
					request.setAttribute("NOTIFICATION", "El usuario ha sido borrado correctamente.");
				}
				userList(request, response);
			}
			
			private void userView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String id = request.getParameter("id");
				
				if (id == null || id.isEmpty()) {
					request.setAttribute("NOTIFICATION", "Por favor, introduzca un id válido");
					userList(request, response);
					return;
					
				}
				Long idUser = Long.valueOf(id);
				User usuario = userDAO.findOne(idUser);
					if (usuario == null) {
						request.setAttribute("NOTIFICATION", "El usuario con la ID solicitada no existe en la base de datos.");
						userList(request, response);
						return;
					}
					
				request.setAttribute("user", usuario);
				
				dispatcher = request.getRequestDispatcher("/pages/user-view.jsp");
				dispatcher.forward(request,  response);
			}
			
			private void userEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String id = request.getParameter("id");
				User usuario = userDAO.findOne(Long.parseLong(id));
				request.setAttribute("user", usuario);
				dispatcher = request.getRequestDispatcher("/pages/user-edit.jsp");
				dispatcher.forward(request, response);
			}
			
			
			private void userList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				List<User> userList = userDAO.findAll();
				request.setAttribute("lista", userList);
				
				dispatcher = request.getRequestDispatcher("/pages/user-list.jsp");
				dispatcher.forward(request, response);
			}
	
			
}
