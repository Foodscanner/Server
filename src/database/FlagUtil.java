package database;

import io.EntityManagerUtil;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;




import database.exceptions.NoFlagsExistException;
import foodServer.Article;
import foodServer.Flag;
import foodServer.exceptions.DatabaseConnectionException;

public class FlagUtil {
	
	public static List<Flag> getAllFlags() throws NoFlagsExistException, DatabaseConnectionException{
		List<Flag> flags = null;
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<Flag> query = em.createNamedQuery(Flag.FIND_FLAGS, Flag.class);
		try{
			flags = query.getResultList();
			System.out.println(flags.size());
		System.out.println("query executed");
		if(flags.size() == 0){
			throw new NoFlagsExistException("Database is empty");
		}
		}
		catch (Exception ex){
		throw new DatabaseConnectionException("Exception ex has been thrown, stacktrace: " + ex);
		}
		
		return flags;
	}
	
	
	public static Flag getFlag(int id) throws DatabaseConnectionException {
		List<Flag> flags = null;
		Flag resultFlag = null;
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<Flag> query = em.createNamedQuery(Flag.FIND_FLAG_BY_FLAGID, Flag.class);
		query.setParameter(Flag.PARAM_FLAGID, id);
		try{
			flags = query.getResultList();
			System.out.println(flags.size());
		System.out.println("query executed");
		if(flags.size() == 1){
			resultFlag = flags.get(0);
		}
		}
		catch (Exception ex){
		throw new DatabaseConnectionException("Exception ex has been thrown, stacktrace: " + ex);
		}
		
		return resultFlag;
	}

}
