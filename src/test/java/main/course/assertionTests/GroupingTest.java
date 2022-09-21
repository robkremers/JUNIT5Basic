package main.course.assertionTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class GroupingTest {
	
	private String word;
	
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
	public void someTest() {
		assertTrue(true);
	}
	
	/**
	 * 
	 * Related tests can be grouped using the annotation @Test.
	 * The value of @DisplayName will be visible in the overview visible in the JUnit window.
	 * 
	 * @author rkremers
	 *
	 */
	@Nested
	@DisplayName(value = "For an Empty String")
	class EmptyStringTest {
		
		@BeforeEach
		void setToEmptyString(TestInfo testInfo) {
			System.out.println("  Initialize Test Data for test " + testInfo.getDisplayName() + " inside Nested class EmptyStringTest.");
			word = "";	
		}
		
		@Test
		void lengthIsZero() {
			assertEquals(0, word.length());
		}
		
		@Test
		void upperCaseIsEmtpy() {
			assertEquals("", word.toUpperCase());
		}
	}
	
	@Nested
	@DisplayName(value = "For a very Large String")
	class LargeStringTest {
		
		@BeforeEach
		public void setToLargeString(TestInfo testInfo) {
			System.out.println("  Initialize Test Data for test " + testInfo.getDisplayName() + " inside Nested class LargeStringTest.");
			word = "adsfasdfasdfasdfasdf;lkj;lkjq;lkw";
		}
		
		@Test
		public void lengthLargerThan10() {
			assertTrue( word.length() > 10);
		}
		
	}

}
