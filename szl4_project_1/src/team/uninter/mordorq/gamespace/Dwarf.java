package team.uninter.mordorq.gamespace;

import java.io.File;

import team.uninter.mordorq.gamespace.Tower.Missile;
import team.uninter.mordorq.utils.GameConstants;

@SuppressWarnings("serial")
public class Dwarf extends EnemyTroop {
	// Specific EnemyTroop, called Dwarf. Have much more life then other
	// specific troop, less speed, and a little more damage

	// static {
	// rewardMana = GameConstants.DWARF_REWARD;
	// tryLoad(new File("resources/images/dwarf_16p.png"));
	// }

	/**
	 * Dwarf with no parameter.
	 */
	public Dwarf() {
		this(0, 0, GameConstants.DWARF_HEALTH, GameConstants.DWARF_DAMAGE);
		rewardMana = GameConstants.DWARF_REWARD;
		tryLoad(new File("resources/images/dwarf_16p.png"));
	}

	/**
	 * Dwarf with two parameter
	 * 
	 * @param x
	 * @param y
	 */
	public Dwarf(int x, int y) {
		this(x, y, GameConstants.DWARF_HEALTH, GameConstants.DWARF_DAMAGE);
		rewardMana = GameConstants.DWARF_REWARD;
		tryLoad(new File("resources/images/dwarf_16p.png"));
	}

	/**
	 * Dwarf with five parameter, attributes .
	 * 
	 * @param x
	 * @param y
	 * @param health
	 * @param damage
	 * @param reward
	 */
	public Dwarf(int x, int y, int health, int damage) {
		super(x, y);
		this.health = health;
		this.damage = damage;
		maxCooldown = cooldown = GameConstants.DWARF_COOLDOWN;
		rewardMana = GameConstants.DWARF_REWARD;
		tryLoad(new File("resources/images/dwarf_16p.png"));
	}

	@Override
	protected EnemyTroop createClone(int health) {
		return new Dwarf(x, y, health, damage);
	}

	/**
	 * Method how and how many damage get the dwarf.
	 * 
	 * @see team.uninter.mordorq.gamespace.EnemyTroop#interactWith(team.uninter.mordorq
	 *      .gamespace.Tower.Missile)
	 */
	@Override
	protected void speciesInteractWith(Missile missile) {
		this.setHealth(this.getHealth() - missile.getDwarfDamage());
	}
}
