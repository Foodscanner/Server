package foodServer;

import datatype.EAN13;
import datatype.IEAN;
import foodServer.exceptions.ArticleNotFoundException;
import foodServer.exceptions.NumberInvalidFormatException;

/**
 * Used for creating instances of Articles by retrieving them from database
 * @author Christian Gl�ser
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
	public static Article getArticle(IEAN ean1) {
		Article article = null;
		  //retrieve article from db
		  //article = ....
		return article;
	}
	
	//if more kinds of articles existed, more methods would be here
}