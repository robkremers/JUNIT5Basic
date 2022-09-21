package main.lifecycletest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import main.example.Utility;

public class LifeCycleTest implements LifecycleLoggerWithTestInstance {
	
    @Test
    @DisplayName("Add Test")
    void addTest() {
    	System.out.println("---Inside addTest---");
    	Utility utility = new Utility();
    	assertEquals(11, utility.addNumbers(5, 6), "6 + 5 will be 11");
    } 
}
