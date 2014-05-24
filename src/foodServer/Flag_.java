package foodServer;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-24T15:01:44.383+0200")
@StaticMetamodel(Flag.class)
public class Flag_ {
	public static volatile SingularAttribute<Flag, Integer> id;
	public static volatile SingularAttribute<Flag, String> name;
	public static volatile SingularAttribute<Flag, String> description;
	public static volatile SingularAttribute<Flag, Boolean> limitToProduct;
	public static volatile ListAttribute<Flag, Article> articles;
	public static volatile ListAttribute<Flag, Ingredient> ingredients;
}
