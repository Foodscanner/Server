package foodServer.tests;

import static org.junit.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datatype.EAN13;
import foodServer.Article;
import foodServer.exceptions.NumberInvalidFormatException;



/**
 * Tests for the {@link Article}
 * @author Christian Gläser
 *
 */
public class ArticleTests {
  
   Article testArticle;
   EAN13 ean1;
   EAN13 ean2;

  /**
   * @throws java.lang.Exception An exception
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {}

  /**
   * @throws java.lang.Exception An exception
   */
  @AfterClass
  public static void tearDownAfterClass() throws Exception {}

  /**
   * @throws java.lang.Exception An exception
   */
  @Before
  public void setUp() throws Exception {
    ean1 = new EAN13(5010019640161L);
    ean2 = new EAN13(9783446430150L);
    testArticle = new Article(ean1);
    testArticle.setName("Goldbären");
    testArticle.setDescription("Yummy yummy");
    //An example for a URI, follows RFC standard for URI and is from the IANA reserved name space for tests 
    testArticle.setImageURI(new URI("http://example.com/getImage?param=exampleParam"));
    
  }

  /**
   * @throws java.lang.Exception An exception
   */
  @After
  public void tearDown() throws Exception {}

  /**
   * Test method for {@link foodServer.Article#Article(IEAN)}.
   */
  @Test
  public void testArticle() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link foodServer.Article#getID()}.
   */
  @Test
  public void testGetID() {
    assertEquals(testArticle.getID(),new EAN13());
  }

  /**
   * Test method for {@link foodServer.Article#setID(IEAN)}.
   */
  @Test
  public void testSetID() {
      assertEquals(testArticle.getID(),ean1);
      testArticle.setID(ean2);
      assertEquals(testArticle.getID(),ean2);
  }

  /**
   * Test method for {@link foodServer.Article#getName()}.
   */
  @Test
  public void testGetName() {
    assertEquals(testArticle.getName(),"Goldbären");
  }

  /**
   * Test method for {@link foodServer.Article#setName(java.lang.String)}.
   */
  @Test
  public void testSetName() {
    assertEquals(testArticle.getName(),"Goldbären");
    testArticle.setName("Silberbären");
    assertEquals(testArticle.getName(),"Silberbären");
  }

  /**
   * Test method for {@link foodServer.Article#getDescription()}.
   */
  @Test
  public void testGetDescription() {
    assertEquals(testArticle.getDescription(),"Yummy yummy");
  }

  /**
   * Test method for {@link foodServer.Article#setDescription(java.lang.String)}.
   */
  @Test
  public void testSetDescription() {
    assertEquals(testArticle.getDescription(),"Yummy yummy");
    testArticle.setDescription("Not as yummy");
    assertEquals(testArticle.getDescription(),"Not as yummy");
  }

  /**
   * Test method for {@link foodServer.Article#getImageURI()}.
   */
  @Test
  public void testGetImageURI() {
    try {
      assertEquals(testArticle.getImageURI(),new URI("http://example.com/getImage?param=exampleParam"));
    } catch (URISyntaxException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * Test method for {@link foodServer.Article#setImageURI(java.net.URI)}.
   */
  @Test
  public void testSetImageURI() {
    try {
      assertEquals(testArticle.getImageURI(),new URI("http://example.com/getImage?param=exampleParam"));
      testArticle.setImageURI(new URI("http://example.org/getImage2?param2=exampleParam2"));
      assertEquals(testArticle.getImageURI(),new URI("http://example.org/getImage2?param2=exampleParam2"));
    } catch (URISyntaxException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * Test method for {@link foodServer.Article#getIngredients()}.
   */
  @Test
  public void testGetIngredients() {
    fail("Not yet implemented");
  }





  /**
   * Flag needs to be tested to create reliable results here
   * Test method for {@link foodServer.Article#getFlags()}.
   */
  @Test
  public void testGetFlags() {
    fail("Not yet implemented");
  }

  /**
   * Flag needs to be tested to create reliable results here
   * Test method for {@link foodServer.Article#getProductFlags()}.
   */
  @Test
  public void testGetProductFlags() {
    fail("Not yet implemented");
  }



  /**
   * Test method for {@link foodServer.Article#removeFlag(foodServer.IFlag)}.
   */
  @Test
  public void testRemoveFlag() {
    fail("Not yet implemented");
  }

}
