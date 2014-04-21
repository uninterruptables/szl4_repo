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
	LineToFileTestSuite.class,
	PrototypeCommandTest.class
})
@SuppressWarnings("all")
public class StandardPrototypeLayerTestSuite {

	public static final String CONFIG_HOME = "src/log4j.properties";
	public static final String PROJECT_HOME = 
					"/media/CloudShell/mymedia/repositories/git/szl4_repo/szl4_project_1";
	
	@BeforeClass
	public static void configureLoggers(){
		BasicConfigurator.configure();
	}
}
