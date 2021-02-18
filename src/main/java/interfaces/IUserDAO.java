package interfaces;

import java.util.List;

import entities.User;

public interface IUserDAO {

	// Lista de usuarios
	List<User> findAll();

	// Encontrar UN usuario mediante su ID
	User findOne(Long id);

	// Borrar un usuario específico de la base de datos
	boolean delete(Long id);

	// Crear un nuevo usuario, lo almacena en la base de datos
	public User create(User user);

	// Actualizar un usuario existente y lo cambia en la base de datos
	boolean update(User user);
	
	// Sistema de login
	public boolean login(String email, String password);
	
	// Sistema de búsqueda por el email
	public User findByEmail(String email);
	
	// Actualizar la contraseña
	public User updatePassword(Long userId, String newPass);
	
}


