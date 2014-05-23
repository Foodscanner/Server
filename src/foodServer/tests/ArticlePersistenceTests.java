package foodServer.tests;

import static org.junit.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datatype.EAN13;
import datatype.IEAN;
import foodServer.Article;
import foodServer.ArticleUtil;
import foodServer.Flag;
import foodServer.IArticle;
import foodServer.IFlag;
import foodServer.IIngredient;
import foodServer.Ingredient;
import foodServer.exceptions.DatabaseConnectionException;
import foodServer.exceptions.NumberInvalidFormatException;

public class ArticlePersistenceTests {
  
  Article articleOne;
  Article articleTwo;
  IEAN ean1;
  IEAN ean2;
  List<Flag> flags;
  

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {}

  @AfterClass
  public static void tearDownAfterClass() throws Exception {}

  @Before
  public void setUpDB() throws Exception {
    //delete tables
    //insert new tables
  }

  @After
  public void tearDown() throws Exception {}


  /**
   * Test method for {@link foodServer.Article#Article(IEAN)}.
   * Tests if an error occurs during persistence
   * @throws NumberInvalidFormatException If ean set during test is invalid, which should not occur
   */
  @Before
  public void testArticle() throws NumberInvalidFormatException {
    ean1 = new EAN13(5010019640161L);
    ean2 = new EAN13(1234567891019L);
    articleOne = new Article(ean1);
    for(int i=0;i<10;i++){
    	Flag flag = new Flag();
    	flag.setDescription("Desc: " + i);
    	flag.setName("Name: " + i);
        flags.add(flag);
        articleOne.addFlag(flag);
    }
    articleOne.setName("Goldbären");
    articleOne.setDescription("Yummy yummy");
    
    for(int i=0;i<10;i++){
    	 Ingredient ingredient = new Ingredient();
         ingredient.setName("IngredientName: " + i);
         
    	for(int j=0;j<10;j++){
    		Flag flag = new Flag();
        	flag.setDescription("IngredientFlag-Desc: " + "i: " + i+ "j: " + j);
        	flag.setName("IngredientFlag-Name: " + "i: " + i+ "j: " + j);
    		ingredient.addFlag(flag);
    	}    	
        articleOne.addIngredient(ingredient);
    }
    
    //An example for a URI, follows RFC standard for URI and is from the IANA reserved name space for tests 
    try {
      articleOne.setImageURI(new URI("http://example.com/getImage?param=exampleParam"));
    } catch (URISyntaxException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      fail("No exception expected here");
    }
      articleTwo = new Article(ean2);
      articleTwo.setName("Example product");
      articleTwo.setDescription("Paperlike dry taste with black letters to assist mouthfeel");
      //An example for a URI, follows RFC standard for URI and is from the IANA reserved name space for tests 
      try {
        articleTwo.setImageURI(new URI("http://example.com/getImage?param=exampleParam"));
      } catch (URISyntaxException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        fail("No exception expected here");
      }
    
  }

  /**
   * Test method for {@link foodServer.Article#getID()}.
   * Tests if persisted is equal to id articleOne
   * @throws NumberInvalidFormatException Is thrown if id is not a valid ean
 * @throws DatabaseConnectionException 
   */
  @Test
  public void testGetID() throws NumberInvalidFormatException, DatabaseConnectionException {
    //articleOne.persist();
    IArticle newArticle = ArticleUtil.getArticle(ean1);
    assertEquals(articleOne.getID(),newArticle.getID());
  }


  /**
   * Test method for {@link foodServer.Article#getName()}.
   * Tests if persisted name is equal
   * @throws NumberInvalidFormatException Is thrown if number is not a valid EAN
 * @throws DatabaseConnectionException 
   * 
   */
  @Test
  public void testGetName() throws NumberInvalidFormatException, DatabaseConnectionException {
    //articleOne.persist();
    IArticle newArticle = ArticleUtil.getArticle(articleOne.getID());
    assertEquals(articleOne.getName(),newArticle.getName());
  }

  /**
   * Test method for {@link foodServer.Article#getDescription()}.
   * Tests if persisted Description is equal
   * @throws NumberInvalidFormatException If number is not a valid EAN, exception is thrown
 * @throws DatabaseConnectionException 
   */
  @Test
  public void testGetDescription() throws NumberInvalidFormatException, DatabaseConnectionException {
    //articleOne.persist();
    IArticle newArticle = ArticleUtil.getArticle(articleOne.getID());
    assertEquals(articleOne.getDescription(),newArticle.getDescription());
  }

  /**
   * Test method for {@link foodServer.Article#getImageURI()}.
   * Tests if persisted imageURI is equal
   * @throws NumberInvalidFormatException If number is not a valid EAN, exception is thrown
 * @throws DatabaseConnectionException 
   */
  @Test
  public void testGetImageURI() throws NumberInvalidFormatException, DatabaseConnectionException {
    //articleOne.persist();
    IArticle newArticle = ArticleUtil.getArticle(articleOne.getID());
    assertEquals(articleOne.getImageURI(),newArticle.getImageURI());
  }

  /**
   * Test method for {@link foodServer.Article#getIngredients()}.
   * Tests if all ingredients have been persisted
 * @throws DatabaseConnectionException 
   */
  @Test
  public void testGetIngredients() throws DatabaseConnectionException {
	    //articleOne.persist();
	    IArticle newArticle = ArticleUtil.getArticle(articleOne.getID());
	    for(IIngredient ingredient:newArticle.getIngredients()){
	    	assertTrue(articleOne.getIngredients().contains(ingredient));
	    }
  }

  /**
   * Test method for {@link foodServer.Article#getFlags()}.
   * Tests if all flags can be retrieved
 * @throws DatabaseConnectionException 
   */
  @Test
  public void testGetFlags() throws DatabaseConnectionException {
	  //articleOne.persist();
	    IArticle newArticle = ArticleUtil.getArticle(articleOne.getID());
	    for(IFlag flag:newArticle.getFlags()){
	    	assertTrue(articleOne.getFlags().contains(flag));
	    }
  }

  /**
   * Test method for {@link foodServer.Article#getProductFlags()}.
   * Tests if all product specific flag can be retrieved
 * @throws DatabaseConnectionException 
   */
  @Test
  public void testGetProductFlags() throws DatabaseConnectionException {
	  //articleOne.persist();
	    IArticle newArticle = ArticleUtil.getArticle(articleOne.getID());
	    for(IFlag flag:newArticle.getProductFlags()){
	    	assertTrue(articleOne.getProductFlags().contains(flag));
	    }
  }

  /**
   * Test method for {@link foodServer.Article#removeFlag(foodServer.IFlag)}.
   * Tests if a flag can be removed and if change can be persisted
 * @throws DatabaseConnectionException 
   */
  @Test
  public void testRemoveProductFlag() throws DatabaseConnectionException {
	  //articleOne.persist();
	  articleOne.removeFlag(flags.get(0));
	  //articleOne.persist();
	  IArticle newArticle = ArticleUtil.getArticle(articleOne.getID());
	  assertFalse(newArticle.getProductFlags().contains(flags.get(0)));
  }


}
