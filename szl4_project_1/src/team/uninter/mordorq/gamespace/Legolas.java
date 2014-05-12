package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.utils.GameConstants;

/**
 * @author Danyik D�vid Singleton class of the Elf race bosses, Legolas. It have
 *         special health and damage value not like the extended class troops.
 *         There is only one of this troop.
 */
@SuppressWarnings("serial")
public class Legolas extends Elf {

	static {
		rewardMana = GameConstants.LEGOLAS_REWARD;
	}

	private static Legolas instance = null;

	private Legolas(int health, int damage) {
		super();
		this.health = health;
		this.damage = damage;
	}

	public static Legolas getInstance() {
		if (instance == null) {
			instance = new Legolas(GameConstants.LEGOLAS_HEALTH, GameConstants.LEGOLAS_DAMAGE);
		}
		return instance;
	}
}
