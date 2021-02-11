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
	boolean create(User user);

	// Actualizar un usuario existente y lo cambia en la base de datos
	boolean update(User user);
	
	
}
