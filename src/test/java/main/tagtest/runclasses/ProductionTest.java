package main.tagtest.runclasses;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

/**
 * <p>
 * Source:
 * <li> https://howtodoinjava.com/junit5/junit-5-tag-annotation-example/ </li>
 * </p>
 * 
 * <p>
 * org.junit.platform.runner.JUnitPlatform: <br>
 * <li> Annotating a class with @RunWith(JUnitPlatform.class) allows it to be run 
 * with IDEs and build systems that support JUnit 4 but do not yet support the JUnit Platform directly.
 * </li>
 * 
 * </p>
 * 
 * @author rkremers
 *
 */
@RunWith(JUnitPlatform.class)
@SelectPackages( {"main.tagtest.testclasses"})
@IncludeTags("development")
public class ProductionTest {

}
