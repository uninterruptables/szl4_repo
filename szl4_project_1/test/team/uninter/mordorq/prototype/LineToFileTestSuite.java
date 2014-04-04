/**
 * LineToFileTestSuite.java
 */
package team.uninter.mordorq.prototype;

import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import org.junit.runners.*;
import org.apache.log4j.*;
import org.junit.runner.*;
import org.junit.*;
import java.util.*;
import java.io.*;
/**
 * 
 * @author Imre Szekeres
 * @version "%I%, %G%"
 */
@RunWith(Parameterized.class)
public class LineToFileTestSuite {

	private static Logger logger;
	
	private LineToFileWriter writer;
	private BufferedReader reader;
	private String separator;
	private String[] command;
	private String filePath;
	
	public LineToFileTestSuite(String filePath, String command, String separator){
		this.filePath = filePath;
		this.separator = separator;
		this.command = command.split(separator);
	}
	
	
	@Parameters
	public static Collection<Object[]> data(){
		Object[][] data = new Object[][]{
				{"resources/test/line_to_file/inout1.txt", "build-tree as animation", " "},
				{"resources/test/line_to_file/inout2.txt", "make;me;happy;please", ";"}
		};
		return Arrays.asList(data);
	}
	
	@BeforeClass
	public static void setupLogger(){
		logger = Logger.getLogger(LineToFileTestSuite.class);
	}
	
	@Before
	public void setup(){
		try{
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
			writer = new LineToFileWriter(filePath);
		}catch(IOException e){
			logger.error("io error: "+e.getMessage());
		}
	}
	
	@After
	public void teardown(){
		try{
			if(writer.isOpen()) writer.close();
			reader.close();
		}catch(Exception e){
			logger.error("error in teardown: "+e.getMessage());
		}
	}
	
	
	@Test
	public void testCase1(){
		logger.info("line-to-file test-case1: begin");
		
		StringBuffer inBuffer = new StringBuffer();
		StringBuffer outBuffer = new StringBuffer();
		
		String line = "";
		line += command[0];
		for(int i = 1; i < command.length; i++) line += separator+command[i];
		outBuffer.append(line.trim() + '\n');
		
		logger.info("outBuffer: "+outBuffer.toString());
		
		try{
			writer.write(command, separator);
			writer.close();
			while((line = reader.readLine()) != null) {
				inBuffer.append(line + '\n');
				logger.info("inBuffer: "+inBuffer.toString());
			}
		}catch(Exception e){
			logger.error("error in testcase1: "+e.getMessage());
			fail();
		}
		
		assertEquals(outBuffer.toString().trim(), inBuffer.toString().trim());
		
		logger.info("line-to-file test-case1: end...");
	}
}
