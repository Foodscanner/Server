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

public class ArticleCriteria extends AbstractORMCriteria {
	public final LongExpression _unnamed_Flag_Id;
	public final AssociationExpression _unnamed_Flag_;
	public final LongExpression _unnamed_Ingredient_Id;
	public final AssociationExpression _unnamed_Ingredient_;
	public final StringExpression _name;
	public final StringExpression _description;
	public final StringExpression _imageURI;
	
	public ArticleCriteria(Criteria criteria) {
		super(criteria);
		_unnamed_Flag_Id = new LongExpression("_unnamed_Flag_._id", this);
		_unnamed_Flag_ = new AssociationExpression("_unnamed_Flag_", this);
		_unnamed_Ingredient_Id = new LongExpression("_unnamed_Ingredient_._id", this);
		_unnamed_Ingredient_ = new AssociationExpression("_unnamed_Ingredient_", this);
		_name = new StringExpression("_name", this);
		_description = new StringExpression("_description", this);
		_imageURI = new StringExpression("_imageURI", this);
	}
	
	public ArticleCriteria(PersistentSession session) {
		this(session.createCriteria(Article.class));
	}
	
	public ArticleCriteria() throws PersistentException {
		this(foodserver.JavaRoundTripPersistentManager.instance().getSession());
	}
	
	public FlagCriteria create_unnamed_Flag_Criteria() {
		return new FlagCriteria(createCriteria("_unnamed_Flag_"));
	}
	
	public IngredientCriteria create_unnamed_Ingredient_Criteria() {
		return new IngredientCriteria(createCriteria("_unnamed_Ingredient_"));
	}
	
	public Article uniqueArticle() {
		return (Article) super.uniqueResult();
	}
	
	public Article[] listArticle() {
		java.util.List list = super.list();
		return (Article[]) list.toArray(new Article[list.size()]);
	}
}

