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

public class ArticleDetachedCriteria extends AbstractORMDetachedCriteria {
	public final LongExpression _unnamed_Flag_Id;
	public final AssociationExpression _unnamed_Flag_;
	public final LongExpression _unnamed_Ingredient_Id;
	public final AssociationExpression _unnamed_Ingredient_;
	public final StringExpression _name;
	public final StringExpression _description;
	public final StringExpression _imageURI;
	
	public ArticleDetachedCriteria() {
		super(foodserver.Article.class, foodserver.ArticleCriteria.class);
		_unnamed_Flag_Id = new LongExpression("_unnamed_Flag_._id", this.getDetachedCriteria());
		_unnamed_Flag_ = new AssociationExpression("_unnamed_Flag_", this.getDetachedCriteria());
		_unnamed_Ingredient_Id = new LongExpression("_unnamed_Ingredient_._id", this.getDetachedCriteria());
		_unnamed_Ingredient_ = new AssociationExpression("_unnamed_Ingredient_", this.getDetachedCriteria());
		_name = new StringExpression("_name", this.getDetachedCriteria());
		_description = new StringExpression("_description", this.getDetachedCriteria());
		_imageURI = new StringExpression("_imageURI", this.getDetachedCriteria());
	}
	
	public ArticleDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, foodserver.ArticleCriteria.class);
		_unnamed_Flag_Id = new LongExpression("_unnamed_Flag_._id", this.getDetachedCriteria());
		_unnamed_Flag_ = new AssociationExpression("_unnamed_Flag_", this.getDetachedCriteria());
		_unnamed_Ingredient_Id = new LongExpression("_unnamed_Ingredient_._id", this.getDetachedCriteria());
		_unnamed_Ingredient_ = new AssociationExpression("_unnamed_Ingredient_", this.getDetachedCriteria());
		_name = new StringExpression("_name", this.getDetachedCriteria());
		_description = new StringExpression("_description", this.getDetachedCriteria());
		_imageURI = new StringExpression("_imageURI", this.getDetachedCriteria());
	}
	
	public FlagDetachedCriteria create_unnamed_Flag_Criteria() {
		return new FlagDetachedCriteria(createCriteria("_unnamed_Flag_"));
	}
	
	public IngredientDetachedCriteria create_unnamed_Ingredient_Criteria() {
		return new IngredientDetachedCriteria(createCriteria("_unnamed_Ingredient_"));
	}
	
	public Article uniqueArticle(PersistentSession session) {
		return (Article) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Article[] listArticle(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Article[]) list.toArray(new Article[list.size()]);
	}
}

