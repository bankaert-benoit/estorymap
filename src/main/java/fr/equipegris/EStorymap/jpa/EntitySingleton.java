package fr.equipegris.EStorymap.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntitySingleton {
	
	private static final String PERSISTENCEUNIT = "Biblio";
	
	private static EntityManager theManager = null;
	
	
	private EntitySingleton() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCEUNIT);
		theManager = emf.createEntityManager();
	}
	
	public static EntityManager getManager() {
		if( theManager == null) new EntitySingleton();
		return theManager ;
	}

}
