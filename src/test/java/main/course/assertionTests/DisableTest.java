package main.course.assertionTests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * The annotation @Disabled can be set at either the class level or at the method level.
 * Intended for the situation that a method / class should be temporarily disabled.
 * For permanent disabling either repair or remove the code.
 * 
 * @author rkremers
 *
 */
@Disabled
public class DisableTest {
	
	@Test 
//	@Disabled
	public void executeTest() {
	
		assertTrue(true);
	}

}
