package datatype;

import foodServer.exceptions.NumberInvalidFormatException;

/**
 * The interface for all EANs, including EAN with 8 and EAN with 13 digits
 * @author Christian Gläser
 *
 */
public interface IEAN {
  
	/**
	 * @param ean The ean to set, is only set if ean is sucessfully validated. Else request is ignored
 	 * @return true if IEAN is valid
 	 */
	public boolean isValid(long ean);
	
	public boolean isValid(String ean);
	
	/**
	 * @return value of IEAN as long
	 */
	public long getEAN();
	
	//?
	//public long getEANAsLong();
  
	/**
	 * @param ean A long which is set as EAN if it is successfully validated
	 * @throws NumberInvalidFormatException Is thrown if number is not a valid ean. To prevent exception, check number using isValid prior to set
	 * 
	 */
	public void setEan(long ean) throws NumberInvalidFormatException;
	
	public void setEan(String ean) throws NumberInvalidFormatException;

}
