package team.uninter.mordorq.gamespace;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

/**
 * *Responsible to ensure a unified class for the area units on the gamespace
 * 
 * @author Soma
 *
 */
@SuppressWarnings("serial")
abstract public class TerrainGrid extends GameObject {

	/**
	 * utility - helps the path finder algoritm to lead the troop to the
	 * mountain of doom
	 * 
	 * neighbours - neighbour Terraingrids of the given one
	 */
	protected int utility;
	protected Map<Neighbour, TerrainGrid> neighbours;
	protected int id;

	/**
	 * Contrructor with position parameters
	 * 
	 * @param x
	 * @param y
	 */
	public TerrainGrid(int x, int y) {
		super(x, y);
		neighbours = new HashMap<Neighbour, TerrainGrid>();
	}

	public TerrainGrid(int x, int y, int utility, int id) {
		super(x, y);
		this.utility = utility;
		this.id = id;
		neighbours = new HashMap<Neighbour, TerrainGrid>();
	}

	/**
	 * Contructor with utility parameter
	 * 
	 * @param utility
	 */
	public TerrainGrid(int utility) {
		this.utility = utility;
		neighbours = new HashMap<Neighbour, TerrainGrid>();
	}

	/**
	 * Contructor without parameter
	 */
	public TerrainGrid() {
		neighbours = new HashMap<Neighbour, TerrainGrid>();
	};

	/**
	 * Gives back a boolean value, depends on this grid is in the range of the
	 * given tower's radius
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
	public final int getUtility() {
		return this.utility;
	}

	public final int getId() {
		return this.id;
	}

	public final void setUtility(int utility) {
		this.utility = utility;
	}

	/**
	 * Gives back the grids availability for a trap, depends on what kind of
	 * grid this is. The subclasses specify the value.
	 * 
	 * @param trap
	 * @return
	 */
	abstract public boolean isAvailableFor(Trap trap);

	/**
	 * Gives back the grids availability for a tower, depends on what kind of
	 * grid this is. The subclasses specify the value.
	 * 
	 * @param trap
	 * @return
	 */
	abstract public boolean isAvailableFor(Tower tower);

	/**
	 * Gives back the grids availability for a barricade, depends on what kind
	 * of grid this is. The subclasses specify the value.
	 * 
	 * @param trap
	 * @return
	 */
	abstract public boolean isAvailableFor(Barricade barricade);

	/**
	 * Gives back the grids availability for a <code>Rune</code>, depends on
	 * what kind of grid this is. The subclasses specify the value.
	 * 
	 * @param rune
	 * @return
	 */
	abstract public boolean isAvailableFor(Rune rune);

	/**
	 * Gives back the grids availability for a magic, but it's always true.
	 * 
	 * @param tower
	 * @return
	 */
	public final boolean isAvailableFor(Magic magic) {
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
	public final TerrainGrid get(Neighbour neighbour) {
		TerrainGrid grid = neighbours.get(neighbour);
		return grid;
	}

	/**
	 * Sets the neighbour grid in the given direction
	 * 
	 * @param neighbour
	 * @param grid
	 */
	public final void set(Neighbour neighbour, TerrainGrid grid) {
		neighbours.put(neighbour, grid);
	}

	public abstract void drawContent(Graphics g);
}
