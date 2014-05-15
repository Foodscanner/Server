package datatype;

import java.util.ArrayList;
import java.util.List;

import foodServer.exceptions.NumberInvalidFormatException;

/**
 * An implementation of the GS1 specification for the EAN with 13 digits
 * @author Christian Gläser
 *
 */
public class EAN13 implements IEAN{
  
  long ean13;
  
  /**
   * Standard constructor for the EAN
   */
public EAN13() {
    
  }
  
  public EAN13(long ean) throws NumberInvalidFormatException {
    setEan(ean);
  }
  
  /**
   * Returns true if 
   * @param value The value to check
   * @return true if number to check is an GS1 EAN13, else false
   * source: Hibernate Validator v1.4
   */
  public boolean isValid(long value) {
    Long longValue = new Long(value);
    String stringValue =  longValue.toString();
			if (stringValue == null) return false;
			if (stringValue.length()!=13) return false;
			String creditCard = stringValue;
			char[] chars = creditCard.toCharArray();

			List<Integer> ints = new ArrayList<Integer>();
			for (char c : chars) {
				if ( Character.isDigit( c ) ) ints.add( c - '0' );
			}
			int length = ints.size();
			int sum = 0;
			boolean even = false;
			for ( int index = length - 1 ; index >= 0 ; index-- ) {
				int digit = ints.get(index);
				if  (even) {
					digit *= 3;
				}
				sum+= digit;
				even = !even;
			}
			return  sum % 10 == 0;
	}
  
  /**
   * Returns true, if number is valid GS1 ISBN, a subset of valid EAN's (starts with either 978 or 979
 * @param insertValue The value to check
 * @return true, if number is ISBN
 */
  public boolean isISBN(long insertValue) {
	  boolean retVal = false;
	  if(isValid(insertValue)){
	    Long longInsertValue = new Long(insertValue);
	    String value =  longInsertValue.toString();
		  char[] chars = value.toCharArray();
		  List<Integer> ints = new ArrayList<Integer>();
			for (char c : chars) {
				if ( Character.isDigit( c ) ) ints.add( c - '0' );
			}
		  if ((ints.get(0)==9)&&(ints.get(1)==7)&&((ints.get(2)==8)||(ints.get(2)==9))){
			  
			  retVal = true;
			  }
	  }
	  return retVal;
  }
  
  /**
   * @param insertValue The value to check
   * @return true, if valid GS1 ISSN, a subset of valid EANs
   */
  public boolean isISSN(long insertValue) {
	  boolean retVal = false;
	  if(isValid(insertValue)){
	    Long longInsertValue = new Long(insertValue);
	    String value =  longInsertValue.toString();
		  char[] chars = value.toCharArray();
		  List<Integer> ints = new ArrayList<Integer>();
			for (char c : chars) {
				if ( Character.isDigit( c ) ) ints.add( c - '0' );
			}
		  if ((ints.get(0)==9)&&(ints.get(1)==7)&&(ints.get(2)==7)){
			  
			  retVal = true;
			  }
	  }
	  return retVal;
  }
  
  /**
   * Returns true, if number is valid GS1 ISSN or ISBN, a subset of valid EAN's (starts with either 977, 978 or 979
 * @param value This value is being checked
 * @return true, if number is ISSN or ISBN
 */
  public boolean isPrintArticle(long value) {
	  return(isValid(value)&&(isISBN(value)||isISSN(value)));
  }
  
  /**
   * @see datatype.IEAN#setEan(long)
   * @param ean This value is being checked
   * Sets/Updates the EAN if EAN is valid
   */
  public void setEan(long ean) throws NumberInvalidFormatException{
    if(isValid(ean)){
      ean13 = ean;
    }
    else throw new NumberInvalidFormatException("This is not a valid EAN!");
  }

/**
 * @see datatype.IEAN#getEAN()
 * Returns the value of the EAN as long
 */
public long getEAN() {
	return ean13;
}
  
  
}
