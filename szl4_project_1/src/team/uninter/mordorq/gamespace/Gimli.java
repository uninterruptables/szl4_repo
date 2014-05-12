package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.utils.GameConstants;

/**
 * @author Danyik D�vid Singleton class of the Dwarf race bosses, Gimli. It have
 *         special health and damage value not like the extended class troops.
 *         There is only one of this troop.
 */
@SuppressWarnings("serial")
public class Gimli extends Dwarf {

	static {
		rewardMana = GameConstants.GIMLI_REWARD;
	}

	private static Gimli instance = null;

	private Gimli(int health, int damage) {
		super();
		this.health = health;
		this.damage = damage;
	}

	public static Gimli getInstance() {
		if (instance == null) {
			instance = new Gimli(GameConstants.GIMLI_HEALTH, GameConstants.GIMLI_DAMAGE);
		}
		return instance;
	}
}
