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
public class IngredientProcessor {
	private long _id;
	
	private String _name;
	
	private foodserver.IFlag _flags;
	
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
	
	public void set_flags(foodserver.IFlag value) {
		this._flags = value;
	}
	
	public foodserver.IFlag get_flags() {
		return _flags;
	}
	
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	public String process() {
		String result = "Unexcepted result";
		if (action.equals("search")) {
			try {
				foodserver.Ingredient _ingredient = foodserver.Ingredient.loadIngredientByORMID(get_id());
				if (_ingredient!= null) {
					copyFromBean(_ingredient);
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
				foodserver.Ingredient _ingredient = foodserver.Ingredient.createIngredient();
				copyToBean(_ingredient);
				if (_ingredient.save()) {
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
				foodserver.Ingredient _ingredient= foodserver.Ingredient.loadIngredientByORMID(get_id());
				if (_ingredient != null) {
					copyToBean(_ingredient);
					if (_ingredient.save()) {
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
				foodserver.Ingredient _ingredient = foodserver.Ingredient.loadIngredientByORMID(get_id());
				if (_ingredient != null && _ingredient.delete()) {
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
	
	private void copyFromBean(foodserver.Ingredient _ingredient) {
		set_name(_ingredient.get_name());
		set_flags(_ingredient.get_flags());
		set_id(_ingredient.get_id());
	}
	
	private void copyToBean(foodserver.Ingredient _ingredient) {
		_ingredient.set_name(get_name());
		_ingredient.set_flags(get_flags());
	}
	
}

