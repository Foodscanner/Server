package foodServer;

import java.net.URI;
import java.util.List;

import datatype.IEAN;


/**
 * An Interface for {@link Article}
 * @author Christian Gl�ser
 *
 */
public interface IArticle<F,I> {
	
	
	//ID
	/**
	 * @return Returns the EAN of the Product
	 */
	public IEAN getID();

	/**
	 * Necessary in case EAN changes, should be used with caution
	 * @param aID This id is being set
	 */
	public void setID(IEAN aID);

	//Name
	/**
	 * @return The Name of the Product
	 */
	public String getName();
	
	/**
	 * @param aName The name to set
	 */
	public void setName(String aName);

	//Image URI
	public URI getImageURI();
	
	/**
	 * @param aImageURI The image URI to set
	 */
	public void setImageURI(URI aImageURI);
	
	//Description
	public String getDescription();

	/**
	 * @param aDescription The description
	 */
	public void setDescription(String aDescription);
	
	//Flags
	/**
	 * Adds a product-specific flag
	 * @param aFlag A flag that should be added to IArticle
	 */
	public void addFlag(F aFlag);

	/**
	 * Removes a product-specific flag
	 * @param aFlag A flag that should be removed from IArticle
	 */
	public void removeFlag(F aFlag);
	
	public List<F> getFlags();
	
	public List<F> getProductFlags();
	
	//Ingredients
	public List<I> getIngredients();
	
    /**
     * @param ingredient The ingredient to add
     */
    public void addIngredient(I ingredient);
    
    /**
     * @param ingredient The ingredient to remove
     */
    public void removeIngredient(I ingredient);
	





	







}