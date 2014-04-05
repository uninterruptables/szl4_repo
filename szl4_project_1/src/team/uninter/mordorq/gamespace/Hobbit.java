package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.gamespace.Tower.Missile;
import team.uninter.mordorq.utils.GameConstants;

@SuppressWarnings("serial")
public class Hobbit extends EnemyTroop {
	// Specific EnemyTroop, called Hobbit. Have little less life then other specific troop, less speed, and less damage.
	
	/**
	 * Hobbit with no parameter.
	 */
	public Hobbit() {
		super();
		health = GameConstants.HOBBIT_HEALTH;
		damage = GameConstants.HOBBIT_DAMAGE;
		rewardMana = GameConstants.HOBBIT_REWARD;
		maxCooldown = cooldown = GameConstants.HOBBIT_COOLDOWN;
	}
	
	/**
	 * Hobbit with two parameter.
	 * @param x
	 * @param y
	 */
	public Hobbit(int x, int y) {
		super(x, y);
		health = GameConstants.HOBBIT_HEALTH;
		damage = GameConstants.HOBBIT_DAMAGE;
		rewardMana = GameConstants.HOBBIT_REWARD;
		maxCooldown = cooldown = GameConstants.HOBBIT_COOLDOWN;
	}
	
	/**
	 * Hobbit with five parameters, attributes.
	 * @param x
	 * @param y
	 * @param health
	 * @param damage
	 * @param reward
	 */
	public Hobbit(int x, int y, int health, int damage, int reward) {
		super(x, y);
		this.health = health;
		this.damage = damage;
		this.rewardMana = reward;
		maxCooldown = cooldown = GameConstants.HOBBIT_COOLDOWN;
	}
	
	protected EnemyTroop createClone(int health){
		return new Hobbit(x, y, health, damage, rewardMana);
	}

	/* Return the amount of the reward for one hobbit killing.
	 * (non-Javadoc)
	 * @see team.uninter.mordorq.gamespace.EnemyTroop#getReward()
	 */
	public int getReward()	{
		return rewardMana;
	}
	
	/*  Method how and how many damage get the hobbit.
	 * (non-Javadoc)
	 * @see team.uninter.mordorq.gamespace.EnemyTroop#interactWith(team.uninter.mordorq.gamespace.Tower.Missile)
	 */
	@Override
	protected void speciesInteractWith(Missile missile) {
		this.setHealth(this.getHealth() - missile.getHobbitDamage());
		if(health <= 0 && currentGrid != null) currentGrid.remove();
	}
}
