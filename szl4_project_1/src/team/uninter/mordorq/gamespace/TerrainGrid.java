package team.uninter.mordorq.gamespace;

import java.util.HashMap;
import java.util.Map;

/**
 * *Responsible to ensure a unified
 * class for the area units on the gamespace 
 * 
 * @author Soma
 *
 */
@SuppressWarnings("serial")
abstract public class TerrainGrid extends GameObject{

	/**
	 * utility - helps the path finder algoritm to
	 * lead the troop to the mountain of doom
	 * 
	 * neighbours - neighbour Terraingrids of the given one
	 */
	protected int utility;
	protected Map<Neighbour,TerrainGrid> neighbours;
	
	/**
	 * Contrructor with position parameters
	 * 
	 * @param x
	 * @param y
	 */
	public TerrainGrid(int x, int y) {
		super(x, y);
		//TODO remove sysout
		System.out.println("TerrainGrid.TerrainGrid(x,y) called");		
		neighbours = new HashMap<Neighbour,TerrainGrid>();
		System.out.println("TerrainGrid.TerrainGrid(x,y) returned");
	}
	
	/**
	 * Contructor with utility parameter
	 * 
	 * @param utility
	 */
	public TerrainGrid(int utility) {
		//TODO remove sysout
		System.out.println("TerrainGrid.TerrainGrid(utility) called");	
		this.utility = utility;
		neighbours = new HashMap<Neighbour,TerrainGrid>();
		System.out.println("TerrainGrid.TerrainGrid(utility) returned");
	}
	
	/**
	 * Contructor without parameter
	 */
	public TerrainGrid(){
		//TODO remove sysout
		System.out.println("TerrainGrid.TerrainGrid() called");	
		neighbours = new HashMap<Neighbour,TerrainGrid>();
		System.out.println("TerrainGrid.TerrainGrid() returned");
	};
	
	/**
	 * Gives back a boolean value, depends on this
	 * grid is in the range of the given tower's radius
	 * 
	 * @param tower
	 * @return
	 */
	abstract public boolean isInRangeOf(Tower tower);
	
	/**
	 * Gives back the utility of the grid
	 * 
	 * @return
	 */
	public final int getUtility(){
		//TODO remove sysout
		System.out.println("TerrainGrid.getUtility() called");	
		System.out.println("TerrainGrid.getUtility() returned");
		return this.utility;
	}

	/**
	 * Gives back the grids availability for a trap,
	 * depends on what kind of grid this is. The subclasses specify the value.
	 * 
	 * @param trap
	 * @return
	 */
	abstract public boolean isAvailableFor(Trap trap);
	
	
	/**
	 * Gives back the grids availability for a tower,
	 * depends on what kind of grid this is. The subclasses specify the value.
	 * 
	 * @param trap
	 * @return
	 */
	abstract public boolean isAvailableFor(Tower tower);
	
	
	/**
	 * Gives back the grids availability for a barricade,
	 * depends on what kind of grid this is. The subclasses specify the value.
	 * 
	 * @param trap
	 * @return
	 */
	abstract public boolean isAvailableFor(Barricade barricade);
	
	/**
	 * Gives back the grids availability for a magic, but it's
	 * always true.
	 * 
	 * @param tower
	 * @return
	 */
	public final boolean isAvailableFor(Magic magic){
		//TODO remove sysout
		System.out.println("TerrainGrid isAvailableFor(Magic) called");
		System.out.println("TerrainGrid isAvailableFor(Magic) returned");
		return true;
	}
	
	/**
	 * Gives back the tower/trap/barricade, what's on the grid
	 * 
	 * @return
	 */
	abstract public InjectionTarget getInjectionTarget();
	
	/**
	 * Gives back the neighbour grid in the given direction
	 * 
	 * @param neighbour
	 * @return
	 */
	public final TerrainGrid get(Neighbour neighbour){
		//TODO remove sysout
		System.out.println("TerrainGrid get(Neighbour neightbour) called");
		TerrainGrid grid = neighbours.get(neighbour);
		System.out.println("TerrainGrid get(Neighbour neightbour) returned");
		return grid;
	}
	
	/**
	 * Sets the neighbour grid in the given direction
	 * 
	 * @param neighbour
	 * @param grid
	 */
	public final  void set(Neighbour neighbour, TerrainGrid grid){
		//TODO remove sysout
		System.out.println("TerrainGrid set(Neighbour neighbour, TerrainGrid grid) called");
		neighbours.put(neighbour, grid);
		System.out.println("TerrainGrid set(Neighbour neighbour, TerrainGrid grid) returned");
	}
}
