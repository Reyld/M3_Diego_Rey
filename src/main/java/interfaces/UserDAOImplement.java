package interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import interfaces.IUserDAO;
import entities.User;
import entities.JPAUtil;

public class UserDAOImplement implements IUserDAO{

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

		// Crea un nuevo usuario
		
		@Override
		public boolean create(User user) {
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
			return flag;
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

		@Override
		public boolean update(User user) {
			boolean flag = false;
			try {
				manager = JPAUtil.getEntityManager();
				manager.getTransaction().begin();   
				manager.merge(user); 
				manager.getTransaction().commit(); 
				manager.close();
				flag = true;
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			return flag;
		}
		
}
