/**
 * SkeletonMain.java
 */
package team.uninter.mordorq.core;


import team.uninter.mordorq.ApplicationContext;
import team.uninter.mordorq.skeleton.*;
import java.io.*;
/**
 * The main class running the CLI of the Skeleton project.
 * 
 * @author Imre Szekeres
 * @version "%I%, %G%"
 * @see Skeleton
 * @see ApplicationContext
 */
public class SkeletonMain {

	/**
	 * The main method starting the real skeleton application, but before that
	 * it adds the newly created <code>Skeleton</code> instance to the 
	 * <code>ApplicationContext</code>.
	 * 
	 * @param args through which the run of the application could be configured.
	 */
	public static void main(String[] args) {
		try{
			Skeleton skeleton = new Skeleton();
			ApplicationContext.bind("skeleton", skeleton);
			skeleton.run();
		}catch(IOException e){
			System.out.println("in skeleton main: "+e.getClass().getName()+": "+e.getMessage());
		}
	}
}
