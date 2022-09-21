package main.course.assertionTests;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayTest {
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("Initialize Test Data for each test.");
	}
	
	@AfterEach
	public void afterEach() {
		System.out.println("Clear Test data after each test.");
	}
	
	@Test
	public void basicArrayTest() {
		
		String strWords = "abc def ghi";
		String[] strArray = strWords.split(" ");
		
		String[] expectedArrayResult = new String[] {"abc", "def", "ghi"};
		
		// The message will only be visible in case the test will fail.
		assertArrayEquals(expectedArrayResult, strArray, "Test array abc def ghi");
	}

}
