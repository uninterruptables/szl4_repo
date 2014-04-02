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
		//TODO remove sysout
		System.out.println("GroundGrid.GroundGrid(x,y) called");
		System.out.println("GroundGrid.GroundGrid(x,y) returned");
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
		//TODO remove sysout
		System.out.println("GroundGrid.GroundGrid(utility) called");
		System.out.println("GroundGrid.GroundGrid(utility) returned");
	}
	
	/**
	 * Contructor without parameter  
	 */
	public GroundGrid() {
		super(0);
		//TODO remove sysout
		System.out.println("GroundGrid.GroundGrid() called");
		System.out.println("GroundGrid.GroundGrid() returned");
	}
	
	/**
	 * place the given tower to the grid and
	 * change it's availability
	 * 
	 * @param tower
	 */
	public void reserve(Tower tower){
		//TODO remove sysout
		System.out.println("GroundGrid reserve(Tower tower) called");
		this.tower = tower;
		this.tower.setX(this.x);
		this.tower.setY(this.y);
		available = false;
		System.out.println("GroundGrid reserve(Tower tower) returned");
	}
	
	 /** 
	 * Gives back the grids availability for a trap
	 */
	@Override
	public boolean isAvailableFor(Trap trap) {
		//TODO remove sysout
		System.out.println("GroundGrid isAvailableFor(Trap trap) called");
		System.out.println("GroundGrid isAvailableFor(Trap trap) returned false");
		return false;
	}

	/** 
	 * Gives back the grids availability for a tower
	 */
	@Override
	public boolean isAvailableFor(Tower tower) {
		//TODO remove sysout
		System.out.println("GroundGrid isAvailableFor(Tower tower) called");
		System.out.println("GroundGrid isAvailableFor(Tower tower) returned true");
		return true;
	}
	
	/** 
	 * Repaint
	 */
	public void repaint(){
		//TODO remove sysout
		System.out.println("GroundGrid repaint() called");
		//TODO not implemented yet
		System.out.println("GroundGrid repaint() returned");
	}


	/**
	 * Gives back the tower on the grid
	 * 
	 * @return
	 */
	public Tower getTower(){
		// TODO remove sysout
		System.out.println("GroundGrid getTower() called");
		System.out.println("GroundGrid getTower() returned");
		return tower;
	}

	/**
	 * Gives back the tower ont he grid
	 * 
	 */
	@Override
	public InjectionTarget getInjectionTarget() {
		// TODO remove sysout
		System.out.println("GroundGrid getInjectionTarget() called");
		System.out.println("GroundGrid getInjectionTarget() returned");
		return tower;
	}
	
	/**
	 * Gives back the grids availability for a barricade
	 * 
	 */
	@Override
	public boolean isAvailableFor(Barricade barricade) {
		// TODO remove sysout
		System.out.println("GroundGrid isAvailableFor(Barricade) called");
		System.out.println("GroundGrid isAvailableFor(Barricade) returned");
		return false;
	}

	@Override
	public boolean isInRangeOf(Tower tower) {
		return false;
	}
	
}
