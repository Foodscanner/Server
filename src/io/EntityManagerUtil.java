package io;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	
	
	public static EntityManager getEntityManager(){
		try{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ANMAIServer");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		return em;
		}
		catch(javax.persistence.PersistenceException ex){
			System.err.println("Error thrown in EntityManagerUtil, reason:" + ex);
			throw ex;
		}
	}

}
