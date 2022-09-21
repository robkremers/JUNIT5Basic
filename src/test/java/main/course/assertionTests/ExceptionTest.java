package main.course.assertionTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExceptionTest {
	
	/**
	 * assertThrows
     * public static <T extends Throwable> T assertThrows​(Class<T> expectedType,
     *                                             Executable executable,
     *                                             String message)
     *                                             
     * org.junit.jupiter.api.function.Executable
     * - Functional interface
     * - Equal to java.lang.Runnable
     * - Can throw any kind of Exception  
     * 
     * Annotation @DisplayName:
     * - used to declare a custom display name for the annotated test class 
     *   or test method.
     *   - Normally the class / method name would be shown.
     * - Display names are typically used for test reporting in IDEs 
     * and build tools and may contain spaces, special characters, and even emoji.
     * 
	 */
	@Test
	@DisplayName("When length is null, throw a NullPointerException.")
	public void testNullPointerException() {
		System.out.println("    Testing whether a NullPointerException will be thrown.");
		
		String strWord = null;
		
		assertThrows(NullPointerException.class
				, () -> {
				     strWord.length();	
				  }
				, "Testing for a NullPointerException"
				);
	}
	
	@Test
	public void testNoNullPointerException() {
		String strWord = "abcd";
		
		assertDoesNotThrow(
				() -> {
					strWord.length();
				}
				, "Testing that no NullPointerException will be thrown."
				);
	}

}
