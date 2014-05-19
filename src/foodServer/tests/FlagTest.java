package foodServer.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//TODO Task assigned to Felipe
//TODO INFORMATION FOR ME: Insert constructor in class Flag.java ?
//TODO What description do we have for ID?
import foodServer.Flag;

/**
 * Tests for the {@link Flag}
 * 
 * @author Felipe Oehrwald
 * @version 1.0
 * 
 * 
 * 
 */
public class FlagTest {

	Flag test1;
	Flag test2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		test1 = new Flag();
		test1.setId(1);
		test1.setName("Lactose");
		test1.setDescription("Handelsklasse A");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetId() {
		assertEquals(test1.getId(), 1);
	}

	@Test
	public void testSetId() {
		int randomID = 2;
		// assertEquals(test1.getId(), randomID);
		test1.setId(2);
		assertEquals(test1.getId(), randomID);
	}

	@Test
	public void testGetName() {
		assertEquals(test1.getName(), "Lactose");
	}

	@Test
	public void testSetName() {
		assertEquals(test1.getName(), "Lactose");
		test1.setName("Lactase");
		assertEquals(test1.getName(), "Lactase");
	}

	@Test
	public void testGetDescription() {
		assertEquals(test1.getDescription(), "Handelsklasse A");

	}

	@Test
	public void testSetDescription() {
		// assertEquals(test1.getDescription(), "Handelsklasse A");
		// test1.setDescription("Handelsklasse B");
		//

	}

	@Test
	public void testGetLimitToProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetLimitToProduct() {
		fail("Not yet implemented");
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
