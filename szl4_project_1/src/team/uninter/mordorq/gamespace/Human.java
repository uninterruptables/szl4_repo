package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.gamespace.Tower.Missile;
import team.uninter.mordorq.utils.GameConstants;

@SuppressWarnings("serial")
public class Human extends EnemyTroop {
	// Specific EnemyTroop, called Human. It could be named "basic" troop,
	// others will be compare to this.
	// Have average life, speed and damage

	static {
		rewardMana = GameConstants.HUMAN_REWARD;
	}

	/**
	 * Human with no parameter.
	 */
	public Human() {
		super();
		health = GameConstants.HUMAN_HEALTH;
		damage = GameConstants.HUMAN_DAMAGE;
		maxCooldown = cooldown = GameConstants.HUMAN_COOLDOWN;
	}

	/**
	 * Human with two parameter
	 * 
	 * @param x
	 * @param y
	 */
	public Human(int x, int y) {
		super(x, y);
		health = GameConstants.HUMAN_HEALTH;
		damage = GameConstants.HUMAN_DAMAGE;
		maxCooldown = cooldown = GameConstants.HUMAN_COOLDOWN;
	}

	/**
	 * Human with five parameter, attributes.
	 * 
	 * @param x
	 * @param y
	 * @param health
	 * @param damage
	 * @param reward
	 */
	public Human(int x, int y, int health, int damage) {
		super(x, y);
		this.health = health;
		this.damage = damage;
		maxCooldown = cooldown = GameConstants.HUMAN_COOLDOWN;
	}

	@Override
	protected EnemyTroop createClone(int health) {
		return new Human(x, y, health, damage);
	}

	/*
	 * Return the amount of the reward for one human killing. (non-Javadoc)
	 * 
	 * @see team.uninter.mordorq.gamespace.EnemyTroop#getReward()
	 */
	// public int getReward() {
	// return rewardMana;
	// }

	/**
	 * Method how and how many damage get the human. (non-Javadoc)
	 * 
	 * @see team.uninter.mordorq.gamespace.EnemyTroop#interactWith(team.uninter.mordorq.gamespace.Tower.Missile)
	 */
	@Override
	protected void speciesInteractWith(Missile missile) {
		this.setHealth(this.getHealth() - missile.getHumanDamage());
		if (health <= 0 && currentGrid != null)
			currentGrid.remove();
	}
}
