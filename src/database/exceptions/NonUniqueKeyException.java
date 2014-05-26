package database.exceptions;

/**
 * @author Christian Gläser
 * Exception is thrown if unique key is not unique
 */
public class NonUniqueKeyException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 965980290806886852L;

	public NonUniqueKeyException(String message){
		super(message);
	}
}
