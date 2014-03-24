/**
 * MordorFrameBuilds.java
 */
package team.uninter.mordorq.skeleton;

import team.uninter.mordorq.gamespace.*;
/**
 * Implements the simulation of how the container frame builds up
 * the <code>Scene</code> contained and managed by it.
 * <p>
 * Builds on the singleton pattern, that provides only one
 * instance of the class, moreover it uses lazy initialization
 * to preserve resources.
 * 
 * @author Imre Szekeres
 * @version "%I%, %G%"
 */
public class MordorFrameBuilds implements Simulatable{
	
	private static Object obj = new Object();
	private static volatile MordorFrameBuilds instance = null;
	private static final String SIMULATION_FILE_PATH = "resources/descriptors/simuframed.txt";
	
	/**
	 * Provides that only in this class can the constructor
	 * be called thus the instance be instantiated.
	 * */
	protected MordorFrameBuilds(){	}
	
	/**
	 * Starts the simulation of how a MordorFrame is created/instantiated
	 * with the test/simulation configurations.
	 * 
	 * @throws Exception when the given file does not exist.
	 * */
	@Override
	public void simulate() throws Exception{
		//TODO:
		System.out.println("MordorFrame builds the scene...");
		MordorFrame.newInstance(SIMULATION_FILE_PATH);
		System.out.println("build finished...");
	}
	
	/**
	 * Instantiates the singleton class on-demand and also in a thread-safe way.
	 * 
	 * @return the instantiated instance of this class.
	 * */
	public static MordorFrameBuilds getInstance(){
		if(instance == null){
			synchronized(obj){
				if(instance == null) instance = new MordorFrameBuilds();
			}
		}
		return instance;
	}
}