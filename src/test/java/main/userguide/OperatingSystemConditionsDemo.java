package main.userguide;

import static org.junit.jupiter.api.condition.JRE.JAVA_10;
import static org.junit.jupiter.api.condition.JRE.JAVA_8;
import static org.junit.jupiter.api.condition.JRE.JAVA_9;
import static org.junit.jupiter.api.condition.OS.LINUX;
import static org.junit.jupiter.api.condition.OS.MAC;
import static org.junit.jupiter.api.condition.OS.WINDOWS;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;

/**
 * A container or test may be enabled or disabled on a particular operating system <br>
 * via the @EnabledOnOs and @DisabledOnOs annotations. <br>
 * <br>
 * So in the situation below the following test method will not be executed: <br>
 * - public void notOnMacOs(TestInfo testInfo)
 * 
 * @author rkremers
 *
 */
public class OperatingSystemConditionsDemo {
	
	@Test
	@EnabledOnOs(MAC)
	void onlyOnMacOs(TestInfo testInfo) {
	    // ...
		System.out.println( testInfo.getDisplayName());
	}

	@TestOnMac
	void testOnMac(TestInfo testInfo) {
	    // ...
		System.out.println( testInfo.getDisplayName());
	}
	
	@Test
	@DisabledOnOs(MAC)
	public void notOnMacOs(TestInfo testInfo) {
		System.out.println(testInfo.getDisplayName());
	}

	@Test
	@EnabledOnOs({ LINUX, MAC })
	void onLinuxOrMac(TestInfo testInfo) {
	    // ...
		System.out.println( testInfo.getDisplayName());
	}

	@Test
	@DisabledOnOs(WINDOWS)
	void notOnWindows(TestInfo testInfo) {
	    // ...
		System.out.println( testInfo.getDisplayName());
	}

	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	@Test
	@EnabledOnOs(MAC)
	@interface TestOnMac {
	}
	
	@Test
	@EnabledOnJre(JAVA_8)
	void onlyOnJava8() {
	    // ...
	}

	@Test
	@EnabledOnJre({ JAVA_9, JAVA_10 })
	void onJava9Or10() {
	    // ...
	}

	@Test
	@DisabledOnJre(JAVA_9)
	void notOnJava9() {
	    // ...
	}
	
	@Test
	@DisabledOnJre(JAVA_8)
	void notOnJava8() {
	    // ...
	}
	
	@Test
	@EnabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
	void onlyOnStagingServer() {
	    // ...
	}

	@Test
	@DisabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*")
	void notOnDeveloperWorkstation() {
	    // ...
	}

}
