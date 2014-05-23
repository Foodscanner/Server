package foodServer;

/**
 * An interface for Flags
 * @author Christian Gläser
 *
 */
public interface IFlag<F>{

	/**
	 * @param aId
	 * Sets the id of an IFlag
	 */
	public void setId(int aId);

	/**
	 * @param aName
	 * Sets the name of an IFlag
	 */
	public void setName(String aName);

	/**
	 * @param aDescription
	 * Sets the description of an IFlag
	 */
	public void setDescription(String aDescription);

	/**
	 * @param aLimitToProduct
	 * Limits the parameter to a product
	 */
	public void setLimitToProduct(boolean aLimitToProduct);
	
	/**
	 * @return a long which serves as an identifier for the IFlag
	 */
	public int getId();

	/**
	 * @return A String which is a name
	 */
	public String getName();

	/**
	 * @return A String which is a description
	 */
	public String getDescription();

	/**
	 * @return If Flag is ProductOnly-Flag, returns true, else false
	 */
	public boolean getLimitToProduct();
	
	/**
	 * @return A copy of the flag
	 */
	public F copy();

}