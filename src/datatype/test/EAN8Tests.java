package datatype.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datatype.EAN13;
import datatype.EAN8;
import datatype.IEAN;

public class EAN8Tests {

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
    IEAN ean = new EAN8();
    //System.out.println("valid ean returns: " + ean.isValid("5010019640161"));
    assertTrue(ean.isValid(21285943L));
  }
  
  @Test
  public void invalidEAN() {
    IEAN ean = new EAN8();
    //System.out.println("invalidEan returns: " + ean.isValid("5010019640162"));
    assertFalse(ean.isValid(21285944L));
  }
}
