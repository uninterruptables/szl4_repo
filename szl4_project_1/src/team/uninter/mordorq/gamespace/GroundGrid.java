package team.uninter.mordorq.gamespace;

import java.awt.Graphics;
import java.io.File;

/**
 * Responsible to ensure a place for towers
 * 
 * @author Soma
 *
 */
@SuppressWarnings("serial")
public class GroundGrid extends TerrainGrid {

	/**
	 * available - availability of the grid, depends on a tower is on it or not
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
		this.tryLoad(new File("resources/images/groundrid_16p.png"));
	}

	/**
	 * Contructor with utility parameter
	 * 
	 * @param utility
	 */
	public GroundGrid(int utility) {
		this(0, 0, utility, 0);
	}

	/**
	 * Contructor without parameter
	 */
	public GroundGrid() {
		this(0, 0, 0, 0);
	}

	/**
	 * place the given tower to the grid and change it's availability
	 * 
	 * @param tower
	 */
	public void reserve(Tower tower) {
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
		return available;
	}

	/**
	 * Checks if the trap is able to inject the given <code>Rune</code>.
	 * 
	 * @param rune
	 *            the rune in question about injection.
	 * @return true only if the trap can inject this kind of rune
	 * @see team.uninter.mordorq.gamespace.TerrainGrid#isAvailableFor(team.uninter.mordorq.gamespace.Rune)
	 */
	@Override
	public boolean isAvailableFor(Rune rune) {
		return tower.canInject(rune);
	}

	/**
	 * Paints this component and all the components referenced by it.
	 * 
	 * @param g the <code>Graphics</code> instance responsible for drawings
	 * 		     in the Java Graphics FrameWork
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (tower != null)
			this.tower.paint(g);
	}

	/**
	 * Gives back the tower on the grid
	 * 
	 * @return
	 */
	public Tower getTower() {
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
