package main.course.assertionTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MathTest {
	
	@Test
	public void testMathMin() {
		
		int nrOne = 5;
		int nrTwo = 45;
		int expectedMinimumValue = 5;
		assertEquals(expectedMinimumValue, Math.min(nrOne, nrTwo));
	}
	
	@Test
	public void testMathMax() {
		float nrOne = 4.5f;
		float nrTwo = 23.45f;
		
		float expectedMaximumValue = 23.45f;
		
		assertEquals(expectedMaximumValue, Math.max(nrOne, nrTwo));
	}
}
