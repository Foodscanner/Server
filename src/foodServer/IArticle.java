package foodServer;

import java.util.List;

import datatype.IEAN;
import foodServer.exceptions.NumberInvalidFormatException;


/**
 * An Interface for {@link Article}
 * @author Christian Gläser
 *
 */
public interface IArticle<E extends IEAN,F extends IFlag,I extends IIngredient<F>> {
	
	
	//ID
	/**
	 * @return Returns the EAN of the Product
	 */
	public long getID();

	/**
	 * Necessary in case EAN changes, should be used with caution
	 * @param aID This id is being set
	 * @throws NumberInvalidFormatException Is thrown if number is not a valid ean
	 */
	public void setID(long aID) throws NumberInvalidFormatException;

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
	public String getImageURL();
	
	/**
	 * @param ImageURL The image URI to set
	 */
	public void setImageURL(String ImageURL);
	
	//Description
	public String getDescription();

	/**
	 * @param aDescription The description
	 */
	public void setDescription(String aDescription);
	
	//Flags
	/**
	 * Adds a product-specific flag
	 * @param flag A flag that should be added to IArticle
	 */
	public void addFlag(F flag);

	/**
	 * Removes a product-specific flag
	 * @param flag A flag that should be removed from IArticle
	 */
	public void removeFlag(F flag);
	
	public List<F> getFlags();
	
	public List<F> getAllFlags();
	
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