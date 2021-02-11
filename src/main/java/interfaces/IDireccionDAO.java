package interfaces;

import java.util.List;

import entities.Direccion;

public interface IDireccionDAO {
	
	// Recupera un objeto direccion de la tabla
	Direccion findOne(Long id);
	
	// Recupera TODAS las direcciones de la table
	List<Direccion> findAll();
	
	// Almacenamos una direccion
	boolean create(Direccion direccion);
	
	// Actualizamos una direccion
	boolean update(Direccion direccion);
	
	// Borramos una direccion
	boolean delete(Long id);
	
}
