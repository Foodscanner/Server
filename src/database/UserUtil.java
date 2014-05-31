package database;

import io.EntityManagerUtil;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.mindrot.jbcrypt.BCrypt;

import database.exceptions.NonUniqueKeyException;
import foodServer.User;
import foodServer.Article;
import foodServer.Flag;
import foodServer.exceptions.DatabaseConnectionException;

public class UserUtil {
	
	
	/**
	 * @param userName
	 * @returns user is username is unique and user exists
	 */
	public static User retrieveUser(String userName){
	
	User user = null;
	EntityManager em = EntityManagerUtil.getEntityManager();
	TypedQuery<User> query = em.createNamedQuery(User.FIND_USER_BY_USERNAME, User.class);
	query.setParameter(User.PARAM_USERNAME, userName);
	
		List<User> result = query.getResultList();
	System.out.println("query executed");
	if(result.size() == 1){
	user = result.get(0);
	}
	else{
	}
	
	em.flush();
	em.close();
	return user;
	}
	
	/**
	 * Inserts user into db after salting pw
	 * @param user The user to be inserted in database
	 * 
	 */
	public static void insertNewUser(User user){
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		System.out.println("Salted pw:" + user.getPassword());
		EntityManager em = EntityManagerUtil.getEntityManager();
		em.persist(user);
		em.flush();
		em.close();
	}
}
