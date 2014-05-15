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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class FlagDetachedCriteria extends AbstractORMDetachedCriteria {
	public final LongExpression _id;
	public final LongExpression _unnamed_Ingredient_Id;
	public final AssociationExpression _unnamed_Ingredient_;
	public final IntegerExpression _unnamed_Article_Id;
	public final AssociationExpression _unnamed_Article_;
	public final StringExpression _name;
	public final StringExpression _description;
	public final BooleanExpression _limitToProduct;
	
	public FlagDetachedCriteria() {
		super(foodserver.Flag.class, foodserver.FlagCriteria.class);
		_id = new LongExpression("_id", this.getDetachedCriteria());
		_unnamed_Ingredient_Id = new LongExpression("_unnamed_Ingredient_._id", this.getDetachedCriteria());
		_unnamed_Ingredient_ = new AssociationExpression("_unnamed_Ingredient_", this.getDetachedCriteria());
		_unnamed_Article_Id = new IntegerExpression("_unnamed_Article_._id", this.getDetachedCriteria());
		_unnamed_Article_ = new AssociationExpression("_unnamed_Article_", this.getDetachedCriteria());
		_name = new StringExpression("_name", this.getDetachedCriteria());
		_description = new StringExpression("_description", this.getDetachedCriteria());
		_limitToProduct = new BooleanExpression("_limitToProduct", this.getDetachedCriteria());
	}
	
	public FlagDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, foodserver.FlagCriteria.class);
		_id = new LongExpression("_id", this.getDetachedCriteria());
		_unnamed_Ingredient_Id = new LongExpression("_unnamed_Ingredient_._id", this.getDetachedCriteria());
		_unnamed_Ingredient_ = new AssociationExpression("_unnamed_Ingredient_", this.getDetachedCriteria());
		_unnamed_Article_Id = new IntegerExpression("_unnamed_Article_._id", this.getDetachedCriteria());
		_unnamed_Article_ = new AssociationExpression("_unnamed_Article_", this.getDetachedCriteria());
		_name = new StringExpression("_name", this.getDetachedCriteria());
		_description = new StringExpression("_description", this.getDetachedCriteria());
		_limitToProduct = new BooleanExpression("_limitToProduct", this.getDetachedCriteria());
	}
	
	public IngredientDetachedCriteria create_unnamed_Ingredient_Criteria() {
		return new IngredientDetachedCriteria(createCriteria("_unnamed_Ingredient_"));
	}
	
	public ArticleDetachedCriteria create_unnamed_Article_Criteria() {
		return new ArticleDetachedCriteria(createCriteria("_unnamed_Article_"));
	}
	
	public Flag uniqueFlag(PersistentSession session) {
		return (Flag) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Flag[] listFlag(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Flag[]) list.toArray(new Flag[list.size()]);
	}
}

