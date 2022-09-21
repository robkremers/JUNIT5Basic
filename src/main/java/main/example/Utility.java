package main.example;

import java.util.Arrays;
import java.util.List;

/**
 * <p>Used in examples for lifecycle testing.</p>
 * <p>
 * Source:
 * <li>https://www.concretepage.com/testing/junit-5/junit-5-beforeall-and-afterall-example</li>
 * </p>
 * <p>Provides some functionality for test purposes.</p>
 * 
 * @author rkremers
 *
 */
public class Utility {
	   List<String> allUsers = Arrays.asList("Mahesh", "Ram", "Krishn", "Arjun", "Bheem");	
	   public long multiplyNumbers(int num1, int num2) {
		  return num1 * num2;
	   }
	   public long addNumbers(int num1, int num2) {
		  return num1 + num2;
	   }   
	   public boolean isUserAvailable(String userName) {
		  return allUsers.contains(userName); 
	   }
	}
