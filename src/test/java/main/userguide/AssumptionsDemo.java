package main.userguide;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import main.example.Calculator;

/**
 * <p>org.junit.jupiter.api.Assumptions</p>
 * <p>
 * Assumptions is a collection of utility methods that support conditional test execution based on assumptions. <br>
 * In direct contrast to failed assertions, failed assumptions do not result in a test failure; rather, <br>
 * a failed assumption results in a test being aborted. <br>
 * <br>
 * <b>Assumptions are typically used whenever it does not make sense to continue execution of a given test method</b><br>
 * — for example, if the test depends on something that does not exist in the current runtime environment.
 * </p>
 * 
 * @author rkremers
 *
 */
class AssumptionsDemo {

    private final Calculator calculator = new Calculator();

    /**
     * For the record: the system environment variable ENV == null in this case.
     * 
     * @param testInfo
     */
    @Test
    void testOnlyOnCiServer(TestInfo testInfo) {
    	System.out.println(testInfo.getDisplayName() + ": " + System.getenv("ENV"));
    	System.out.println(testInfo.getDisplayName() + "LOGNAME: " + System.getenv("LOGNAME"));
        assumeTrue("CI".equals(System.getenv("ENV")));
        // remainder of test
    }

    @Test
    void testOnlyOnDeveloperWorkstation() {
        assumeTrue("DEV".equals(System.getenv("ENV")),
            () -> "Aborting test: not on developer workstation");
        // remainder of test
    }

    @Test
    void testInAllEnvironments() {
        assumingThat("CI".equals(System.getenv("ENV")),
            () -> {
                // perform these assertions only on the CI server
                assertEquals(2, calculator.divide(4, 2));
            });

        // perform these assertions in all environments
        assertEquals(42, calculator.multiply(6, 7));
    }

}
