package database;

import java.util.List;

import io.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import database.exceptions.NonUniqueKeyException;
import datatype.EAN;
import datatype.IEAN;
import foodServer.Article;
import foodServer.Flag;
import foodServer.exceptions.DatabaseConnectionException;

/**
 * Used for creating instances of Articles by retrieving them from database
 * @author Christian Gläser
 *
 */
public class ArticleUtil {
	
	/**
	 * Private standard constructor to prevent initialization
	 */
	private ArticleUtil(){}

	/**
	 * Retrieves an article from database and sets values correctly
	 * @param ean1 The id of the article, needs to be a valid EAN
	 * @return An article of type Article, if article is in Database. Else null is returned.
	 */
	public static Article getArticle(IEAN ean1) throws DatabaseConnectionException {
		Article article = null;
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<Article> query = em.createNamedQuery(Article.FIND_ARTICLE_BY_ARTICLEID, Article.class);
		query.setParameter(Article.PARAM_ARTICLEID, ean1.getEAN());
		try{
			List<Article> result = query.getResultList();
		System.out.println("query executed");
		if(result.size() == 1){
		article = result.get(0);
		Integer i = 0;
		for(Flag f:article.getFlags()){
			if(f!=null){i++;}		}
		for(Flag f:article.getAllFlags()){
			if(f!=null){i++;}
		}
		}
		else if(result.size()>1){
			throw new NonUniqueKeyException("The ean " + ean1 + " supplied is not unique. Please contact the Database administrator!");
		}
		}
		catch (Exception ex){
		throw new DatabaseConnectionException("Exception ex has been thrown, stacktrace: " + ex);
		}
		
		return article;
	}
	
	//if more kinds of articles existed, more methods would be here
}
