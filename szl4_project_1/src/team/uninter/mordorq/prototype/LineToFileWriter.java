/**
 * ConsoleToFileWriter.java
 */
package team.uninter.mordorq.prototype;

import java.io.*;
/**
 * Responsible to write given content (in lines) to the specified file.
 * 
 * @author Imre Szekeres
 * @version "%I%, %G%"
 */
public class LineToFileWriter {

	private PrintWriter writer;
	
	/**
	 * Constructs a new <code>LineToFileWriter</code> instance that
	 * writes to the given file.
	 * 
	 * @param filePath <code>String</code> representation of the file
	 * @throws IOException if errors occur in accessing the file given 
	 *          as a file path
	 * @see java.io.PrintWriter
	 * @see java.io.FileOutputStream
	 * @see java.io.IOException
	 * */
	public LineToFileWriter(String filePath) throws IOException {
	  writer = new PrintWriter(new FileOutputStream(filePath));
	}
	
	/**
	 * Writes one line of string to the file with which this <code>LineToFileWriter</code>
	 * instance has been initialized with.
	 * 
	 * @param line the line thats about to be written to the file
	 * @throws IOException if the stream is closed or some greater error occurred
	 * @see java.io.PrintWriter#println(java.lang.String)
	 * */
	public void write(String line) throws IOException {
		try{
			writer.println(line);
		}catch(Exception e){
			throw new IOException("Stream is already closed", e);
		}
	}
	
	/**
	 * Writes an array of <code>String</code> as one line with the elements 
	 * separated by the given separator.
	 * 
	 * @param parts
	 * @param separator
	 * */
	public void write(String[] parts, String separator) throws IOException {
		StringBuffer buffer = new StringBuffer();
		buffer.append(parts[0]);
		for(int i = 1; i < parts.length; i++) buffer.append(separator+parts[i]);
		write(buffer.toString().trim());
	}
	
	/**
	 * Closes the steam permanently.
	 * 
	 * @see java.io.PrintWriter#close()
	 * */
	public void close() {
		writer.close();
		writer = null;
	}
	
	/**
	 * Checks if the stream is still open.
	 * 
	 * @return true only if the stream has not been closed yet.
	 * */
	public boolean isOpen() {
		return writer != null;
	}
}