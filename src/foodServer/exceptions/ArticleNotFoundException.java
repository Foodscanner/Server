package foodServer.exceptions;

public class ArticleNotFoundException extends Exception {
  
  /**
   * 
   */
  private static final long serialVersionUID = -8862488131684705518L;

  public ArticleNotFoundException(){
    super("The article requested is not contained in database");
  }
  

}
