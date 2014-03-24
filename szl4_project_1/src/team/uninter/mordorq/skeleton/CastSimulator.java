/**
 * CastSimulator.java
 */
package team.uninter.mordorq.skeleton;

import team.uninter.mordorq.skeleton.signaling.*;
import team.uninter.mordorq.gamespace.*;
/**
 * This class is responsible for simulating all distinct aspects of 
 * the casting (and injection) framework that allows identification of the
 * right cast/injection target(s).
 * <p>
 * <code>CastSimulator</code> constructs and manages the simulation space
 * according to the preset configuration.
 * 
 * @author Imre Szekeres
 * @version "%I%, %G%"
 * @see EnemyTroop
 * @see MordorFrame
 * @see ConfigurableSimulator
 * @see TerrainGrid
 * @see RoadGrid
 * @see GroundGrid
 * @see Trap
 * @see Tower
 * @see Nazghul
 * @see TrapRune
 * @see TowerRune
 * @see Scene
 */
public class CastSimulator extends ConfigurableSimulator{

	private static volatile CastSimulator instance = null;
	private static Object syncObject = new Object();
	
	/**
	 * Protected constructor setting the configuration to default.
	 * */
	protected CastSimulator() {
		configuration = CastAlias.MAGIC;
	}
	
	/**
	 * Factory method for aquiring the instance of the <code>CastSimulator</code> class
	 * in a thread-safe and lazy way.
	 * 
	 * @return the only instance of this class.
	 * */
	public static CastSimulator getInstance(){
		if(instance == null){
			synchronized(syncObject){
				if(instance == null) instance = new CastSimulator();
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
	public void simulate() throws Exception {
		System.out.println("CastSimulator configuration: "+configuration.toString()+" is simulating..");
		MordorFrame frame = MordorFrame.newInstance("resources/descriptors/emptyd.txt");
		Casted activeObject;
		TerrainGrid iniGrid = new RoadGrid(13);		
		
		if(configuration.equals(CastAlias.MAGIC)) activeObject = new Nazgul();
		else if(configuration.equals(CastAlias.TOWER_GROUND)){
			iniGrid = (frame = MordorFrame.newInstance("resources/descriptors/tower_groundd.txt")).getScene().getGrids().get(1);
			activeObject = new BasicTower();
		}
		else if(configuration.equals(CastAlias.TRAP_ROAD))	activeObject = new SlowDownTrap();
		else{
			activeObject = new PoisonTrapRune();
			if(configuration.equals(CastAlias.TRAPRUNE_TRAP)) (new SlowDownTrap()).castOn(iniGrid);
			else{
				iniGrid = (frame = MordorFrame.newInstance("resources/descriptors/tower_groundd.txt")).getScene().getGrids().get(1);
				(new BasicTower()).castOn(iniGrid);
			}
		}
		if(activeObject.canCastOn(iniGrid)){
			int mana = frame.getUserMana();
			if(mana - activeObject.getCost() >= 0){
				if(activeObject instanceof Magic){
					frame.getScene().cast((Magic)activeObject);
				}
				else frame.getScene().place(activeObject, iniGrid);
				frame.setUserMana(mana - activeObject.getCost());
			}
		}
		System.out.println("Cast-"+configuration.toString()+" simulation finished...");
	}
	
	/**
	 * Configures the  <code>CastSimulator</code> instance for a simulation.
	 * The modification will be visible only in the next simulation.
	 * 
	 * @param  alias preferably a <code>CastAlias</code> instance
	 * @throws UnsupportedConfigurationException in case the given instance is not a <code>CastAlias</code>
	 * */
	@Override
	void configureFor(ConfigurationAlias alias)
			throws UnsupportedConfigurationException {
		try{
			configuration = (CastAlias)alias;
		}catch(ClassCastException e){
			throw new UnsupportedConfigurationException(
					alias.getClass()+" is not supported configuration for "+this.getClass().getName(), e);
		}
		
	}
	
	/**
	 * Published enumeration (containing aliases of each real configurations) of the available
	 * configurations of the <code>CastSimulator</code> class.
	 * */
	public static enum CastAlias implements ConfigurationAlias{
		MAGIC, TRAPRUNE_TRAP, TRAPRUNE_TOWER, TOWER_GROUND, TRAP_ROAD
	}
}