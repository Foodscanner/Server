package io;

import java.util.HashMap;

import com.thoughtworks.xstream.XStream;

import datatype.EAN13;
import datatype.IEAN;
import datatype.StandardExchangeArticle;
import foodServer.ArticleUtil;
import foodServer.IArticle;
import foodServer.IFlag;
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
		StandardExchangeArticle sea = new StandardExchangeArticle();
		sea.ID = ID;
		String returnString = null;

		try {
			IEAN iean = new EAN13(ID);
			IArticle article = ArticleUtil.getArticle(iean);
			if (article == null) {
				sea.name = "No such article!";
				sea.description = "Article does not exist in database!";
			}
			// Packaging information into ExchangeArticle
			sea.name = article.getName();
			sea.description = article.getDescription();
			sea.pictureURI = article.getImageURI();
			sea.flags = new HashMap<Integer, String>();
			for (IFlag flag : article.getFlags()) {
				sea.flags.put(flag.getId(), flag.getName());
			}
		} catch (NumberInvalidFormatException ex) {
			sea.name = "File corruption!";
			sea.description = "Received EAN is invalid due to file corruption during transmission - please try again!";
		}

		XStream serializer = new XStream();
		returnString = serializer.toXML(sea);
		return returnString;
	}
	
	public static StandardExchangeArticle deserializeStandardArticle(String xml){
		XStream deserializer = new XStream();
		StandardExchangeArticle sea = (StandardExchangeArticle)deserializer.fromXML(xml);
		return sea;
	}
}
