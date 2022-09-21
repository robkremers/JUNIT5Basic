package main.userguide;

import static org.hamcrest.CoreMatchers.equalTo; 
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

import main.example.Calculator;

/**
 * 
 * Based on:
 * 		<dependency>
			<groupId>org.hamcrest</groupId>
			<artifactId>java-hamcrest</artifactId>
			<version>2.0.0.0</version>
			<scope>test</scope>
		</dependency>
 * 
 * @author rkremers
 *
 */
public class HamcrestAssertionsDemo {
	
    private final Calculator calculator = new Calculator();

    @Test
    void assertWithHamcrestMatcher() {
        assertThat(calculator.subtract(4, 1), is(equalTo(3)));
    }
}
