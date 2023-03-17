package application;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTester {

	private GradeBook test;
	private GradeBook test2;
	
	@Before
	public void setUp() {
		test = new GradeBook(5);
		test.addScore(8);
		test.addScore(12);
		test.addScore(4);
		test.addScore(45);
		test.addScore(7);
		test2 = new GradeBook(5);
		test2.addScore(7);
		test2.addScore(3);
	}
	
	@After
	public void tearDown() throws Exception {
		GradeBook test = null;
		GradeBook test2 = null;
	}
	
	@Test
	public void testAddScore() {
		// Testing by addScore's return boolean
		assertEquals(5, test.getScoreSize());
		assertTrue(test.addScore(7) == false);
		assertTrue(test2.addScore(2) == true);
		test2.addScore(4);
		assertTrue(test2.addScore(2) == true);
		assertTrue(test2.addScore(8) == false);
		
		// Testing by using the toString method
		assertTrue(test.toString().equals("8.0 12.0 4.0 45.0 7.0 "));
		assertTrue(test2.toString().equals("7.0 3.0 2.0 4.0 2.0 "));
		
		// Testing by using the scoreSize method
		assertEquals(5, test.getScoreSize());
		assertEquals(5, test2.getScoreSize());
	}


	@Test
	public void testSum() {
		assertTrue(test.sum() == 76.0);
		assertTrue(test2.sum() == 10.0);
		
	}

	@Test
	public void testMinimum() {
		assertTrue(test.minimum() == 4.0);
		assertTrue(test2.minimum() == 3.0);
		test2.addScore(1);
		assertTrue(test2.minimum() == 1.0);
	}

	@Test
	public void testGetScoreSize() {
		assertEquals(5, test.getScoreSize());
		assertEquals(2, test2.getScoreSize());
		test2.addScore(5);
		test2.addScore(7);
		assertEquals(4, test2.getScoreSize());
		test2.addScore(9);
		assertEquals(5, test2.getScoreSize());
	}

	@Test
	public void testToString() {;
		assertEquals("8.0 12.0 4.0 45.0 7.0 ", test.toString());
	}

	@Test
	public void testFinalScore() {
		assertTrue(test.finalScore() == 72.0);
		assertTrue(test2.finalScore() == 7.0);
	}

}
