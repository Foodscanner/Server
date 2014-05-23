package foodServer.exceptions;

public class DatabaseConnectionException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6854102585791890707L;

	public DatabaseConnectionException(){
		super("There was some problem with the database connection");
	}
	
	public DatabaseConnectionException(String reason){
		super("There was some problem with the database connection, reason given was: " + reason);
	}
}
