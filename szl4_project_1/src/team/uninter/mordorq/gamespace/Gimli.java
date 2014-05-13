package team.uninter.mordorq.gamespace;

import java.io.File;

import team.uninter.mordorq.utils.GameConstants;

/**
 * @author Danyik D�vid Singleton class of the Dwarf race bosses, Gimli. It have
 *         special health and damage value not like the extended class troops.
 *         There is only one of this troop.
 */
@SuppressWarnings("serial")
public class Gimli extends Dwarf {

//	static {
//		rewardMana = GameConstants.GIMLI_REWARD;
//		tryLoad(new File("resources/images/gimli_16p.png"));
//	}

	private static Gimli instance = null;

	private Gimli(int health, int damage) {
		super();
		this.health = health;
		this.damage = damage;
		rewardMana = GameConstants.GIMLI_REWARD;
		tryLoad(new File("resources/images/gimli_16p.png"));
	}

	public static Gimli getInstance() {
		if (instance == null) {
			instance = new Gimli(GameConstants.GIMLI_HEALTH, GameConstants.GIMLI_DAMAGE);
		}
		return instance;
	}
}
