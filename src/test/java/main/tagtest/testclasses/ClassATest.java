package main.tagtest.testclasses;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class ClassATest {

	@Test
	@Tag("development")
	@Tag("production")
	public void testCaseA(TestInfo testInfo) {
		System.out.println(testInfo.getDisplayName());
	}
}
