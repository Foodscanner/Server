package foodServer.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import foodServer.Flag;
import foodServer.IFlag;
import foodServer.IIngredient;
import foodServer.Ingredient;

public class IngredientTest {
  
  IIngredient testIngredient;
  IFlag flag1;
  IFlag flag2;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {}

  @AfterClass
  public static void tearDownAfterClass() throws Exception {}

  @Before
  public void setUp() throws Exception {
    testIngredient = new Ingredient();
    testIngredient.setId(123);
    testIngredient.setName("Sugar");
    setUpFlags();
  }
  
  private void setUpFlags(){
    System.out.println("setup flags");
    flag1 = new Flag();
    flag1.setId(2);
    flag1.setDescription("Some random allergy");
    flag2 = new Flag();
    flag2.setId(3);
    flag2.setDescription("Some random warning flag");
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testGetId() {
    assertTrue(testIngredient.getId()==(123L));
  }

  @Test
  public void testSetId() {
    assertTrue(testIngredient.getId()==(123));
    testIngredient.setId(124);
    assertTrue(testIngredient.getId()==(124));
    
  }

  @Test
  public void testGetName() {
    assertEquals(testIngredient.getName(),("Sugar"));
  }

  @Test
  public void testSetName() {
    assertEquals(testIngredient.getName(),("Sugar"));
    testIngredient.setName("Lactose");
    assertEquals(testIngredient.getName(),("Lactose"));
  }

  @Test
  public void testAddFlag() {
    assertTrue(testIngredient.getFlags().size()==0);
    testIngredient.addFlag(flag1);
    assertTrue(testIngredient.getFlags().size()==1);
  }

  //TODO How is the equality of removed items ensured?
  @Test
  public void testRemoveFlagEmptyAfterwards() {
    assertTrue(testIngredient.getFlags().size()==1);
    testIngredient.removeFlag(flag1);
    assertTrue(testIngredient.getFlags().size()==0);  
  }
  
  @Test
  public void testRemoveFlagOneAfterwards() {
    assertTrue(testIngredient.getFlags().size()==1);
    testIngredient.addFlag(flag2);
    assertTrue(testIngredient.getFlags().size()==2);
    testIngredient.removeFlag(flag1);
    assertTrue(testIngredient.getFlags().size()==1);  
  }
  
  @Test
  public void testRemoveNonExistingFlag() {
    assertTrue(testIngredient.getFlags().size()==1);
    //flag2 is not part of the flag list for this ingredient
    testIngredient.removeFlag(flag2);
    assertTrue(testIngredient.getFlags().size()==0);
  }

  @Test
  public void testGetFlags() {
    assertTrue(testIngredient.getFlags().size()==0);
    //get the one element that should be contained
    testIngredient.addFlag(flag1);
    assertTrue(testIngredient.getFlags().get(0).equals(flag1));
    testIngredient.addFlag(flag2);
    assertTrue(testIngredient.getFlags().get(1).equals(flag2));
  }

  @Test
  public void testCopy() {
    fail("Not yet implemented");
  }

  @Test
  public void testPersist() {
    fail("Not yet implemented");
  }

}
