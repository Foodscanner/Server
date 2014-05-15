/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Hamburg University of Applied Sciences
 * License Type: Academic
 */
package foodserver;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class Article implements foodserver.IArticle {
	public Article() {
	}
	
	public static Article loadArticleByORMID(IEAN _id) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return loadArticleByORMID(session, _id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Article getArticleByORMID(IEAN _id) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return getArticleByORMID(session, _id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Article loadArticleByORMID(IEAN _id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return loadArticleByORMID(session, _id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Article getArticleByORMID(IEAN _id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return getArticleByORMID(session, _id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Article loadArticleByORMID(PersistentSession session, IEAN _id) throws PersistentException {
		try {
			return (Article) session.load(foodserver.Article.class, _id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Article getArticleByORMID(PersistentSession session, IEAN _id) throws PersistentException {
		try {
			return (Article) session.get(foodserver.Article.class, _id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Article loadArticleByORMID(PersistentSession session, IEAN _id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Article) session.load(foodserver.Article.class, _id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Article getArticleByORMID(PersistentSession session, IEAN _id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Article) session.get(foodserver.Article.class, _id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryArticle(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return queryArticle(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryArticle(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return queryArticle(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Article[] listArticleByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return listArticleByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Article[] listArticleByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return listArticleByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryArticle(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From foodserver.Article as Article");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryArticle(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From foodserver.Article as Article");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Article", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Article[] listArticleByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryArticle(session, condition, orderBy);
			return (Article[]) list.toArray(new Article[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Article[] listArticleByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryArticle(session, condition, orderBy, lockMode);
			return (Article[]) list.toArray(new Article[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Article loadArticleByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return loadArticleByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Article loadArticleByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return loadArticleByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Article loadArticleByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Article[] articles = listArticleByQuery(session, condition, orderBy);
		if (articles != null && articles.length > 0)
			return articles[0];
		else
			return null;
	}
	
	public static Article loadArticleByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Article[] articles = listArticleByQuery(session, condition, orderBy, lockMode);
		if (articles != null && articles.length > 0)
			return articles[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateArticleByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return iterateArticleByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateArticleByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return iterateArticleByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateArticleByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From foodserver.Article as Article");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateArticleByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From foodserver.Article as Article");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Article", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Article loadArticleByCriteria(ArticleCriteria articleCriteria) {
		Article[] articles = listArticleByCriteria(articleCriteria);
		if(articles == null || articles.length == 0) {
			return null;
		}
		return articles[0];
	}
	
	public static Article[] listArticleByCriteria(ArticleCriteria articleCriteria) {
		return articleCriteria.listArticle();
	}
	
	public static Article createArticle() {
		return new foodserver.Article();
	}
	
	public boolean save() throws PersistentException {
		try {
			foodserver.JavaRoundTripPersistentManager.instance().saveObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete() throws PersistentException {
		try {
			foodserver.JavaRoundTripPersistentManager.instance().deleteObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean refresh() throws PersistentException {
		try {
			foodserver.JavaRoundTripPersistentManager.instance().getSession().refresh(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict() throws PersistentException {
		try {
			foodserver.JavaRoundTripPersistentManager.instance().getSession().evict(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	private IEAN _id;
	
	public foodserver.Flag _unnamed_Flag_;
	
	public foodserver.Ingredient _unnamed_Ingredient_;
	
	private String _name;
	
	private String _description;
	
	private String _imageURI;
	
	private foodserver.IIngredient _ingredients;
	
	private foodserver.IFlag _flags;
	
	public foodserver.ArticleUtil _unnamed_ArticleUtil_;
	
	private void set_id(IEAN value) {
		this._id = value;
	}
	
	public IEAN get_id() {
		return _id;
	}
	
	public IEAN getORMID() {
		return get_id();
	}
	
	public void set_name(String value) {
		this._name = value;
	}
	
	public String get_name() {
		return _name;
	}
	
	public void set_description(String value) {
		this._description = value;
	}
	
	public String get_description() {
		return _description;
	}
	
	public void set_imageURI(String value) {
		this._imageURI = value;
	}
	
	public String get_imageURI() {
		return _imageURI;
	}
	
	public void set_ingredients(foodserver.IIngredient value) {
		this._ingredients = value;
	}
	
	public foodserver.IIngredient get_ingredients() {
		return _ingredients;
	}
	
	public void set_flags(foodserver.IFlag value) {
		this._flags = value;
	}
	
	public foodserver.IFlag get_flags() {
		return _flags;
	}
	
	public void set_unnamed_ArticleUtil_(foodserver.ArticleUtil value) {
		this._unnamed_ArticleUtil_ = value;
	}
	
	public foodserver.ArticleUtil get_unnamed_ArticleUtil_() {
		return _unnamed_ArticleUtil_;
	}
	
	public void set_unnamed_Ingredient_(foodserver.Ingredient value) {
		this._unnamed_Ingredient_ = value;
	}
	
	public foodserver.Ingredient get_unnamed_Ingredient_() {
		return _unnamed_Ingredient_;
	}
	
	public void set_unnamed_Flag_(foodserver.Flag value) {
		this._unnamed_Flag_ = value;
	}
	
	public foodserver.Flag get_unnamed_Flag_() {
		return _unnamed_Flag_;
	}
	
	public Article(foodserver.datatypes.IEAN aId) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public foodserver.datatypes.IEAN getID() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setID(foodserver.datatypes.IEAN aId) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String getName() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setName(String aName) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String getDescription() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setDescription(String aDescription) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String getImageURI() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setImageURI(String aImageURI) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public java.util.List<IIngredient> getIngredients() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setIngredients(java.util.List<IIngredient> aIIngredient) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public foodserver.IArticle getProduct() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public java.util.List<IFlag> getFlags() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public java.util.List<IFlag> getProductFlags() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void removeFlag(foodserver.IFlag aFlag) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void persist() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void addIngredient(foodserver.IIngredient aIIngredient) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(get_id());
	}
	
}
