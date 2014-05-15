package foodServer.exceptions;

public class NumberInvalidFormatException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = 3157958246505690851L;
  
  public NumberInvalidFormatException(){
    super("The number specified is not in the correct format");
  }
  
  public NumberInvalidFormatException(String message){
    super("The number specifed is not in the correct format! " + message);
  }

}
