package foodServer;

import java.net.URI;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-24T15:23:13.994+0200")
@StaticMetamodel(Article.class)
public class Article_ {
	public static volatile SingularAttribute<Article, String> name;
	public static volatile SingularAttribute<Article, String> description;
	public static volatile SingularAttribute<Article, URI> imageURI;
	public static volatile SingularAttribute<Article, Long> IDasLong;
	public static volatile ListAttribute<Article, Ingredient> ingredients;
	public static volatile SingularAttribute<Article, String> imageURIAsString;
	public static volatile ListAttribute<Article, Flag> flags;
}
