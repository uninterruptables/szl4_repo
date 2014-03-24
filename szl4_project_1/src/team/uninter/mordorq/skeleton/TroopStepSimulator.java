/**
 * TroopStepSimulator.java
 */
package team.uninter.mordorq.skeleton;

import team.uninter.mordorq.skeleton.signaling.*;
import team.uninter.mordorq.gamespace.*;
/**
 * Simulates different aspects of the stepping, moving mechanism of the <code>EnemyTroop</code> class.
 * Each and every aspect requires some modification than the others even though 
 * the basic structure of each scenario is the same. This made the need
 * of making this class configurable.
 * 
 * @author Imre Szekeres
 * @version "%I%, %G%"
 * @see EnemyTroop
 * @see Human
 * @see TerrainGrid
 * @see RoadGrid
 * @see GoundGrid
 * @see Tower
 * @see Trap
 * @see MountainOfDoom
 */
public class TroopStepSimulator extends  ConfigurableSimulator {

	private static volatile TroopStepSimulator instance = null;
	private static Object syncObject = new Object();
	
	/**
	 * Public constructor for setting the default configuration.
	 * */
	protected TroopStepSimulator(){
		super.configuration = TroopStepAlias.DEFAULT;
	}
		
	/**
	 * Factory method for creating the instance on-demand or getting
	 * the existing one.
	 * 
	 * @return the only <code>TroopStepSimulator</code> instance
	 * */
	public static TroopStepSimulator getInstance(){
		if(instance == null){
			synchronized(syncObject){
				if(instance == null) instance = new TroopStepSimulator();
			}
		}
		return instance;
	}
	
	/**
	 * Sets up the simulation environment according to the configuration set previously,
	 * then runs the simulation.
	 * 
	 * @throws Exception if some error occure (some precondition violation)
	 * */
	@Override
	public void simulate() throws Exception{
		System.out.println("TroopStepSimulator configuration: "+configuration.toString()+" is simulating..");
		EnemyTroop human = new Human();
		RoadGrid initialGrid = new RoadGrid(7);
		initialGrid.setVulnerable(human);
		human.setCurrentGrid(initialGrid);
		
		RoadGrid grid2 = new RoadGrid(8);
		initialGrid.set(Neighbour.EAST, grid2);
		grid2.set(Neighbour.WEST, initialGrid);
		
		if(configuration.equals(TroopStepAlias.TRAP_AFFECTS)) 			grid2.setTrap(new PoisonTrap());
		else if(configuration.equals(TroopStepAlias.DAMAGES_MOUNTAIN)) 
			grid2.setVulnerable(MountainOfDoom.getInstance(
							MordorFrame.newInstance("resources/descriptors/emptyd.txt").getScene()));
		else if(configuration.equals(TroopStepAlias.TOWER_FIRES)){
			GroundGrid ggrid0 = new GroundGrid();
			GroundGrid ggrid1 = new GroundGrid();
			GroundGrid ggrid2 = new GroundGrid();
			GroundGrid ggrid3 = new GroundGrid();
			
			ggrid0.set(Neighbour.EAST, ggrid1);
			ggrid0.set(Neighbour.SOUTH, ggrid2);
			ggrid1.set(Neighbour.WEST, ggrid0);
			ggrid1.set(Neighbour.SOUTH, ggrid3);
			ggrid2.set(Neighbour.NORTH, ggrid0);
			ggrid2.set(Neighbour.EAST, ggrid3);
			ggrid3.set(Neighbour.WEST, ggrid2);
			ggrid3.set(Neighbour.NORTH, ggrid1);
			
			ggrid2.set(Neighbour.SOUTH, grid2);
			grid2.set(Neighbour.NORTH, ggrid2);
			
			(new BasicTower()).castOn(ggrid0);
		}
		
		if(human.isActive()) human.controlIt();
		System.out.println("TroopStep-"+configuration.toString()+" simulation finished...");
	}
	
	/**
	 * Configures the  <code>TroopStepSimulator</code> instance for a simulation.
	 * The modification will be visible only in the next simulation.
	 * 
	 * @param  alias preferably a <code>TroopStepAlias</code> instance
	 * @throws UnsupportedConfigurationException in case the given instance is not a <code>TroopStepAlias</code>
	 * */
	@Override
	void configureFor(ConfigurationAlias alias) 
			throws UnsupportedConfigurationException {
		try{
			configuration = (TroopStepAlias)alias;
		}catch(ClassCastException e){
			throw new UnsupportedConfigurationException(
					alias.getClass()+" is not supported configuration for "+this.getClass().getName(), e);
		}
	}
	
	/**
	 * Published enumeration (containing aliases of each real configurations) of the available
	 * configurations of the <code>TroopStepSimulator</code> class.
	 * */
	public static enum TroopStepAlias implements ConfigurationAlias {
		DEFAULT, TRAP_AFFECTS, TOWER_FIRES, DAMAGES_MOUNTAIN
	}
}