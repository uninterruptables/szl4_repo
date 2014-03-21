/**
 * ConfigurableSimulator.java
 */
package team.uninter.mordorq.skeleton;

import team.uninter.mordorq.skeleton.signaling.*;

/**
 * Provides a standard interface for those simulations that require distinct
 * configurations upon which it is decided what simulation is created and run.
 * 
 * @author redcloud
 * @version "%I%, %G%"
 */
public abstract class ConfigurableSimulator implements Simulatable{

	protected ConfigurationAlias configuration;
	
	/**
	 * Sets the configuration for the given instance. Each and every subclass
	 * implements it to fit its configuration environment.
	 * 
	 * @throws UnsupportedConfigurationException when a configuration alias of another subclass is forced into this one
	 * */
	abstract void configureFor(ConfigurationAlias alias) throws UnsupportedConfigurationException;
	
	/**
	 * A standard interface each concrete ConfigurationSimulator implements
	 * for itself and uses it as a configuration base.
	 * */
	public static interface ConfigurationAlias {}
}
