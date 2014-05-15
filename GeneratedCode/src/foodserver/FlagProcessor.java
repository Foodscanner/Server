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
public class FlagProcessor {
	private long _id;
	
	private String _name;
	
	private String _description;
	
	private boolean _limitToProduct;
	
	private String action="";
	
	public void set_id(long value) {
		this._id = value;
	}
	
	public long get_id() {
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
	
	public void set_limitToProduct(boolean value) {
		this._limitToProduct = value;
	}
	
	public boolean get_limitToProduct() {
		return _limitToProduct;
	}
	
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	private IEAN _unnamed_Article__article_id;
	
	public void set_unnamed_Article__article_id(IEAN value) {
		this._unnamed_Article__article_id = value;
	}
	
	public IEAN get_unnamed_Article__article_id() {
		return _unnamed_Article__article_id;
	}
	
	private long _unnamed_Ingredient__ingredient_id;
	
	public void set_unnamed_Ingredient__ingredient_id(long value) {
		this._unnamed_Ingredient__ingredient_id = value;
	}
	
	public long get_unnamed_Ingredient__ingredient_id() {
		return _unnamed_Ingredient__ingredient_id;
	}
	
	public String process() {
		String result = "Unexcepted result";
		if (action.equals("search")) {
			try {
				foodserver.Flag _flag = foodserver.Flag.loadFlagByORMID(get_id());
				if (_flag!= null) {
					copyFromBean(_flag);
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
				foodserver.Flag _flag = foodserver.Flag.createFlag();
				copyToBean(_flag);
				if (_flag.save()) {
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
				foodserver.Flag _flag= foodserver.Flag.loadFlagByORMID(get_id());
				if (_flag != null) {
					copyToBean(_flag);
					if (_flag.save()) {
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
				foodserver.Flag _flag = foodserver.Flag.loadFlagByORMID(get_id());
				if (_flag != null && _flag.delete()) {
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
	
	private void copyFromBean(foodserver.Flag _flag) {
		set_name(_flag.get_name());
		set_description(_flag.get_description());
		set_limitToProduct(_flag.get_limitToProduct());
		set_id(_flag.get_id());
		
		{
			foodserver.Article _article = _flag.get_unnamed_Article_();
			if (_article != null) {
				set_unnamed_Article__article_id(_article.get_id());
			}
		}
		
		
		{
			foodserver.Ingredient _ingredient = _flag.get_unnamed_Ingredient_();
			if (_ingredient != null) {
				set_unnamed_Ingredient__ingredient_id(_ingredient.get_id());
			}
		}
		
	}
	
	private void copyToBean(foodserver.Flag _flag) {
		_flag.set_name(get_name());
		_flag.set_description(get_description());
		_flag.set_limitToProduct(get_limitToProduct());
		try  {
			foodserver.Article __unnamed_Article_ = foodserver.Article.loadArticleByORMID(get_unnamed_Article__article_id());
			_flag.set_unnamed_Article_(__unnamed_Article_);
		}
		catch (PersistentException e) {
		}
		
		try  {
			foodserver.Ingredient __unnamed_Ingredient_ = foodserver.Ingredient.loadIngredientByORMID(get_unnamed_Ingredient__ingredient_id());
			_flag.set_unnamed_Ingredient_(__unnamed_Ingredient_);
		}
		catch (PersistentException e) {
		}
		
	}
	
}

