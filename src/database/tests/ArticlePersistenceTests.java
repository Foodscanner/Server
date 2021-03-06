package database.tests;

import static org.junit.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datatype.EAN;
import datatype.IEAN;
import foodServer.Article;
import database.ArticleUtil;
import foodServer.Flag;
import foodServer.IArticle;
import foodServer.IFlag;
import foodServer.IIngredient;
import foodServer.Ingredient;
import foodServer.exceptions.DatabaseConnectionException;
import foodServer.exceptions.NumberInvalidFormatException;

/**
 * @author Christian Gl�ser
 * Tests concerning article persistence
 */
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
   * Test method for {@link foodServer.Article#Article(long)}.
   * Tests if an error occurs during persistence
   * @throws NumberInvalidFormatException If ean set during test is invalid, which should not occur
   */
  @Before
  public void testArticle() throws NumberInvalidFormatException {
    ean1 = new EAN(5010019640161L);
    ean2 = new EAN(1234567891019L);
    articleOne = new Article(ean1.getEAN());
    flags = new ArrayList<Flag>();
    for(int i=0;i<10;i++){
    	Flag flag = new Flag();
    	flag.setDescription("Desc: " + i);
    	flag.setName("Name: " + i);
        flags.add(flag);
        articleOne.addFlag(flag);
    }
    articleOne.setName("Goldb�ren");
    articleOne.setDescription("Yummy yummy");
    
    for(int i=0;i<10;i++){
    	 Ingredient ingredient = new Ingredient();
         ingredient.setName("IngredientName: " + i);
         //some example flags
    	for(int j=0;j<10;j++){
    		Flag flag = new Flag();
        	flag.setDescription("IngredientFlag-Desc: " + "i: " + i+ "j: " + j);
        	flag.setName("IngredientFlag-Name: " + "i: " + i+ "j: " + j);
    		ingredient.addFlag(flag);
    	}    	
        articleOne.addIngredient(ingredient);
    }
    
    //An example for a URI, follows RFC standard for URI and is from the IANA reserved name space for tests 
      articleOne.setImageURL("http://example.com/getImage?param=exampleParam");
      articleTwo = new Article(ean2.getEAN());
      articleTwo.setName("Example product");
      articleTwo.setDescription("Paperlike dry taste with black letters to assist mouthfeel");
      //An example for a URI, follows RFC standard for URI and is from the IANA reserved name space for tests 
        articleTwo.setImageURL("http://example.com/getImage?param=exampleParam");
  }

  /**
   * Test method for {@link foodServer.Article#getID()}.
   * Tests if persisted is equal to id articleOne
   * @throws NumberInvalidFormatException If number is not a valid EAN, exception is thrown
   * @throws DatabaseConnectionException If database connection is not possible, exception is thrown
   */
  @Test
  public void testGetID() throws NumberInvalidFormatException, DatabaseConnectionException {
    //articleOne.persist();
    
	Article newArticle = ArticleUtil.getArticle(ean1);
    assertEquals(articleOne.getID(),newArticle.getID());
  }


  /**
   * Test method for {@link foodServer.Article#getName()}.
   * Tests if persisted name is equal
    * @throws NumberInvalidFormatException If number is not a valid EAN, exception is thrown
   * @throws DatabaseConnectionException If database connection is not possible, exception is thrown
   * 
   */
  @Test
  public void testGetName() throws NumberInvalidFormatException, DatabaseConnectionException {
    //articleOne.persist();
    Article newArticle = ArticleUtil.getArticle(new EAN(articleOne.getID()));
    assertEquals(articleOne.getName(),newArticle.getName());
  }

  /**
   * Test method for {@link foodServer.Article#getDescription()}.
   * Tests if persisted Description is equal
   * @throws NumberInvalidFormatException If number is not a valid EAN, exception is thrown
 * @throws DatabaseConnectionException Is thrown if database connection could not be established
   */
  @Test
  public void testGetDescription() throws NumberInvalidFormatException, DatabaseConnectionException {
    //articleOne.persist();
    Article newArticle = ArticleUtil.getArticle(new EAN(articleOne.getID()));
    assertEquals(articleOne.getDescription(),newArticle.getDescription());
  }

  /**
   * Test method for {@link foodServer.Article#getImageURL()}.
   * Tests if persisted imageURI is equal
   * @throws NumberInvalidFormatException If number is not a valid EAN, exception is thrown
   * @throws DatabaseConnectionException If database connection is not possible, exception is thrown
   */
  @Test
  public void testGetImageURI() throws NumberInvalidFormatException, DatabaseConnectionException {
    //articleOne.persist();
    Article newArticle = ArticleUtil.getArticle(new EAN(articleOne.getID()));
    assertEquals(articleOne.getImageURL(),newArticle.getImageURL());
  }

  /**
   * Test method for {@link foodServer.Article#getIngredients()}.
   * Tests if all ingredients have been persisted
   * @throws NumberInvalidFormatException If number is not a valid EAN, exception is thrown
   * @throws DatabaseConnectionException If database connection is not possible, exception is thrown
   */
  @Test
  public void testGetIngredients() throws DatabaseConnectionException, NumberInvalidFormatException {
	    //articleOne.persist();
	    Article newArticle = ArticleUtil.getArticle(new EAN(articleOne.getID()));
	    for(Ingredient ingredient:newArticle.getIngredients()){
	    	assertTrue(articleOne.getIngredients().contains(ingredient));
	    }
  }

  /**
   * Test method for {@link foodServer.Article#getFlags()}.
   * Tests if all flags can be retrieved
   * @throws NumberInvalidFormatException If number is not a valid EAN, exception is thrown
   * @throws DatabaseConnectionException If database connection is not possible, exception is thrown
   */
  @Test
  public void testGetFlags() throws DatabaseConnectionException, NumberInvalidFormatException {
	  //articleOne.persist();
	    Article newArticle = ArticleUtil.getArticle(new EAN(articleOne.getID()));
	    for(IFlag flag:newArticle.getAllFlags()){
	    	assertTrue(articleOne.getAllFlags().contains(flag));
	    }
  }

  /**
   * Test method for {@link foodServer.Article#getFlags()}.
   * Tests if all product specific flag can be retrieved
   * @throws NumberInvalidFormatException If number is not a valid EAN, exception is thrown
   * @throws DatabaseConnectionException If database connection is not possible, exception is thrown
   */
  @Test
  public void testGetProductFlags() throws DatabaseConnectionException, NumberInvalidFormatException {
	  //articleOne.persist();
	    Article newArticle = ArticleUtil.getArticle(new EAN(articleOne.getID()));
	    for(Flag flag:newArticle.getFlags()){
	    	assertTrue(articleOne.getFlags().contains(flag));
	    }
  }

  /**
   * Test method for {@link foodServer.Article#removeFlag(foodServer.Flag)}.
   * Tests if a flag can be removed and if change can be persisted
   * @throws NumberInvalidFormatException If number is not a valid EAN, exception is thrown
   * @throws DatabaseConnectionException If database connection is not possible, exception is thrown
   */
  @Test
  public void testRemoveProductFlag() throws DatabaseConnectionException, NumberInvalidFormatException {
	  //articleOne.persist();
	  articleOne.removeFlag(flags.get(0));
	  //articleOne.persist();
	  Article newArticle = ArticleUtil.getArticle(new EAN(articleOne.getID()));
	  assertFalse(newArticle.getFlags().contains(flags.get(0)));
  }


}
