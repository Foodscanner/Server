package database.exceptions;

/**
 * @author Christian Gl�ser
 * Exception is thrown if no flags exist
 */
public class NoFlagsExistException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5327812058717486087L;

	public NoFlagsExistException(String msg){
		super(msg);
	}
}
