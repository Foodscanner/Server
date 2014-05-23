package foodServer;

import java.net.URI;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Generated;

import datatype.IEAN;
import foodServer.exceptions.NumberInvalidFormatException;

/**
 * An Article implementation
 * 
 * @author Christian Gl�ser, Felipe Oehrwald
 * 
 */
public class Article implements IArticle {

	private IEAN id;
	private long lid;

	private String name;

	private String description;

	private URI imageURI;
	private List<IIngredient> ingredients;

	private List<IFlag> flags;

	/**
	 * Constructor of an article with parameter id
	 * 
	 * @param ean
	 *            The ean to set
	 * @throws NumberInvalidFormatException
	 *             This exception is thrown if number is not a valid EAN. Use
	 *             EAN validation from datatypes/EAN13 to prevent exception
	 * 
	 */
	
	
	public Article(IEAN ean) throws NumberInvalidFormatException {
		id = ean;
		lid = ean.getEAN();
	}

	/**
	 * Gets the id of the Article as long
	 * 
	 * @see foodServer.IArticle#getID()
	 * 
	 */
	public IEAN getID() {
		return this.id;
	}
	
	/**
	 * @return the value of the id as long
	 */
	@Id
	@Column(name = "ID", nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getIDasLong(){
		return this.getID().getEAN();
	}

	/**
	 * If aId is a valid id, it is set as new id
	 * 
	 * @see foodServer.IArticle#setID(IEAN ean)
	 * @param ean
	 *            The ean to set
	 */
	public void setID(IEAN ean) {
		this.id = ean;
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
	 * @see foodServer.IArticle#getImageURI() Gets the image URI
	 **/
	public URI getImageURI() {
		// URI is immutable
		return this.imageURI;
	}

	@Column(name="URI")
	public String getImageURIAsString(){
		return this.getImageURI().toString();
	}
	/**
	 * @see foodServer.IArticle#setImageURI(java.net.URI) Sets the URI of the
	 *      image
	 */
	public void setImageURI(URI aImageURI) {
		// TODO Logic check
		this.imageURI = aImageURI;
	}

	/*
	 * setIngredients(List<IIngredient> aIIngredient) { throw new
	 * UnsupportedOperationException(); }
	 */

	/**
	 * @see foodServer.IArticle#getFlags() Returns a list of all flags
	 */
	@ManyToMany
	@JoinTable(name="Article_Flags",
	joinColumns=@JoinColumn(name="FK_ArticleID",referencedColumnName="ID"),
	inverseJoinColumns=@JoinColumn(name="FK_FlagID",referencedColumnName="ID"))
	public List<IFlag> getFlags() {
		throw new UnsupportedOperationException();
	}

	/**
	 * @see foodServer.IArticle#addFlag(foodServer.IFlag) Adds a product
	 *      specific flag
	 */
	public void addFlag(IFlag aFlag) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see foodServer.IArticle#removeFlag(foodServer.IFlag) Removes a product
	 *      specific flag. If flag doesn't exist, request is ignored
	 */
	public void removeFlag(IFlag aFlag) {
		flags.remove(aFlag);
	}

	/**
	 * @see foodServer.IArticle#getProductFlags() Returns the product specific
	 *      flags. Logically, this is a subset of all flags
	 */
	public List<IFlag> getProductFlags() {
		throw new UnsupportedOperationException();
	}

	/**
	 * @see foodServer.IArticle#getIngredients() Returns a list of ingredients
	 */
	@ManyToMany
	@JoinTable(name="Article_Ingredients",
	joinColumns=@JoinColumn(name="FK_ArticleID",referencedColumnName="ID"),
	inverseJoinColumns=@JoinColumn(name="FK_IngredientID",referencedColumnName="ID"))
	public List<IIngredient> getIngredients() {
		throw new UnsupportedOperationException();
	}

	/**
	 * @see foodServer.IArticle#addIngredient(foodServer.IIngredient) Adds an
	 *      ingredient
	 */
	public void addIngredient(IIngredient ingredient) {
		ingredients.add(ingredient);
	}

	/**
	 * @see foodServer.IArticle#removeIngredient(foodServer.IIngredient) Removes
	 *      an ingredient
	 */
	public void removeIngredient(IIngredient ingredient) {
		ingredients.remove(ingredient);
	}
}