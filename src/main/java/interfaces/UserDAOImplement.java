package interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import interfaces.IUserDAO;
import entities.User;
import entities.JPAUtil;

public class UserDAOImplement implements IUserDAO{

	private static final String USER_COUNT = "SELECT COUNT(u) FROM User u "
			+ "WHERE u.email = :email AND u.password = :password";

	private static final String FIND_BY_EMAIL = "SELECT u FROM User u "
			+ "WHERE u.email = :email ";
	
	
	
	EntityManager manager;
	
	
	
	// Lista de usuarios
	
	@Override
	public List<User> findAll() {
		try {
			manager = JPAUtil.getEntityManager();
			TypedQuery<User> namedQuery = manager.createNamedQuery("user.findAll", User.class);
			List<User> results = namedQuery.getResultList();
			manager.close();
			return results;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	 return new ArrayList<User>();
	}
	
	// Busca un usuario
	
		@Override
		public User findOne(Long id) {
			/*
			User usuario = null;
			try {
				manager = JPAUtil.getEntityManager();
				usuario = manager.find(User.class, id);
				manager.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			return usuario;
		}
		*/
		if (id == null) {
			return null;
		}
		manager = JPAUtil.getEntityManager();
		User usuario = manager.find(User.class, id);
		manager.close();
		return usuario;
		}

		// Crea un nuevo usuario
		
		@Override
		public User create(User user) {
			if (user == null || user.getId() != 0l ) {
				return user;
			}
			boolean flag = false;
			try {
				manager = JPAUtil.getEntityManager();
				manager.getTransaction().begin();   
				manager.persist(user); 
				manager.getTransaction().commit(); 
				manager.close();
				flag = true;
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			return user;
		}

		// Borra un usuario 
		
		@Override
		public boolean delete(Long id) {
			boolean flag = false;
			try {
				manager = JPAUtil.getEntityManager();
				manager.getTransaction().begin();   
				User usuario = manager.find(User.class, id);
				if (usuario != null) {
					manager.remove(usuario);
					manager.getTransaction().commit(); 
					flag = true;
				}
				manager.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			return flag;
		}

		// Actualiza un empleado
		public boolean update(User user) {
			boolean flag = false;
			try {
				manager = JPAUtil.getEntityManager();
				manager.getTransaction().begin();
				User usuario = manager.merge(user);
				manager.getTransaction().commit();
				manager.close();
				flag = true;
			}	catch(Exception ex) {
			ex.printStackTrace();
			
		} 
		
		return flag;

		}
		
		// Metodo Login
		@Override
		public boolean login(String email, String password) {
			manager = JPAUtil.getEntityManager();
			TypedQuery<Long> query = manager.createQuery(USER_COUNT, Long.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			Long numUsuario = query.getSingleResult();
			System.out.println("Numero de usuarios con email y password: " + numUsuario);
			manager.close();
			return numUsuario > 0;
		}
		
		// Metodo para encontrar por el email
		@Override
		public User findByEmail(String email) {
			if (email == null || email.isEmpty()) {
				return null;
			}
			manager = JPAUtil.getEntityManager();
			TypedQuery<User> namedQuery = manager.createQuery(FIND_BY_EMAIL, User.class);
			namedQuery.setParameter("email", email);
			User user = namedQuery.getSingleResult();
			 manager.close();
			return user;
		}
		
		@Override
		public User updatePassword(Long userId, String newPass) {
			if (userId == null) {
				return null;
			}
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();
			User userDB = this.findOne(userId);
			userDB.setPassword(newPass);
			manager.getTransaction().commit();
			manager.close();
			return userDB;
		}
		
		
}
