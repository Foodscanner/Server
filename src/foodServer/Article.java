package foodServer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


import datatype.EAN;
import datatype.IEAN;
import foodServer.exceptions.NumberInvalidFormatException;

/**
 * An Article implementation
 * 
 * @author Christian Gl�ser, Felipe Oehrwald
 * 
 */
@Entity(name="ARTICLE")
@NamedQueries({
	//NamedQuery zur Auflistung aller Artikel
	@NamedQuery(name = Article.FIND_ARTICLES,
            query = "SELECT a " +
		            "FROM ARTICLE a"),
    @NamedQuery(name = Article.FIND_ARTICLE_BY_ARTICLEID,
			query = "SELECT a " +
					"FROM ARTICLE a " +
					"WHERE a.ID = :" + Article.PARAM_ARTICLEID),
	@NamedQuery(name = Article.FIND_FULL_ARTICLE_BY_ARTICLEID,
			query = "SELECT a " +
					"FROM ARTICLE a " +
					"LEFT JOIN FETCH a.flags " +
					"LEFT JOIN FETCH a.ingredients " + 
					"WHERE a.ID = :" + Article.PARAM_ARTICLEID)})
public class Article implements IArticle<EAN,Flag,Ingredient> {
	
	private EAN ean;

	private long id;

	private String name;

	private String description;

	private String imageURL;
	private List<Ingredient> ingredients;

	private List<Flag> flags;


	/** The Constant PARAM_ARTICLEID. */
	public static final String PARAM_ARTICLEID = "ID";
	public static final String PARAM_NAME = "Name";
	public static final String PARAM_IMAGEURL = "ImageURL";
	public static final String PARAM_FLAGS = "flags";
	
	public static final String FIND_ARTICLES = "findArticles";	
	public static final String FIND_ARTICLE_BY_ARTICLEID = "findArticleByArticleID";
	public static final String FIND_FULL_ARTICLE_BY_ARTICLEID = "findFullArticleByArticleID";
	
	
	public Article(){
		ean = new EAN();
		ingredients = new ArrayList<Ingredient>();
		flags = new ArrayList<Flag>();
	}
	/**
	 * Constructor of an article with parameter id
	 * 
	 * @param ean The ean to set
	 * @throws NumberInvalidFormatException
	 *             This exception is thrown if number is not a valid EAN. Use
	 *             EAN validation from datatypes/EAN to prevent exception
	 * 
	 */
	public Article(long ean) throws NumberInvalidFormatException {
		this();
		setID(ean);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Article [ean=" + ean + ", id=" + id + ", name=" + name
				+ ", description=" + description + ", imageURI=" + imageURL
				+ ", ingredients=" + ingredients + ", flags=" + flags + "]";
	}
	/**
	 * Gets the id of the Article as long
	 * 
	 * @see foodServer.IArticle#getID()
	 * 
	 */
	@Id
	@Column(name="ID")
	public long getID() {
		return this.id;
	}

	/**
	 * If aId is a valid id, it is set as new id
	 * 
	 * @see foodServer.IArticle#setID(long ean)
	 * @param ean The ean to set
	 * @throws NumberInvalidFormatException If number is not valid NumberInvalidFormatException is thrown
	 */
	public void setID(long ean) throws NumberInvalidFormatException {
		if(this.ean.isValid(ean)){
		this.id = ean;
		this.ean.setEan(ean);
		}
		else throw new NumberInvalidFormatException();
	}

	/**
	 * @see foodServer.IArticle#getName()
	 * @return The name of the article
	 */
	@Column(name="Name")
	public String getName() {
		return this.name;
	}

	/**
	 * @see foodServer.IArticle#setName(java.lang.String) Sets the name of the
	 *      article
	 */
	public void setName(String aName) {
		this.name = aName;
	}

	/**
	 * @see foodServer.IArticle#getDescription()
	 * @return A description
	 */
	@Column(name="Description")
	public String getDescription() {
		return this.description;
	}

	/**
	 * @see foodServer.IArticle#setDescription(java.lang.String) Sets the
	 *      description in the Article
	 */
	public void setDescription(String aDescription) {
		this.description = aDescription;
	}

	/**
	 * @see foodServer.IArticle#getImageURL() Gets the image URL
	 **/
	@Column(name="ImageURL")
	public String getImageURL() {
		// URI is immutable
		return this.imageURL;
	}

	/**
	 * @see foodServer.IArticle#setImageURL(String) Sets the URL of the
	 *      image
	 */
	public void setImageURL(String imageURL) {
		// TODO Logic check
		this.imageURL = imageURL;
	}

	/**
	 * @see foodServer.IArticle#getFlags() Returns a list of all flags
	 */
	public List<Flag> getAllFlags() {
		List<Flag> allFlags = new ArrayList<Flag>();
		allFlags.addAll(getFlags());
		for(Ingredient i:ingredients){
			allFlags.addAll(i.getFlags());
		}
		return allFlags;
	}

	/**
	 * @see foodServer.IArticle#addFlag(java.lang.Object) Adds a product
	 *      specific flag
	 */
	public void addFlag(Flag aFlag) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see foodServer.IArticle#removeFlag(java.lang.Object) Removes a product
	 *      specific flag. If flag doesn't exist, request is ignored
	 */
	public void removeFlag(Flag aFlag) {
		flags.remove(aFlag);
	}

	/**
	 * @see foodServer.IArticle#getFlags() Returns the product specific
	 *      flags. Logically, this is a subset of all flags
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="ARTICLE_FLAGS",
	joinColumns=@JoinColumn(name="FK_ArticleID",referencedColumnName="ID"),
	inverseJoinColumns=@JoinColumn(name="FK_FlagID",referencedColumnName="ID"))
	public List<Flag> getFlags() {
		return flags;
	}
	
	
	/**
	 * @param flags The flags to be set as flags in @see foodserver.Article
	 */
	public void setFlags(List<Flag> flags){
		this.flags = flags;
	}

	/**
	 * @see foodServer.IArticle#getIngredients() Returns a list of ingredients
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="ARTICLE_INGREDIENTS",
	joinColumns=@JoinColumn(name="FK_ArticleID",referencedColumnName="ID"),
	inverseJoinColumns=@JoinColumn(name="FK_IngredientID",referencedColumnName="ID"))
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	
	/**
	 * @param ingredients The ingredients to be set as ingredients in @see foodserver.Article
	 */
	public void setIngredients(List<Ingredient> ingredients){
		this.ingredients = ingredients;
	}

	/**
	 * @see foodServer.IArticle#addIngredient(java.lang.Object) Adds an
	 *      ingredient
	 */
	public void addIngredient(Ingredient ingredient) {
		ingredients.add(ingredient);
	}

	/**
	 * @see foodServer.IArticle#removeIngredient(java.lang.Object) Removes
	 *      an ingredient
	 */
	public void removeIngredient(Ingredient ingredient) {
		ingredients.remove(ingredient);
	}
}