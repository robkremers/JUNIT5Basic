package main.course.assertionTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * For all options with regards to the @RepeatedTest annotation see:
 * - https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/RepeatedTest.html
 * - https://junit.org/junit5/docs/current/user-guide/#writing-tests-repeated-tests
 * - https://www.baeldung.com/junit-5-repeated-test
 * 
 * - For the effects look into the JUnit tab in the IDE.
 * - When running mvn clean package test the effects will not be visible when expanding @RepeatedTest as in below
 *   examples.
 *   For this situation use logging with RepetitionInfo.
 * 
 * @author rkremers
 *
 */
public class RepeatTest {
	
	@BeforeEach
	public void beforeEachTest(TestInfo testInfo, RepetitionInfo repetitionInfo) {
//		System.out.println("Before Each Test");
		int currentRepetition = repetitionInfo.getCurrentRepetition();
        int totalRepetitions = repetitionInfo.getTotalRepetitions();
        String methodName = testInfo.getTestMethod().get().getName();
        
        System.out.format("About to execute repetition %d of %d for %s", currentRepetition, totalRepetitions, methodName);
	}
	
	@AfterEach
	public void afterEachTest() {
		System.out.println("After Each Test");
		System.out.println("=====================");
	}

	/********************** Test methods **************************************/
	@RepeatedTest(value = 5, name = RepeatedTest.SHORT_DISPLAY_NAME)
	void doesNotContainSubString(RepetitionInfo repetitionInfo, TestInfo testInfo) {
//	    System.out.println("Executing repeated test with short name");
	  
//	    assertEquals(2, Math.addExact(1, 1), "1 + 1 should equal 2");
	    assertFalse( "ABCDE".contains("hij"));
	}
	
	@RepeatedTest(value = 3, name = RepeatedTest.LONG_DISPLAY_NAME)
	void repeatedTestWithLongName() {
	    System.out.println("Executing repeated test with long name");
	  
	    assertEquals(2, Math.addExact(1, 1), "1 + 1 should equal 2");
	}
	
	@RepeatedTest(value = 3, name = "Custom name {currentRepetition}/{totalRepetitions}")
	void repeatedTestWithCustomDisplayName(TestInfo testInfo) {
	    assertEquals(2, Math.addExact(1, 1), "1 + 1 should equal 2");
	}
	
	
}
