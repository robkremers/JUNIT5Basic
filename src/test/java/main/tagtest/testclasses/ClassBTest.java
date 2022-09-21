package main.tagtest.testclasses;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class ClassBTest {

	@Test
	@Tag("development")
	public void testCaseB(TestInfo testInfo) {
		System.out.println(testInfo.getDisplayName());
	}
	
}
