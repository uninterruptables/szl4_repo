/**
 * PrototypeCommandTest.java
 */
package team.uninter.mordorq.prototype;

import org.junit.runners.Parameterized.Parameters;
import team.uninter.mordorq.ApplicationContext;

import org.junit.runners.Parameterized;
import org.apache.log4j.FileAppender;
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
@SuppressWarnings("all")
public class PrototypeCommandTest {

	public static final String LOGFILE  = System.getProperty("user.dir")+"/resources/log/test/proto_command.log";
	public static final String RSC_HOME = "resources/test/protocomm"; 
	
	private static Prototype proto;
	private static Logger logger;
	
	private BufferedReader commandReader;
	private BufferedReader sourceReader;
	private BufferedReader etalonReader;
	private String commandFile;
	private String sourceFile;
	private String etalonFile;
	private int testCase;
	
	
	public PrototypeCommandTest(String commandFile, String sourceFile, 
													 String etalonFile, int testCase) {
		super();
		this.commandFile = commandFile;
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
		/*((FileAppender)logger.getAppender("proto_comm")).setFile(LOGFILE);*/
		proto = new Prototype();
		logger.debug("setup completed");
		ApplicationContext.bind("proto:/test/commands/log/CommandsLogger", logger);
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		/* 	    	   commandFile				-	  		 sourceFile			  -	     	  	etalonFile	   -    testCase     */
		Object[][] data = {
		  {  RSC_HOME+"/comm/0_scene_build.txt",   RSC_HOME+"/outs/test0_src.txt",  RSC_HOME+"/etals/test0_etal.txt",  0  },
		  {  RSC_HOME+"/comm/1_cast_twtrb.txt",    RSC_HOME+"/outs/test1_src.txt",  RSC_HOME+"/etals/test1_etal.txt",  1  },
		  {  RSC_HOME+"/comm/2_cancreate_.txt",    RSC_HOME+"/outs/test2_src.txt",  RSC_HOME+"/etals/test2_etal.txt",  2  },
		  {  RSC_HOME+"/comm/3_castmagic_.txt",    RSC_HOME+"/outs/test3_src.txt",  RSC_HOME+"/etals/test3_etal.txt",  3  },
		  {  RSC_HOME+"/comm/4_twtr_rune.txt",     RSC_HOME+"/outs/test4_src.txt",  RSC_HOME+"/etals/test4_etal.txt",  4  },
		  {  RSC_HOME+"/comm/5_troopsteps_.txt",   RSC_HOME+"/outs/test5_src.txt",  RSC_HOME+"/etals/test5_etal.txt",  5  },
		  {  RSC_HOME+"/comm/6_md_dies.txt",       RSC_HOME+"/outs/test6_src.txt",  RSC_HOME+"/etals/test6_etal.txt",  6  },
		  {  RSC_HOME+"/comm/7_enemy_tr.txt",      RSC_HOME+"/outs/test7_src.txt",  RSC_HOME+"/etals/test7_etal.txt",  7  },
		  {  RSC_HOME+"/comm/8_enemy_b.txt",       RSC_HOME+"/outs/test8_src.txt",  RSC_HOME+"/etals/test8_etal.txt",  8  },
		  {  RSC_HOME+"/comm/9_findpath_.txt",     RSC_HOME+"/outs/test9_src.txt",  RSC_HOME+"/etals/test9_etal.txt",  9  },
		  {  RSC_HOME+"/comm/10_findpath_av.txt",  RSC_HOME+"/outs/test10_src.txt", RSC_HOME+"/etals/test10_etal.txt", 10 },
		  {  RSC_HOME+"/comm/11_fog_.txt",         RSC_HOME+"/outs/test11_src.txt", RSC_HOME+"/etals/test11_etal.txt", 11 }
		};
		return Arrays.asList(data);
	}

	@Before
	public void openReaders() throws IOException {
		this.commandReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(commandFile)));
		this.sourceReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(sourceFile)));
		this.etalonReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(etalonFile)));
	}
	
	@Test
	public void testCase(){
		logger.info("test-case"+testCase+" started..");
		
		try{
			logger.debug("writing to "+sourceFile+"..");
			
			proto.parseCommand(new String[]{"startFileWrite", sourceFile});
			String commandLine;
			while((commandLine = commandReader.readLine()) != null){
				logger.debug("executing: "+commandLine);
				proto.parseCommand(commandLine.split(" "));
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
		if(commandReader != null) commandReader.close();
		if(sourceReader != null)  sourceReader.close();
		if(etalonReader != null)  etalonReader.close();
	}
}
