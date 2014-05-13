package team.uninter.mordorq.gamespace;

import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsible to ensure a place for enemy troops, traps and barricdes
 * 
 * @author Soma
 *
 */
@SuppressWarnings("serial")
public class RoadGrid extends TerrainGrid implements TargetPublisher {

	/**
	 * trap - trap on the grid
	 * 
	 * vulnerable - barricade or enemy troop on the grid
	 * 
	 * subscribers - towers for those this grid is in range
	 */

	private Trap trap;
	private Vulnerable vulnerable;
	private final List<TargetSubscriber> subscribers;

//	static {
//		tryLoad(new File("resources/images/roadgrid_16p.png"));
//	}

	/**
	 * Contructor with position parameters
	 * 
	 * @param x
	 * @param y
	 */
	public RoadGrid(int x, int y) {
		this(x, y, 0, 0);
		tryLoad(new File("resources/images/roadgrid_16p.png"));
	}

	public RoadGrid(int x, int y, int utility, int id) {
		super(x, y);
		this.utility = utility;
		this.id = id;
		subscribers = new ArrayList<TargetSubscriber>();
		tryLoad(new File("resources/images/roadgrid_16p.png"));
	}

	/**
	 * Contructor with utility parameter
	 * 
	 * @param utility
	 */
	public RoadGrid(int utility) {
		this(0, 0, utility, 0);
		tryLoad(new File("resources/images/roadgrid_16p.png"));
	}

	/**
	 * Contructor without parameter
	 */
	public RoadGrid() {
		this(0, 0, 0, 0);
		tryLoad(new File("resources/images/roadgrid_16p.png"));
	}

	/**
	 * Place the given tower to the subscibers list
	 */
	@Override
	public void attach(TargetSubscriber subscriber) {
		subscribers.add(subscriber);
	}

	/**
	 * Remove the given tower from the subscribers list
	 */
	@Override
	public void detach(TargetSubscriber subscriber) {
		subscribers.remove(subscribers.indexOf(subscriber));
	}

	/**
	 * Notify all tower from the subscriber list with the given enemy
	 */
	@Override
	public void notifyAllWith(EnemyTroop troop) {
		setVulnerable(troop);
		for (TargetSubscriber t : subscribers) {
			t.notifyWith(troop);
		}
	}

	/**
	 * Gives back that the grid contains the given troop or not
	 */
	@Override
	public boolean contains(EnemyTroop troop) {
		return subscribers.contains(troop);
	}

	/**
	 * Remove the vulnerable reference from the grid
	 */
	public void remove() {
		vulnerable = null;
	}

	/**
	 * Gives back the grids availability for a trap
	 */
	@Override
	public boolean isAvailableFor(Trap trap) {
		return true;
	}

	/**
	 * Gives back the grids availability for a tower
	 */
	@Override
	public boolean isAvailableFor(Tower tower) {
		return false;
	}

	/**
	 * Paints this component and all the components referenced by it.
	 * 
	 * @param g
	 *            the <code>Graphics</code> instance responsible for drawings in
	 *            the Java Graphics FrameWork
	 */
	@Override
	public void drawGrid(Graphics g) {
		super.drawObject(g);
		if (vulnerable != null)
			this.vulnerable.drawObject(g);
		else if (trap != null)
			this.trap.drawObject(g);
	}

	/**
	 * Gives back the enemy troop on the grid
	 */
	@Override
	public EnemyTroop getTarget() {
		EnemyTroop targetEnemy = null;
		if (vulnerable instanceof EnemyTroop) {
			targetEnemy = (EnemyTroop) vulnerable;
		}
		return targetEnemy;
	}

	/**
	 * Gives back the trap on the grid
	 */
	public Trap getTrap() {
		return trap;
	}

	/**
	 * Gives back the vulnerable on the grid
	 */
	public Vulnerable getVulnerable() {
		return vulnerable;
	}

	/**
	 * Set a trap on the grid with the given parameter
	 */
	public void setTrap(Trap trap) {
		this.trap = trap;
		this.trap.setX(this.x);
		this.trap.setY(this.y);
	}

	/**
	 * Set a vulnerable on the grid with the given parameter
	 */
	public void setVulnerable(Vulnerable vulnerable) {
		this.vulnerable = vulnerable;
		if (vulnerable instanceof EnemyTroop) {
			((EnemyTroop) this.vulnerable).setCurrentGrid(this);
		}
		if (vulnerable instanceof Barricade) {
			((Barricade) this.vulnerable).setCurrentGrid(this);
		}
		((GameObject) this.vulnerable).setX(this.x);
		((GameObject) this.vulnerable).setY(this.y);
	}

	/**
	 * Gives back the trap on the grid
	 */
	@Override
	public InjectionTarget getInjectionTarget() {
		return trap;
	}

	/**
	 * Gives back the grids availability for a barricade
	 */
	@Override
	public boolean isAvailableFor(Barricade barricade) {
		return this.vulnerable == null;
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
		if(trap != null){
			return trap.canInject(rune);
		}
		else{
			return false;
		}
	}

	@Override
	public boolean isInRangeOf(Tower tower) {
		int currentX = super.x;
		int currentY = super.y;
		int targetX = tower.getX();
		int targetY = tower.getY();
		int distanceX = targetX - currentX;
		int distanceY = targetY - currentY;
		int distance = (int) Math.sqrt(distanceX ^ 2 + distanceY ^ 2);
		return distance <= tower.getRadius();
	}
}