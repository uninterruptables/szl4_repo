/**
 * StandardPrototypeLayerTestSuite.java
 */
package team.uninter.mordorq.prototype;

import org.apache.log4j.BasicConfigurator;
import org.junit.runners.*;
import org.junit.runner.*;
import org.junit.*;
/**
 * 
 * @author Imre Szekeres
 * @version "%I%, %G%"
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	LineToFileTestSuite.class
})
@SuppressWarnings("all")
public class StandardPrototypeLayerTestSuite {

	@BeforeClass
	public static void configureLoggers(){
		BasicConfigurator.configure();
	}
}
