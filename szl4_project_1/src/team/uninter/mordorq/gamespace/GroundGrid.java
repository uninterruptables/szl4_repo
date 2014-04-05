package team.uninter.mordorq.gamespace;

import java.util.HashMap;

/**
 * Responsible to ensure a place for towers
 * 
 * @author Soma
 *
 */
public class GroundGrid extends TerrainGrid{

	/**
	 * available - availability of the grid, depends on a tower is 
	 * on it or not
	 * 
	 * tower - tower on the grid
	 */
	private boolean available = true;
	private Tower tower;
	
	/**
	 * Contructor with position parameters
	 * 
	 * @param x
	 * @param y
	 */
	public GroundGrid(int x, int y) {
		super(x, y);
	}
	
	public GroundGrid(int x, int y, int utility, int id) {
		super(x, y, utility, id);
	}
	
	/**
	 * Contructor with utility parameter
	 * 
	 * @param utility
	 */
	public GroundGrid(int utility) {
		super(utility);
	}
	
	/**
	 * Contructor without parameter  
	 */
	public GroundGrid() {
		super(0);
	}
	
	/**
	 * place the given tower to the grid and
	 * change it's availability
	 * 
	 * @param tower
	 */
	public void reserve(Tower tower){
		this.tower = tower;
		this.tower.setX(this.x);
		this.tower.setY(this.y);
		available = false;
	}
	
	 /** 
	 * Gives back the grids availability for a trap
	 */
	@Override
	public boolean isAvailableFor(Trap trap) {
		return false;
	}

	/** 
	 * Gives back the grids availability for a tower
	 */
	@Override
	public boolean isAvailableFor(Tower tower) {
		return true;
	}
	
	/** Checks if the trap is able to inject the given <code>Rune</code>.
	 * 
	 * @param rune the rune in question about injection.
	 * @return true only if the trap can inject this kind of rune
	 * @see team.uninter.mordorq.gamespace.TerrainGrid#isAvailableFor(team.uninter.mordorq.gamespace.Rune)
	 */
	@Override
	public boolean isAvailableFor(Rune rune) {
		return tower.canInject(rune);
	}
	
	/** 
	 * Repaint
	 */
	public void repaint(){
		//TODO:
	}


	/**
	 * Gives back the tower on the grid
	 * 
	 * @return
	 */
	public Tower getTower(){
		return tower;
	}

	/**
	 * Gives back the tower ont he grid
	 * 
	 */
	@Override
	public InjectionTarget getInjectionTarget() {
		return tower;
	}
	
	/**
	 * Gives back the grids availability for a barricade
	 * 
	 */
	@Override
	public boolean isAvailableFor(Barricade barricade) {
		return false;
	}

	@Override
	public boolean isInRangeOf(Tower tower) {
		return false;
	}
}
