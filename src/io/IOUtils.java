package io;

import java.net.URI;
import java.net.URISyntaxException;

import com.thoughtworks.xstream.XStream;

import datatype.EAN;
import datatype.IEAN;
import datatype.StandardExchangeArticle;
import foodServer.Article;
import database.ArticleUtil;
import database.exceptions.NoFlagsExistException;
import foodServer.Flag;
import foodServer.IArticle;
import foodServer.IFlag;
import foodServer.Ingredient;
import foodServer.exceptions.DatabaseConnectionException;
import foodServer.exceptions.NumberInvalidFormatException;

public class IOUtils {
	private IOUtils() {
	}

	/**
	 * Upon getting a long ID originating in the scanner app returns a StandardExchangeArticle in an XStream XML stream as a String object.
	 * If the ID is valid and the article contained in the database, the StandardExchangeArticle contains Information about that Article.
	 * If the ID is invalid or the article does not exist in the database, the StandardExchangeArticle contains Information to that effect.
	 * @param ID The id of the article to be serialized
	 * @return A serialized article
	 */
	public static String getArticle(long ID) {
		String returnString = null;
		XStream serializer = new XStream();
		returnString = serializer.toXML(getStandardExchangeArticle(ID));
		return returnString;
	}
	
	/**
	 * @param ID The id of the article to be serialized
	 * @return A serialized article
	 */
	public static String getArticle(String ID) {
		String returnString = null;
		XStream serializer = new XStream();
		returnString = serializer.toXML(getStandardExchangeArticle(ID));
		return returnString;
	}
	
	/*
	public static String getValidXMLArticle(String ID) {
		String returnString = null;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		Writer writer;
		try {
			 writer = new OutputStreamWriter(outputStream, "UTF-8");
			 writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
			 XStream serializer = new XStream(new DomDriver("UTF-8"));
			 writer.write(serializer.toXML(getStandardExchangeArticle(ID)));
			 writer.flush();
			 returnString = outputStream.toString();
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return returnString;
	}*/
	
	/**
	 * @param ID The id of the article
	 * @return A simple article which can be serialized
	 */
	public static StandardExchangeArticle getStandardExchangeArticle(long ID){
		StandardExchangeArticle sea = new StandardExchangeArticle();
		sea.setID(ID);
		
		try {
			IEAN iean = new EAN(ID);
			Article article = ArticleUtil.getArticle(iean);
			if (article == null) {
				sea.setName("No Article!");
				sea.setDescription("Article does not exist in database!");
					sea.setPictureURL("https://openclipart.org/image/300px/svg_to_png/17139/barthm8s_Heiko-Barth_FAQ_128x128.png");
			}
			// Packaging information into ExchangeArticle
			sea.setName(article.getName());
			sea.setDescription(article.getDescription());
			sea.setPictureURL(article.getImageURL());
			for (Flag flag : article.getAllFlags()) {
				sea.addFlag(flag.getId(), flag.getName());
			}
			for(Ingredient ingredient:article.getIngredients()){
				sea.addIngredient(ingredient.getId(), ingredient.getName());
			}
		} catch (NumberInvalidFormatException NIFEx) {
			System.err.println(NIFEx);
			sea.setName("No Article!");
			sea.setDescription("File corruption! - Received EAN is invalid due to file corruption during transmission - please try again! \n Error message: "+NIFEx.getMessage());
		}
		catch (DatabaseConnectionException DCEx){
			System.err.println(DCEx);
			sea.setName("Database connection error!");
			sea.setDescription("Failed to connect to database! \n Error message: "+DCEx.getMessage());
		}
		return sea;
	}
	
	public static StandardExchangeArticle getStandardExchangeArticle(String ID){
		try{
			System.out.println("Trying to parse String " + ID + " to long");
			long lid = Long.parseLong(ID);
			System.out.println("Parsed long: " + lid);
			return getStandardExchangeArticle(lid);
		}
		catch(Exception ex){
			StandardExchangeArticle sea = new StandardExchangeArticle();
			System.err.println("Exception ex occured in IOUtils while trying to getStandardExchangeArticle("+ID+"): \nl" + ex);
			sea.setID(0);
			sea.setName("Exception!");
			sea.setDescription("Something went wrong! Stacktrace" + ex);
			return sea;
		}
	}

	/**
	 * @return A list of Flags
	 */
	public static String getFlags() {
		String returnString = null;
		StandardExchangeArticle sea = new StandardExchangeArticle();
		sea.setID(0);
		sea.setName("flag list");
		sea.setPictureURL("https://openclipart.org/image/2400px/svg_to_png/3152/nicubunu_Game_marbles_-_flags.png");
		XStream serializer = new XStream();
		try {
			for(Flag flag : database.FlagUtil.getAllFlags())
			{
				sea.addFlag(flag.getId(), flag.getName());
			}
			sea.setDescription("This is a list of all currently supported flags");
		} catch (NoFlagsExistException e) {
			sea.setDescription("Error: No flags exist!");
		} catch (DatabaseConnectionException e) {
			sea.setDescription("Error: Database unreachable!");
		}
		returnString = serializer.toXML(sea);
		return returnString;
	}

}
