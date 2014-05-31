package database.tests;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;

import io.EntityManagerUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import database.UserUtil;
import foodServer.User;

public class UserPersistenceTests {
	
	User user;
	
	@Test
	public void persistUser(){
		user = new User();
		user.setUsername("example@example.org");
		user.setFirstName("Michael");
		user.setLastName("Collins");
		String pw = "helloWorld";
		user.setPassword(pw);
		System.out.println("User: " + user);
		UserUtil.insertNewUser(user);
		
		
		User retrievedUser = UserUtil.retrieveUser(user.getUsername());
		System.out.println("retrievedUser" + retrievedUser);
		assertTrue(retrievedUser.getUsername().equals(user.getUsername()));
		assertTrue(retrievedUser.passwortCorrect(pw));
	}
	
	@Before
	public void cleanDb(){
		System.out.println("cleanDB");
		EntityManager em = EntityManagerUtil.getEntityManager();
		User usr = em.find(User.class, "example@example.org");
		System.out.println(usr);
		em.remove(usr);
		em.getTransaction().commit();
		em.close();
	}

}
