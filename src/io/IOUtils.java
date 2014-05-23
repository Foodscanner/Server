package io;

import com.thoughtworks.xstream.XStream;

import datatype.EAN13;
import datatype.IEAN;
import datatype.StandardExchangeArticle;
import foodServer.ArticleUtil;
import foodServer.IArticle;
import foodServer.IFlag;
import foodServer.exceptions.DatabaseConnectionException;
import foodServer.exceptions.NumberInvalidFormatException;

public class IOUtils {
	private IOUtils() {
	}

	/**
	 * Upon getting a long ID originating in the scanner app returns a StandardExchangeArticle in an XStream XML stream as a String object.
	 * If the ID is valid and the article contained in the database, the StandardExchangeArticle contains Information about that Article.
	 * If the ID is invalid or the article does not exist in the database, the StandardExchangeArticle contains Information to that effect.
	 * @param ID
	 * @return
	 * @throws NumberInvalidFormatException
	 */
	public static String getArticle(long ID) {
		String returnString = null;
		XStream serializer = new XStream();
		returnString = serializer.toXML(getStandardExchangeArticle(ID));
		return returnString;
	}
	
	public static String getArticle(String ID) {
		String returnString = null;
		XStream serializer = new XStream();
		returnString = serializer.toXML(getStandardExchangeArticle(ID));
		return returnString;
	}
	
	public static StandardExchangeArticle getStandardExchangeArticle(long ID){
		StandardExchangeArticle sea = new StandardExchangeArticle();
		sea.setID(ID);
		
		try {
			IEAN iean = new EAN13(ID);
			IArticle article = ArticleUtil.getArticle(iean);
			if (article == null) {
				sea.setName("No Article!");
				sea.setDescription("Article does not exist in database!");
			}
			// Packaging information into ExchangeArticle
			sea.setName(article.getName());
			sea.setDescription(article.getDescription());
			sea.setPictureURI(article.getImageURI());
			for (IFlag flag : article.getFlags()) {
				sea.addFlag(flag.getId(), flag.getName());
			}
		} catch (NumberInvalidFormatException NIFEx) {
			sea.setName("No Article!");
			sea.setDescription("File corruption! - Received EAN is invalid due to file corruption during transmission - please try again!");
		}
		catch (DatabaseConnectionException DCEx){
			//TODO: retry, then if no change: return error message
		}
		return sea;
	}
	
	public static StandardExchangeArticle getStandardExchangeArticle(String ID){
		try{
			long lid = Long.parseLong(ID);
			return getStandardExchangeArticle(lid);
		}
		catch(Exception ex){
			StandardExchangeArticle sea = new StandardExchangeArticle();
			sea.setID(0);
			sea.setName("Invalid Format: ID");
			sea.setDescription("The given ID is invalid!");
			return sea;
		}
	}
	

}
