package main.userguide;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * <p>
 * In the following example tests are executed with the lowest value of the order first.
 * </p>
 * <p>
 * Options:<br>
 * <li>Alphanumeric   : sorts test methods alphanumerically based on their names and formal parameter lists.</li>
 * <li>OrderAnnotation: sorts test methods numerically based on values specified via the @Order annotation.</li>
 * <li>Random         : orders test methods pseudo-randomly and supports configuration of a custom seed.</li>
 * </p>
 * 
 * @author rkremers
 *
 */
@TestMethodOrder(OrderAnnotation.class)
class OrderedTestsDemo {

    @Test
    @Order(3)
    void nullValues(TestInfo testInfo) {
        // perform assertions against null values
    	System.out.println(testInfo.getDisplayName() + " Order value = 3");
    }

    @Test
    @Order(2)
    void emptyValues(TestInfo testInfo) {
        // perform assertions against empty values
    	System.out.println(testInfo.getDisplayName() + " Order value = 2");
    }

    @Test
    @Order(1)
    void validValues(TestInfo testInfo) {
        // perform assertions against valid values
    	System.out.println(testInfo.getDisplayName() + " Order value = 1");
    }

}

