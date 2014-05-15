package datatype.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datatype.EAN13;
import datatype.IEAN;

public class EAN13Tests {

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {}

  @AfterClass
  public static void tearDownAfterClass() throws Exception {}

  @Before
  public void setUp() throws Exception {}

  @After
  public void tearDown() throws Exception {}

  @Test
  public void validEAN() {
    IEAN ean = new EAN13();
    //System.out.println("valid ean returns: " + ean.isValid("5010019640161"));
    assertTrue(ean.isValid(5010019640161L));
  }
  
  @Test
  public void invalidEAN() {
    IEAN ean = new EAN13();
    //System.out.println("invalidEan returns: " + ean.isValid("5010019640162"));
    assertFalse(ean.isValid(5010019640162L));
  }
  
  @Test
  public void validISBN() {
    EAN13 ean = new EAN13();
    assertTrue(ean.isISBN(9783446430150L));
  }
  
  @Test
  public void invalidISBN() {
    EAN13 ean = new EAN13();
    assertFalse(ean.isISBN(9883446430157L));
  }
  
  @Test
  public void validPrintArticle() {
    EAN13 ean = new EAN13();
    assertTrue(ean.isPrintArticle(9773446430151L));
    assertTrue(ean.isPrintArticle(9783446430150L));
  }
  
  @Test
  public void invalidPrintArticle() {
    EAN13 ean = new EAN13();
    assertFalse(ean.isPrintArticle(5010019640162L));
  }
}
