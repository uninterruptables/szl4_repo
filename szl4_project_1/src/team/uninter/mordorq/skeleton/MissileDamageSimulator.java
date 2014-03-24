/**
 * MissileDamageSimulator.java
 */
package team.uninter.mordorq.skeleton;

import team.uninter.mordorq.gamespace.*;

import java.io.IOException;
import java.util.*;
/**
 * Responsible for simulating how the <code>Missile</code> truly operates on reaching
 * and damaging a target.
 * 
 * @author Imre Szekeres
 * @version "%I%, %G%"
 * @see Missile
 * @see Tower
 * @see EnemyTroop
 * @see MordorFrame
 * @see Scene
 */
public class MissileDamageSimulator implements Simulatable {

	private static volatile MissileDamageSimulator instance = null;
	private static Object syncObject = new Object();
	
	/**
	 * No-arg constructor enforcing the use of the Factory method for getting
	 * the instance of the class.
	 * */
	protected MissileDamageSimulator(){}
	
	/**
	 * Factory method for lazy instantiating in a thread-safe way the only available instance of the
	 * <code>MissileDamageSimulator</code> class.
	 * 
	 * @return the instance
	 * */
	public static MissileDamageSimulator getInstance(){
		if(instance == null){
			synchronized(syncObject){
				if(instance == null) instance = new MissileDamageSimulator();
			}
		}
		return instance;
	}
	
	/**
	 * Constructs and conducts the simulation of the moving and damaging
	 * of an instance of the <code>Missile</code> class.
	 * @throws IOException 
	 * */
	@Override
	public void simulate() throws IOException{
		System.out.println("MissileDamageSimulator is simulating..");
		MordorFrame frame = MordorFrame.newInstance("resources/descriptors/missiledd.txt");
		Tower tower = new BasicTower(10, 10);
		EnemyTroop troop = new Elf(30, 30);
		List<TerrainGrid> grids = frame.getScene().getGrids();
	    frame.getScene().place(tower, grids.get(1));
	    ((RoadGrid)grids.get(grids.size() - 1)).notifyAllWith(troop);
	    
	    while(tower.isActive()){
	    	tower.controlIt();
	    }
	    frame.getScene().rewardUser(troop.getReward());
	    System.out.println("MissileDamageSimulator finished the simulation..");
	}
}