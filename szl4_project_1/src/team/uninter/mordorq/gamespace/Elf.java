package team.uninter.mordorq.gamespace;

import java.io.File;

import team.uninter.mordorq.gamespace.Tower.Missile;
import team.uninter.mordorq.utils.GameConstants;

@SuppressWarnings("serial")
public class Elf extends EnemyTroop {
	// Specific EnemyTroop, called Elf. Have less life then other specific
	// troop, more speed, and a little more damage

	// static {
	// rewardMana = GameConstants.ELF_REWARD;
	// tryLoad(new File("resources/images/elf_16p.png"));
	// }

	/**
	 * Elf with no parameter.
	 */
	public Elf() {
		this(0, 0, GameConstants.ELF_HEALTH, GameConstants.ELF_DAMAGE);
		rewardMana = GameConstants.ELF_REWARD;
		tryLoad(new File("resources/images/elf_16p.png"));
	}

	/**
	 * Elf with two parameter.
	 * 
	 * @param x
	 * @param y
	 */
	public Elf(int x, int y) {
		this(x, y, GameConstants.ELF_HEALTH, GameConstants.ELF_DAMAGE);
		rewardMana = GameConstants.ELF_REWARD;
		tryLoad(new File("resources/images/elf_16p.png"));
	}

	/**
	 * Elf with five parameter, attributes.
	 * 
	 * @param x
	 * @param y
	 * @param health
	 * @param damage
	 * @param reward
	 */
	public Elf(int x, int y, int health, int damage) {
		super(x, y);
		this.health = health;
		this.damage = damage;
		maxCooldown = cooldown = GameConstants.ELF_COOLDOWN;
		rewardMana = GameConstants.ELF_REWARD;
		tryLoad(new File("resources/images/elf_16p.png"));
	}

	@Override
	protected EnemyTroop createClone(int health) {
		return new Elf(x, y, health, damage);
	}

	/*
	 * Return the amount of the reward for one elf killing. (non-Javadoc)
	 * 
	 * @see team.uninter.mordorq.gamespace.EnemyTroop#getReward()
	 */
	// public int getReward() {
	// return rewardMana;
	// }

	/*
	 * Method how and how many damage get the elf. (non-Javadoc)
	 * 
	 * @see
	 * team.uninter.mordorq.gamespace.EnemyTroop#interactWith(team.uninter.mordorq
	 * .gamespace.Tower.Missile)
	 */

	@Override
	protected void speciesInteractWith(Missile missile) {
		this.setHealth(this.getHealth() - missile.getElfDamage());
	}
}
