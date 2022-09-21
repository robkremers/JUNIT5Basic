package main.tagtest.testclasses;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class ClassTest {

	@Test
	@Tag("production")
	public void testCaseC(TestInfo testInfo) {
		System.out.println(testInfo.getDisplayName());
	}
}
