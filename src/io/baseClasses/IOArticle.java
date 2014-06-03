package io.baseClasses;

import database.ArticleUtil;
import datatype.EAN;
import datatype.IEAN;
import foodServer.Article;
import foodServer.exceptions.DatabaseConnectionException;
import foodServer.exceptions.NumberInvalidFormatException;

public class IOArticle {
	
	public static Article getArticle(String id) throws NumberFormatException, DatabaseConnectionException, NumberInvalidFormatException{
		return ArticleUtil.getArticle(id);
	}
	
	public static void setArtice(Article article){
		ArticleUtil.setArticle(article);
	}

}
