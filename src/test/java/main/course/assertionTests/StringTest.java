package main.course.assertionTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class StringTest {
	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("Initialize Test situation for all tests.");	
		// e.g. Setting up a connection with a database.
	}
	
	@BeforeEach
	public void beforeEach(TestInfo testInfo) {
		System.out.println("  Initialize Test Data for test " + testInfo.getDisplayName());
		// e.g. Closing the connection with a database.
	}
	
	@AfterEach
	public void afterEach(TestInfo testInfo) {
		System.out.println("  Clear Test data after test " + testInfo.getDisplayName());
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("Finalize Test situation for all tests.");
	}

	@Test
	public void testStringLength() {
		System.out.println("    Testing the length of a String.");
		// A basic test in JUnit 5 testing.
//		fail("You Loser!");
		
		// Write the test code.
		// Invoke a business method: the Code Under Test (CUT).
		// Check the correctness of the outcome --> Use Assertions.
		
		String word = "ABCD";
		int wordLength = word.length();
		int expectedLength = 4;
		
		assertEquals(expectedLength, wordLength);
	}
	
	@Test
	public void testToUpperCase() {
		System.out.println("    Testing the uppercase value of a String.");
		String strWord = "abcd";
		String result = strWord.toUpperCase();
		String expectedWord = "ABCD";
		
		assertEquals(expectedWord, result);
		assertNotNull(result);
	}
	
	@Test
	public void testIfNull() {
		System.out.println("    Testing whether a String is null.");
		
		String strWord = null;
		
		assertNull(strWord);
	}
	
	@Test
	public void testIfNotNull() {
		System.out.println("    Testing whether a String is not null.");
		
		String strWord = "";
		assertNotNull(strWord);
	}
	
	@Test
	public void testStringContains() {
		System.out.println("    Testing whether a String contains a specific subString.");

		String strWord = "abcdegh";
		String strSubWord = "ikj";
		
		assertEquals(false, strWord.contains(strSubWord));
		// In this case a better way would be:
		assertFalse(strWord.contains(strSubWord));
	}

}
