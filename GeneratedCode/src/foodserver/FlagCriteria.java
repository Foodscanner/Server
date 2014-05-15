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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class FlagCriteria extends AbstractORMCriteria {
	public final LongExpression _id;
	public final LongExpression _unnamed_Ingredient_Id;
	public final AssociationExpression _unnamed_Ingredient_;
	public final IntegerExpression _unnamed_Article_Id;
	public final AssociationExpression _unnamed_Article_;
	public final StringExpression _name;
	public final StringExpression _description;
	public final BooleanExpression _limitToProduct;
	
	public FlagCriteria(Criteria criteria) {
		super(criteria);
		_id = new LongExpression("_id", this);
		_unnamed_Ingredient_Id = new LongExpression("_unnamed_Ingredient_._id", this);
		_unnamed_Ingredient_ = new AssociationExpression("_unnamed_Ingredient_", this);
		_unnamed_Article_Id = new IntegerExpression("_unnamed_Article_._id", this);
		_unnamed_Article_ = new AssociationExpression("_unnamed_Article_", this);
		_name = new StringExpression("_name", this);
		_description = new StringExpression("_description", this);
		_limitToProduct = new BooleanExpression("_limitToProduct", this);
	}
	
	public FlagCriteria(PersistentSession session) {
		this(session.createCriteria(Flag.class));
	}
	
	public FlagCriteria() throws PersistentException {
		this(foodserver.JavaRoundTripPersistentManager.instance().getSession());
	}
	
	public IngredientCriteria create_unnamed_Ingredient_Criteria() {
		return new IngredientCriteria(createCriteria("_unnamed_Ingredient_"));
	}
	
	public ArticleCriteria create_unnamed_Article_Criteria() {
		return new ArticleCriteria(createCriteria("_unnamed_Article_"));
	}
	
	public Flag uniqueFlag() {
		return (Flag) super.uniqueResult();
	}
	
	public Flag[] listFlag() {
		java.util.List list = super.list();
		return (Flag[]) list.toArray(new Flag[list.size()]);
	}
}

