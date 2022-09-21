package main.course.assertionTests;

import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.Test;

public class PerformTest {
	
	/**
	 * If the execution takes more than the specified duration the test will fail.
	 * 
	 */
	@Test
	public void perfomanceTest() {
		assertTimeout(Duration.ofSeconds(5)
				, () -> {
					for (int i = 0; i <1000_000; i++) {
						int j = i;
						// Uncomment here and the test will fail.
//						System.out.println(j);
					};
				}
				
				);
	}

}
