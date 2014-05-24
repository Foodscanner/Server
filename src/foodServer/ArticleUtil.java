package foodServer;

import java.util.List;

import io.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import datatype.EAN13;
import datatype.IEAN;
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
		Article article;
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<Article> query = em.createNamedQuery(Article.FIND_ARTICLE_BY_ARTICLEID, Article.class);
		query.setParameter(Article.PARAM_ARTIKELID, ean1);
		try{
		List<Article> result = query.getResultList();
		article = result.get(0);
		System.out.println(article);
		return article; 
		}
		catch (Exception ex){
		throw new DatabaseConnectionException("Exception ex has been thrown, stacktrace: " + ex);
		}
		
		//return article;
	}
	
	//if more kinds of articles existed, more methods would be here
}