package database.exceptions;

public class NonUniqueKeyException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 965980290806886852L;

	public NonUniqueKeyException(String message){
		super(message);
	}
}
