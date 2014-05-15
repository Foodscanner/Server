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

public class Ingredient implements foodserver.IIngredient {
	public Ingredient() {
	}
	
	public static Ingredient loadIngredientByORMID(long _id) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return loadIngredientByORMID(session, _id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ingredient getIngredientByORMID(long _id) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return getIngredientByORMID(session, _id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ingredient loadIngredientByORMID(long _id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return loadIngredientByORMID(session, _id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ingredient getIngredientByORMID(long _id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return getIngredientByORMID(session, _id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ingredient loadIngredientByORMID(PersistentSession session, long _id) throws PersistentException {
		try {
			return (Ingredient) session.load(foodserver.Ingredient.class, new Long(_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ingredient getIngredientByORMID(PersistentSession session, long _id) throws PersistentException {
		try {
			return (Ingredient) session.get(foodserver.Ingredient.class, new Long(_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ingredient loadIngredientByORMID(PersistentSession session, long _id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ingredient) session.load(foodserver.Ingredient.class, new Long(_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ingredient getIngredientByORMID(PersistentSession session, long _id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Ingredient) session.get(foodserver.Ingredient.class, new Long(_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryIngredient(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return queryIngredient(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryIngredient(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return queryIngredient(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ingredient[] listIngredientByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return listIngredientByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ingredient[] listIngredientByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return listIngredientByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryIngredient(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From foodserver.Ingredient as Ingredient");
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
	
	public static List queryIngredient(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From foodserver.Ingredient as Ingredient");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ingredient", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ingredient[] listIngredientByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryIngredient(session, condition, orderBy);
			return (Ingredient[]) list.toArray(new Ingredient[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ingredient[] listIngredientByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryIngredient(session, condition, orderBy, lockMode);
			return (Ingredient[]) list.toArray(new Ingredient[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ingredient loadIngredientByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return loadIngredientByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ingredient loadIngredientByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return loadIngredientByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ingredient loadIngredientByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ingredient[] ingredients = listIngredientByQuery(session, condition, orderBy);
		if (ingredients != null && ingredients.length > 0)
			return ingredients[0];
		else
			return null;
	}
	
	public static Ingredient loadIngredientByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Ingredient[] ingredients = listIngredientByQuery(session, condition, orderBy, lockMode);
		if (ingredients != null && ingredients.length > 0)
			return ingredients[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateIngredientByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return iterateIngredientByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateIngredientByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return iterateIngredientByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateIngredientByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From foodserver.Ingredient as Ingredient");
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
	
	public static java.util.Iterator iterateIngredientByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From foodserver.Ingredient as Ingredient");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ingredient", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ingredient loadIngredientByCriteria(IngredientCriteria ingredientCriteria) {
		Ingredient[] ingredients = listIngredientByCriteria(ingredientCriteria);
		if(ingredients == null || ingredients.length == 0) {
			return null;
		}
		return ingredients[0];
	}
	
	public static Ingredient[] listIngredientByCriteria(IngredientCriteria ingredientCriteria) {
		return ingredientCriteria.listIngredient();
	}
	
	public static Ingredient createIngredient() {
		return new foodserver.Ingredient();
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
	
	private long _id;
	
	private String _name;
	
	private foodserver.IFlag _flags;
	
	private void set_id(long value) {
		this._id = value;
	}
	
	public long get_id() {
		return _id;
	}
	
	public long getORMID() {
		return get_id();
	}
	
	public void set_name(String value) {
		this._name = value;
	}
	
	public String get_name() {
		return _name;
	}
	
	public void set_flags(foodserver.IFlag value) {
		this._flags = value;
	}
	
	public foodserver.IFlag get_flags() {
		return _flags;
	}
	
	public long getId() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setId(long aId) {
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
	
	public void addFlag(foodserver.IFlag flag) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void removeFlag(foodserver.IFlag flag) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public java.util.List<IFlag> getFlags() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public foodserver.IIngredient copy() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void persist() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(get_id());
	}
	
}
