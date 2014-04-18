/**
 * PrototypeCommandTest.java
 */
package team.uninter.mordorq.prototype;

import org.junit.runners.Parameterized.Parameters;
import team.uninter.mordorq.ApplicationContext;

import org.junit.runners.Parameterized;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import java.io.FileInputStream;
import org.apache.log4j.Logger;
import java.io.BufferedReader;
import org.junit.BeforeClass;
import java.io.IOException;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.util.Collection;
import java.util.Arrays;
/**
 * 
 * @author Imre Szekeres
 * @version "%I%, %G%"
 */
@RunWith(Parameterized.class)
public class PrototypeCommandTest {

	public static final String RSC_HOME = "resources/test/protocomm";
	
	private static Prototype proto;
	private static Logger logger;
	
	private BufferedReader sourceReader;
	private BufferedReader etalonReader;
	private String commandString;
	private String sourceFile;
	private String etalonFile;
	private int testCase;
	
	
	public PrototypeCommandTest(String commandString, String sourceFile, String etalonFile, int testCase) {
		super();
		this.commandString = commandString;
		this.sourceFile = sourceFile;
		this.etalonFile = etalonFile;
		this.testCase = testCase;
		
		this.sourceReader = null;
		this.etalonReader = null;
		
		logger.debug("sourceFile: "+this.sourceFile);
		logger.debug("etalonFile: "+this.etalonFile);
	}
	
	
	@BeforeClass
	public static void setup(){
		logger = Logger.getLogger(PrototypeCommandTest.class);
		proto = new Prototype();
		logger.debug("setup completed");
		ApplicationContext.bind("proto:/test/commands/log/CommandsLogger", logger);
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		// 			commandString		-		  sourceFile	-	 etalonFile	  -	 	testCase
		Object[][] data = {{
			"loadCommands "+RSC_HOME+"/ins/map.txt\ngetMapinfo",   /* command   */ 
			RSC_HOME+"/outs/test1_src.txt",		 				  /*  srcFile  */
			RSC_HOME+"/etals/test1_etal.txt",                    /*   etalon  */
			1 }								                    /*    testC  */
		};
		return Arrays.asList(data);
	}

	@Before
	public void openReaders() throws IOException {
		this.sourceReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(sourceFile)));
		this.etalonReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(etalonFile)));
	}
	
	@Test
	public void testCase(){
		logger.info("test-case"+testCase+" started..");
		
		try{
			proto.parseCommand(new String[]{"startFileWrite", sourceFile});
			logger.debug("writing to "+sourceFile+"..");
			for(String command : commandString.split("\n")){
				logger.debug("executing: "+command);
				proto.parseCommand(command.split(" "));
			}
			proto.parseCommand(new String[]{"endFileWrite"});
			logger.debug("end of file-write..");
			
			logger.info("starting diff-against in test-case"+testCase);
			
			String sourceLine, etalonLine;
			while((sourceLine = sourceReader.readLine()) != null
					&& (etalonLine = etalonReader.readLine()) != null){
				assertEquals(sourceLine.trim(), etalonLine.trim());
				logger.debug("<output: "+etalonLine+"> considered OK!");
			}
			logger.debug("end of diff-against..");
			logger.info("test-case"+testCase+" succeded..");
		}catch(Exception e){
			logger.error("Exception in test-case"+testCase+" - "+e.getClass()+": "+e.getMessage());
			logger.error("--------------------------------------------------------");
			for(StackTraceElement te : e.getStackTrace())
				logger.error(te.toString());
			logger.error("--------------------------------------------------------");
			logger.info("test-case"+testCase+" failed..");
			fail();
		}
	}
	
	@After
	public void closeReaders() throws IOException {
		if(sourceReader != null) sourceReader.close();
		if(etalonReader != null) etalonReader.close();
	}
}
