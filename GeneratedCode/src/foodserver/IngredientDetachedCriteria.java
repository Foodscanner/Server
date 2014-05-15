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

public class IngredientDetachedCriteria extends AbstractORMDetachedCriteria {
	public final LongExpression _id;
	public final StringExpression _name;
	
	public IngredientDetachedCriteria() {
		super(foodserver.Ingredient.class, foodserver.IngredientCriteria.class);
		_id = new LongExpression("_id", this.getDetachedCriteria());
		_name = new StringExpression("_name", this.getDetachedCriteria());
	}
	
	public IngredientDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, foodserver.IngredientCriteria.class);
		_id = new LongExpression("_id", this.getDetachedCriteria());
		_name = new StringExpression("_name", this.getDetachedCriteria());
	}
	
	public Ingredient uniqueIngredient(PersistentSession session) {
		return (Ingredient) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ingredient[] listIngredient(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ingredient[]) list.toArray(new Ingredient[list.size()]);
	}
}

