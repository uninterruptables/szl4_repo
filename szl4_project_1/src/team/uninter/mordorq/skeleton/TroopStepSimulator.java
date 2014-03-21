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
 */
public class TroopStepSimulator extends  ConfigurableSimulator {

	private static TroopStepSimulator instance = null;
	private static Object syncObject = new Object();
	
	protected TroopStepSimulator(){
		super.configuration = TroopStepAlias.DEFAULT;
	}
		
	public static TroopStepSimulator getInstance(){
		if(instance == null){
			synchronized(syncObject){
				if(instance == null) instance = new TroopStepSimulator();
			}
		}
		return instance;
	}
	
	@Override
	public void simulate() throws Exception{
		EnemyTroop human = new Human();
		RoadGrid initialGrid = new RoadGrid(7);
		initialGrid.setVulnerable(human);
		human.setCurrentGrid(initialGrid);
		
		RoadGrid grid2 = new RoadGrid(8);
		initialGrid.set(Neighbour.EAST, grid2);
		grid2.set(Neighbour.WEST, initialGrid);
		
		if(configuration.equals(TroopStepAlias.TRAP_AFFECTS)) 			grid2.setTrap(new PoisonousTrap());
		else if(configuration.equals(TroopStepAlias.DAMAGES_MOUNTAIN)) grid2.setVulnerable(MountainOfDoom.getInstance());
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
	}
	
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
	
	public static enum TroopStepAlias implements ConfigurationAlias {
		DEFAULT, TRAP_AFFECTS, TOWER_FIRES, DAMAGES_MOUNTAIN
	}
}
