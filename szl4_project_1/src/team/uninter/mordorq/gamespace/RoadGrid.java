package team.uninter.mordorq.gamespace;

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

	/**
	 * Contructor with position parameters
	 * 
	 * @param x
	 * @param y
	 */
	public RoadGrid(int x, int y) {
		super(x, y);
		subscribers = new ArrayList<TargetSubscriber>();
	}

	public RoadGrid(int x, int y, int utility, int id) {
		super(x, y, utility, id);
		subscribers = new ArrayList<TargetSubscriber>();
	}

	/**
	 * Contructor with utility parameter
	 * 
	 * @param utility
	 */
	public RoadGrid(int utility) {
		super(utility);
		subscribers = new ArrayList<TargetSubscriber>();
	}

	/**
	 * Contructor without parameter
	 */
	public RoadGrid() {
		super();
		subscribers = new ArrayList<TargetSubscriber>();
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
	 * Repaint
	 */
	@Override
	public void repaint() {
		super.repaint();
		if (vulnerable != null)
			this.vulnerable.repaint();
		else if (trap != null)
			this.trap.repaint();
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
		return true;
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
		return trap.canInject(rune);
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