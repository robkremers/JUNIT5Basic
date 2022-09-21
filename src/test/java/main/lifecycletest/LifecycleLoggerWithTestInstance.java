package main.lifecycletest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * 
 * Source:
 * - https://www.concretepage.com/testing/junit-5/junit-5-beforeall-and-afterall-example
 * - https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-instance-lifecycle
 * 
 * We can use @BeforeAll and @AfterAll annotations with non-static methods (default methods) of 
 * interface using @TestInstance annotation. 
 * @TestInstance is a type-level annotation that is used to configure lifecycle of instances 
 * of annotated test class or test interface. @TestInstance works with following lifecycle mode.
 * 
 * Lifecycle.PER_METHOD: 
 * A new test instance will be created for each test method or test factory method. 
 * This means that the state of all class instance variables will be created again before executing each test method.
 * PER_METHOD mode is the default mode when @TestInstance has not explicitly declared on test class or test interface.
 * Lifecycle.PER_CLASS: 
 * A new test instance will be created once per test class.
 * So all test methods will use the same class instance variables. This may or may not be a problem. 
 * Advantages of PER_CLASS mode:
 * - We can use non-static @BeforeAll and @AfterAll methods. 
 * - Makes it possible to use @BeforeAll and @AfterAll methods in @Nested test classes.
 * 
 * In our example we will create a lifecycle logger interface annotated with @TestInstance 
 * with mode Lifecycle.PER_CLASS and 
 * we will create non-static @BeforeAll and @AfterAll methods as interface default methods. Find the example.
 * 
 * Note:
 * - If a test class or test interface is not annotated with @TestInstance, 
 *   JUnit Jupiter will use a default lifecycle mode.
 * - The default Lifecycle value is PER_METHOD.
 *   - This is explicitly set in src/test/resources/junit-platform.properties. If there is such a file.
 * 
 * @author rkremers
 *
 */
@TestInstance(Lifecycle.PER_CLASS)
public interface LifecycleLoggerWithTestInstance {
    @BeforeAll
    default void initAll() {
    	System.out.println("---Inside initAll---");
    }
    @BeforeEach
    default void init(TestInfo testInfo) {
    	System.out.println("Start..." + testInfo.getDisplayName());
    }	
    @AfterEach
    default void tearDown(TestInfo testInfo) {
    	System.out.println("Finished..." + testInfo.getDisplayName());
    } 
    @AfterAll
    default void tearDownAll() {
    	System.out.println("---Inside tearDownAll---");
    }    
} 
