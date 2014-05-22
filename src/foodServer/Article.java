package foodServer;

import java.net.URI;
import java.util.List;

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
	}

	/**
	 * Gets the id of the Article as long
	 * 
	 * @see foodServer.IArticle#getID()
	 * 
	 */
	public IEAN getID() {
		return id;
	}

	/**
	 * If aId is a valid id, it is set as new id
	 * 
	 * @see foodServer.IArticle#setID(IEAN ean)
	 * @param ean
	 *            The ean to set
	 */
	public void setID(IEAN ean) {
		id = ean;
	}

	/**
	 * @see foodServer.IArticle#getName()
	 * @return The name of the article
	 */
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