package foodServer;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-24T15:54:33.048+0200")
@StaticMetamodel(Ingredient.class)
public class Ingredient_ {
	public static volatile SingularAttribute<Ingredient, Integer> id;
	public static volatile SingularAttribute<Ingredient, String> name;
	public static volatile ListAttribute<Ingredient, Flag> flags;
	public static volatile ListAttribute<Ingredient, Article> articles;
}
