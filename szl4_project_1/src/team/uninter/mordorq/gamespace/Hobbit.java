package team.uninter.mordorq.gamespace;

import java.io.File;

import team.uninter.mordorq.gamespace.Tower.Missile;
import team.uninter.mordorq.utils.GameConstants;

@SuppressWarnings("serial")
public class Hobbit extends EnemyTroop {
	// Specific EnemyTroop, called Hobbit. Have little less life then other
	// specific troop, less speed, and less damage.

	static {
		rewardMana = GameConstants.HOBBIT_REWARD;
		tryLoad(new File("resources/images/hobbit5_16p.png"));
	}

	/**
	 * Hobbit with no parameter.
	 */
	public Hobbit() {
		this(0, 0, GameConstants.HOBBIT_HEALTH, GameConstants.HOBBIT_DAMAGE);
	}

	/**
	 * Hobbit with two parameter.
	 * 
	 * @param x
	 * @param y
	 */
	public Hobbit(int x, int y) {
		this(x, y, GameConstants.HOBBIT_HEALTH, GameConstants.HOBBIT_DAMAGE);
	}

	/**
	 * Hobbit with five parameters, attributes.
	 * 
	 * @param x
	 * @param y
	 * @param health
	 * @param damage
	 * @param reward
	 */
	public Hobbit(int x, int y, int health, int damage) {
		super(x, y);
		this.health = health;
		this.damage = damage;
		maxCooldown = cooldown = GameConstants.HOBBIT_COOLDOWN;
	}

	@Override
	protected EnemyTroop createClone(int health) {
		return new Hobbit(x, y, health, damage);
	}

	/**
	 * Method how and how many damage get the hobbit. (non-Javadoc)
	 * 
	 * @see team.uninter.mordorq.gamespace.EnemyTroop#interactWith(team.uninter.mordorq
	 *      .gamespace.Tower.Missile)
	 */
	@Override
	protected void speciesInteractWith(Missile missile) {
		this.setHealth(this.getHealth() - missile.getHobbitDamage());
		if (health <= 0 && currentGrid != null)
			currentGrid.remove();
	}
}
