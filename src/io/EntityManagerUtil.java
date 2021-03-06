package io;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	
	
	public static EntityManager getEntityManager(){
		try{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ANMAIServer");
		EntityManager em = emf.createEntityManager();
		System.out.println("em.getProperties(): " + em.getProperties());
		em.getTransaction().begin();
		return em;
		}
		catch(javax.persistence.PersistenceException ex){
			System.err.println("Error thrown in EntityManagerUtil, reason:" + ex);
			throw ex;
		}
	}

}
