package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory manager = Persistence.createEntityManagerFactory("M3_Diego_Rey");
	

	public static EntityManager getEntityManager() {
		return manager.createEntityManager();
	}

}