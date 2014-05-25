package foodServer.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datatype.EAN;
import datatype.IEAN;
import foodServer.Article;
import foodServer.exceptions.NumberInvalidFormatException;

/**
 * Tests for the {@link Article}
 * 
 * @author Christian Gl�ser
 * 
 */
public class ArticleTests {

	Article testArticle;
	EAN ean1;
	EAN ean2;

	/**
	 * @throws java.lang.Exception
	 *             An exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 *             An exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 *             An exception
	 */
	@Before
	public void setUp() throws Exception {
		ean1 = new EAN(5010019640161L);
		ean2 = new EAN(9783446430150L);
		testArticle = new Article(ean1.getEAN());
		testArticle.setName("Goldbaeren");
		testArticle.setDescription("Yummy yummy");
		// An example for a URI, follows RFC standard for URI and is from the
		// IANA reserved name space for tests
		testArticle.setImageURL("http://example.com/getImage?param=exampleParam");

	}

	/**
	 * @throws java.lang.Exception
	 *             An exception
	 */
	@After
	public void tearDown() throws Exception {
	}

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
		assertEquals(testArticle.getID(), new EAN());
	}

	/**
	 * Test method for {@link foodServer.Article#setID(IEAN)}.
	 * @throws NumberInvalidFormatException 
	 */
	@Test
	public void testSetID() throws NumberInvalidFormatException {
		assertEquals(testArticle.getID(), ean1);
		testArticle.setID(ean2.getEAN());
		assertEquals(testArticle.getID(), ean2);
	}

	/**
	 * Test method for {@link foodServer.Article#getName()}.
	 */
	@Test
	public void testGetName() {
		assertEquals(testArticle.getName(), "Goldb�ren");
	}

	/**
	 * Test method for {@link foodServer.Article#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		assertEquals(testArticle.getName(), "Goldbaeren");
		testArticle.setName("Silberbaeren");
		assertEquals(testArticle.getName(), "Silberbaeren");
	}

	/**
	 * Test method for {@link foodServer.Article#getDescription()}.
	 */
	@Test
	public void testGetDescription() {
		assertEquals(testArticle.getDescription(), "Yummy yummy");
	}

	/**
	 * Test method for
	 * {@link foodServer.Article#setDescription(java.lang.String)}.
	 */
	@Test
	public void testSetDescription() {
		assertEquals(testArticle.getDescription(), "Yummy yummy");
		testArticle.setDescription("Not as yummy");
		assertEquals(testArticle.getDescription(), "Not as yummy");
	}

	/**
	 * Test method for {@link foodServer.Article#getImageURI()}.
	 */
	@Test
	public void testGetImageURI() {
			assertEquals(testArticle.getImageURL(), "http://example.com/getImage?param=exampleParam");
	}

	/**
	 * Test method for {@link foodServer.Article#setImageURI(java.net.URI)}.
	 */
	@Test
	public void testSetImageURI() {
			assertEquals(testArticle.getImageURL(), "http://example.com/getImage?param=exampleParam");
			testArticle.setImageURL("http://example.org/getImage2?param2=exampleParam2");
			assertEquals(testArticle.getImageURL(), "http://example.org/getImage2?param2=exampleParam2");
	}

	/**
	 * Test method for {@link foodServer.Article#getIngredients()}.
	 */
	@Test
	public void testGetIngredients() {
		fail("Not yet implemented");
	}

	/**
	 * Flag needs to be tested to create reliable results here Test method for
	 * {@link foodServer.Article#getFlags()}.
	 */
	@Test
	public void testGetFlags() {
		fail("Not yet implemented");
	}

	/**
	 * Flag needs to be tested to create reliable results here Test method for
	 * {@link foodServer.Article#getProductFlags()}.
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
