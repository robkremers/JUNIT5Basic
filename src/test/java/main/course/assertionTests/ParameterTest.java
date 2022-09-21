package main.course.assertionTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import main.example.Book;

/**
 * 
 * In the JUnit resultoverview per parameter the specific results will be shown.
 * So in the case below when the method is run as JUnit test 5 results will be
 * visible.
 * 
 * Unix: [INFO] Running main.basicTests.ParameterTest [ERROR] Tests run: 5,
 * Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 0.082 s <<< FAILURE! - in
 * main.basicTests.ParameterTest [ERROR] lenghtGreaterThanZero{String}[2] Time
 * elapsed: 0.007 s <<< FAILURE! org.opentest4j.AssertionFailedError: expected:
 * <true> but was: <false> at
 * main.basicTests.ParameterTest.lenghtGreaterThanZero(ParameterTest.java:12)
 * 
 * Actually: The ParameterizedTest is responsible for providing a stream of data
 * to be tested.
 * 
 * @author rkremers
 *
 */
@TestMethodOrder(OrderAnnotation.class)
public class ParameterTest {

	private enum UserStatus {
		PENDING, ACTIVE, INACTIVE, DELETED
	}

	@ParameterizedTest(name = "String {0} is expected to have a larger length than 0.")
//	@ValueSource(strings = {"ABCD", "", "ABC", "A", "DEF"})
	@ValueSource(strings = { "ABCD", "ABC", "A", "DEF" })
	@Order(value = 0)
	public void lenghtGreaterThanZero(String testString) {
		assertTrue(testString.length() > 0);
	}

	/**
	 * 
	 * In this situation (@CsvSource) "," would cause a NullPointerException. Here:
	 * "'', ''" would mean: two empty Strings. This can be processed and will return
	 * 'true'.
	 * 
	 * @param word
	 * @param capitalizedWord
	 */
	@ParameterizedTest
	@CsvSource(value = { "abcd, ABCD", "abc, ABC", "abcdefg, ABCDEFG", "'',''" })
	@Order(value = 1)
	public void uppercaseTest(String word, String capitalizedWord) {
		assertEquals(capitalizedWord, word.toUpperCase());
	}

	@ParameterizedTest(name = "String {0} is expected to have length {1}.")
	@CsvSource(value = { "abcd, 4", "abc, 3", "abcdefg, 7" })
	@Order(value = 2)
	public void stringLengthTest(String word, int expectedLength) {
		assertEquals(expectedLength, word.length());
	}

	/**
	 * Now instead of the default delimiter ',' the delimiter ':' is used.
	 * 
	 */

	@ParameterizedTest(name = "{0} lowercase should equal {1} lowercase.")
	@CsvSource(value = { "Java:java", "Rob:rob", "Weirdo:WEIRDO" }, delimiter = ':')
	@Order(value = 3)
	public void stringLowerCaseTest(String input, String expected) {
		assertEquals(expected.toLowerCase(), input.toLowerCase());
	}

	@DisplayName(value = "Test with enum UserStatus")
	@ParameterizedTest(name = "{index} => userstatus = ''{0}''")
	@EnumSource(UserStatus.class)
	void testUserStatus(Enum<?> userStatus) {
		assertNotNull(userStatus);
	}

	@DisplayName(value = "Test with enum UserStatus pending or active")
	@ParameterizedTest(name = "{index} => userstatus = ''{0}''")
	@EnumSource(value = UserStatus.class, names = { "PENDING", "ACTIVE" })
	void testUserStatusActive(Enum<?> userStatus) {
		assertNotNull(userStatus);
	}

	/**
	 * 
	 * Purpose of the @MethodSource: A Stream will return the input for the test
	 * method. An Argument.argument contains an array of instances of class Object.
	 * In the Stream definition mocking can be used.
	 * 
	 * Source: -
	 * https://junit.org/junit5/docs/current/api/org/junit/jupiter/params/provider/Arguments.html
	 * 
	 * For more really intricate examples see: -
	 * https://www.programcreek.com/java-api-examples/index.php?api=org.junit.jupiter.params.provider.Arguments
	 * - Example 3: use of mocking.
	 * 
	 * So this means that a Stream
	 * 
	 * @return Stream of arguments
	 */
	static Stream<Arguments> stringIntAndListProvider() {
		return Stream.of(Arguments.arguments("apple", 1, Arrays.asList("a", "b")),
				Arguments.arguments("lemon", 2, Arrays.asList("x", "y")));
	}

	@ParameterizedTest
	@MethodSource("stringIntAndListProvider")
	void testWithMultiArgMethodSource(String str, int num, List<String> list) {
		assertEquals(5, str.length());
		assertTrue(num >= 1 && num <= 2);
		assertEquals(2, list.size());
	}

	/**
	 * <h2>Argument conversion</h2>
	 * 
	 * <p>
	 * Fallback String-to-Object Conversion
	 * </p>
	 * <p>
	 * In addition to implicit conversion from strings to the target types listed in
	 * the above table, JUnit Jupiter also provides a fallback mechanism for
	 * automatic conversion from a String to a given target type if the target type
	 * declares exactly one suitable factory method or a factory constructor as
	 * defined below.
	 *
	 * <blockquote>
	 * <p>
	 * <li>factory method: <br>
	 * a non-private, static method declared in the target type that accepts a
	 * single String argument and returns an instance of the target type. The name
	 * of the method can be arbitrary and need not follow any particular convention.
	 * </li>
	 * </p>
	 * 
	 * <p>
	 * <li>factory constructor: <br>
	 * a non-private constructor in the target type that accepts a single String
	 * argument. Note that the target type must be declared as either a top-level
	 * class or as a static nested class.</li>
	 * </p>
	 * </p>
	 * </blockquote>
	 * 
	 * @param book
	 */
	@ParameterizedTest
	@ValueSource(strings = "42 Cats")
	void testWithImplicitFallbackArgumentConversion(Book book) {
		assertEquals("42 Cats", book.getTitle());
	}
}
