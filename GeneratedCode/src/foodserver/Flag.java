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

public class Flag implements foodserver.IFlag {
	public Flag() {
	}
	
	public static Flag loadFlagByORMID(long _id) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return loadFlagByORMID(session, _id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Flag getFlagByORMID(long _id) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return getFlagByORMID(session, _id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Flag loadFlagByORMID(long _id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return loadFlagByORMID(session, _id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Flag getFlagByORMID(long _id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return getFlagByORMID(session, _id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Flag loadFlagByORMID(PersistentSession session, long _id) throws PersistentException {
		try {
			return (Flag) session.load(foodserver.Flag.class, new Long(_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Flag getFlagByORMID(PersistentSession session, long _id) throws PersistentException {
		try {
			return (Flag) session.get(foodserver.Flag.class, new Long(_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Flag loadFlagByORMID(PersistentSession session, long _id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Flag) session.load(foodserver.Flag.class, new Long(_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Flag getFlagByORMID(PersistentSession session, long _id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Flag) session.get(foodserver.Flag.class, new Long(_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFlag(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return queryFlag(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFlag(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return queryFlag(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Flag[] listFlagByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return listFlagByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Flag[] listFlagByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return listFlagByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFlag(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From foodserver.Flag as Flag");
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
	
	public static List queryFlag(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From foodserver.Flag as Flag");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Flag", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Flag[] listFlagByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryFlag(session, condition, orderBy);
			return (Flag[]) list.toArray(new Flag[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Flag[] listFlagByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryFlag(session, condition, orderBy, lockMode);
			return (Flag[]) list.toArray(new Flag[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Flag loadFlagByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return loadFlagByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Flag loadFlagByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return loadFlagByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Flag loadFlagByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Flag[] flags = listFlagByQuery(session, condition, orderBy);
		if (flags != null && flags.length > 0)
			return flags[0];
		else
			return null;
	}
	
	public static Flag loadFlagByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Flag[] flags = listFlagByQuery(session, condition, orderBy, lockMode);
		if (flags != null && flags.length > 0)
			return flags[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateFlagByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return iterateFlagByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFlagByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = foodserver.JavaRoundTripPersistentManager.instance().getSession();
			return iterateFlagByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFlagByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From foodserver.Flag as Flag");
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
	
	public static java.util.Iterator iterateFlagByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From foodserver.Flag as Flag");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Flag", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Flag loadFlagByCriteria(FlagCriteria flagCriteria) {
		Flag[] flags = listFlagByCriteria(flagCriteria);
		if(flags == null || flags.length == 0) {
			return null;
		}
		return flags[0];
	}
	
	public static Flag[] listFlagByCriteria(FlagCriteria flagCriteria) {
		return flagCriteria.listFlag();
	}
	
	public static Flag createFlag() {
		return new foodserver.Flag();
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
	
	public foodserver.Ingredient _unnamed_Ingredient_;
	
	public foodserver.Article _unnamed_Article_;
	
	private String _name;
	
	private String _description;
	
	private boolean _limitToProduct;
	
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
	
	public void set_description(String value) {
		this._description = value;
	}
	
	public String get_description() {
		return _description;
	}
	
	public void set_limitToProduct(boolean value) {
		this._limitToProduct = value;
	}
	
	public boolean get_limitToProduct() {
		return _limitToProduct;
	}
	
	public void set_unnamed_Article_(foodserver.Article value) {
		this._unnamed_Article_ = value;
	}
	
	public foodserver.Article get_unnamed_Article_() {
		return _unnamed_Article_;
	}
	
	public void set_unnamed_Ingredient_(foodserver.Ingredient value) {
		this._unnamed_Ingredient_ = value;
	}
	
	public foodserver.Ingredient get_unnamed_Ingredient_() {
		return _unnamed_Ingredient_;
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
	
	public String getDescription() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setDescription(String aDescription) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public boolean getLimitToProduct() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setLimitToProduct(boolean aLimitToProduct) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public foodserver.IFlag copy() {
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
