package team.uninter.mordorq.gamespace;

import java.io.File;

import team.uninter.mordorq.gamespace.Tower.Missile;
import team.uninter.mordorq.utils.GameConstants;

@SuppressWarnings("serial")
public class Human extends EnemyTroop {
	// Specific EnemyTroop, called Human. It could be named "basic" troop,
	// others will be compare to this.
	// Have average life, speed and damage

//	static {
//		rewardMana = GameConstants.HUMAN_REWARD;
//		tryLoad(new File("resources/images/human_16p.png"));
//	}

	/**
	 * Human with no parameter.
	 */
	public Human() {
		this(0, 0, GameConstants.HUMAN_HEALTH, GameConstants.HUMAN_DAMAGE);
		rewardMana = GameConstants.HUMAN_REWARD;
		tryLoad(new File("resources/images/human_16p.png"));
	}

	/**
	 * Human with two parameter
	 * 
	 * @param x
	 * @param y
	 */
	public Human(int x, int y) {
		this(x, y, GameConstants.HUMAN_HEALTH, GameConstants.HUMAN_DAMAGE);
		rewardMana = GameConstants.HUMAN_REWARD;
		tryLoad(new File("resources/images/human_16p.png"));
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
		rewardMana = GameConstants.HUMAN_REWARD;
		tryLoad(new File("resources/images/human_16p.png"));
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
