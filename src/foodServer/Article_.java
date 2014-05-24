package foodServer;

import java.net.URI;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-24T17:57:22.552+0200")
@StaticMetamodel(Article.class)
public class Article_ {
	public static volatile SingularAttribute<Article, String> name;
	public static volatile SingularAttribute<Article, String> description;
	public static volatile SingularAttribute<Article, String> imageURIAsString;
	public static volatile ListAttribute<Article, Flag> flags;
	public static volatile ListAttribute<Article, Ingredient> ingredients;
	public static volatile SingularAttribute<Article, URI> imageURI;
	public static volatile SingularAttribute<Article, Long> ID;
}
