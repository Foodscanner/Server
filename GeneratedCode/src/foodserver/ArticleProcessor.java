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

import org.orm.PersistentException;
public class ArticleProcessor {
	private IEAN _id;
	
	private String _name;
	
	private String _description;
	
	private String _imageURI;
	
	private foodserver.IIngredient _ingredients;
	
	private foodserver.IFlag _flags;
	
	private foodserver.ArticleUtil _unnamed_ArticleUtil_;
	
	private String action="";
	
	public void set_id(IEAN value) {
		this._id = value;
	}
	
	public IEAN get_id() {
		return _id;
	}
	
	public void set_name(String value) {
		this._name = value;
	}
	
	public String get_name() {
		return _name == null ? "" : _name;
	}
	
	public void set_description(String value) {
		this._description = value;
	}
	
	public String get_description() {
		return _description == null ? "" : _description;
	}
	
	public void set_imageURI(String value) {
		this._imageURI = value;
	}
	
	public String get_imageURI() {
		return _imageURI == null ? "" : _imageURI;
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
	
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	private long _unnamed_Ingredient__ingredient_id;
	
	public void set_unnamed_Ingredient__ingredient_id(long value) {
		this._unnamed_Ingredient__ingredient_id = value;
	}
	
	public long get_unnamed_Ingredient__ingredient_id() {
		return _unnamed_Ingredient__ingredient_id;
	}
	
	private long _unnamed_Flag__flag_id;
	
	public void set_unnamed_Flag__flag_id(long value) {
		this._unnamed_Flag__flag_id = value;
	}
	
	public long get_unnamed_Flag__flag_id() {
		return _unnamed_Flag__flag_id;
	}
	
	public String process() {
		String result = "Unexcepted result";
		if (action.equals("search")) {
			try {
				foodserver.Article _article = foodserver.Article.loadArticleByORMID(get_id());
				if (_article!= null) {
					copyFromBean(_article);
					result = "Search success";
				}
				else {
					result = "Search failed";
				}
			}
			catch (PersistentException e) {
				result = "Search error: " + e.toString();
			}
		}
		else if(action.equals("insert"))  {
			try {
				foodserver.Article _article = foodserver.Article.createArticle();
				copyToBean(_article);
				if (_article.save()) {
					result = "Insert success";
				}
				else {
					result = "Insert failed";
				}
			}
			catch (Exception e) {
				result = "Insert error: " + e.toString();
			}
		}
		else if (action.equals("update")) {
			try {
				foodserver.Article _article= foodserver.Article.loadArticleByORMID(get_id());
				if (_article != null) {
					copyToBean(_article);
					if (_article.save()) {
						result = "Update success";
					}
					 else {
						result = "Update failed";
					}
				}
				 else  {
					result = "Update failed";
				}
				
			}
			catch (PersistentException e) {
				result = "Update error: " + e.toString();
			}
		}
		else if (action.equals("delete")) {
			try {
				foodserver.Article _article = foodserver.Article.loadArticleByORMID(get_id());
				if (_article != null && _article.delete()) {
					result = "Delete success";
				}
				else {
					result = "Delete failed";
				}
			}
			catch (PersistentException e)  {
				result = "Delete error: " + e.toString();
			}
		}
		else if (action.equals("")) {
			result = "";
		}
		action = "";
		return result;
	}
	
	private void copyFromBean(foodserver.Article _article) {
		set_name(_article.get_name());
		set_description(_article.get_description());
		set_imageURI(_article.get_imageURI());
		set_ingredients(_article.get_ingredients());
		set_flags(_article.get_flags());
		set_unnamed_ArticleUtil_(_article.get_unnamed_ArticleUtil_());
		set_id(_article.get_id());
		
		{
			foodserver.Ingredient _ingredient = _article.get_unnamed_Ingredient_();
			if (_ingredient != null) {
				set_unnamed_Ingredient__ingredient_id(_ingredient.get_id());
			}
		}
		
		
		{
			foodserver.Flag _flag = _article.get_unnamed_Flag_();
			if (_flag != null) {
				set_unnamed_Flag__flag_id(_flag.get_id());
			}
		}
		
	}
	
	private void copyToBean(foodserver.Article _article) {
		_article.set_name(get_name());
		_article.set_description(get_description());
		_article.set_imageURI(get_imageURI());
		_article.set_ingredients(get_ingredients());
		_article.set_flags(get_flags());
		_article.set_unnamed_ArticleUtil_(get_unnamed_ArticleUtil_());
		try  {
			foodserver.Ingredient __unnamed_Ingredient_ = foodserver.Ingredient.loadIngredientByORMID(get_unnamed_Ingredient__ingredient_id());
			_article.set_unnamed_Ingredient_(__unnamed_Ingredient_);
		}
		catch (PersistentException e) {
		}
		
		try  {
			foodserver.Flag __unnamed_Flag_ = foodserver.Flag.loadFlagByORMID(get_unnamed_Flag__flag_id());
			_article.set_unnamed_Flag_(__unnamed_Flag_);
		}
		catch (PersistentException e) {
		}
		
	}
	
}

