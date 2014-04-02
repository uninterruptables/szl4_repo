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
		//TODO remove sysout
		System.out.println("Hobbit.Hobbit() called");
		health = GameConstants.HOBBIT_HEALTH;
		damage = GameConstants.HOBBIT_DAMAGE;
		rewardMana = GameConstants.HOBBIT_REWARD;
		maxCooldown = cooldown = GameConstants.HOBBIT_COOLDOWN;
		System.out.println("Hobbit.Hobbit() returned");
	}
	
	/**
	 * Hobbit with two parameter.
	 * @param x
	 * @param y
	 */
	public Hobbit(int x, int y) {
		super(x, y);
		//TODO remove sysout
		System.out.println("Hobbit.Hobbit(x,y) called");
		health = GameConstants.HOBBIT_HEALTH;
		damage = GameConstants.HOBBIT_DAMAGE;
		rewardMana = GameConstants.HOBBIT_REWARD;
		maxCooldown = cooldown = GameConstants.HOBBIT_COOLDOWN;
		System.out.println("Hobbit.Hobbit(x,y) returned");
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
		//TODO remove sysout
		this.health = health;
		this.damage = damage;
		this.rewardMana = reward;
		maxCooldown = cooldown = GameConstants.HOBBIT_COOLDOWN;
		System.out.println("Hobbit.Hobbit(x,y,health,damage,reward) called");
		System.out.println("Hobbit.Hobbit(x,y,health,damage,reward) returned");
	}

	/* Return the amount of the reward for one hobbit killing.
	 * (non-Javadoc)
	 * @see team.uninter.mordorq.gamespace.EnemyTroop#getReward()
	 */
	public int getReward()
	{
		//TODO remove sysout
		// If the player kill an enemy from this kind, get the proper reward(mana) for each enemy of thespecific type(species)
		System.out.println("Hobbit.getReward() called");
		System.out.println("Hobbit.getReward() returned");
		return rewardMana;
	}
	
	/*  Method how and how many damage get the hobbit.
	 * (non-Javadoc)
	 * @see team.uninter.mordorq.gamespace.EnemyTroop#interactWith(team.uninter.mordorq.gamespace.Tower.Missile)
	 */
	@Override
	public void interactWith(Missile missile) {
		//TODO remove sysout
		System.out.println("Hobbit.interactWith(Missile) called");
		this.setHealth(this.getHealth() - missile.getHobbitDamage());
		if(health <= 0 && currentGrid != null) currentGrid.remove();
		System.out.println("Hobbit.interactWith(Missile) returned");
	}
}
