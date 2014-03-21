/**
 * Simulatable.java
 */
package team.uninter.mordorq.skeleton;

/**
 * Represents a standard interface for subsystems that provide
 * some sort of simulating mechanisms.
 * 
 * @author Imre Szekeres
 * @version "%I%, %G%"
 */
public interface Simulatable {

	/**
	 * Standard interface for running a simulation through which
	 * some errors might occure.
	 * 
	 * @throws Exception signaling the error occurring during the simulation
	 * */
	void simulate() throws Exception;
}
