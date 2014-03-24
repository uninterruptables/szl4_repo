package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.gamespace.Tower.Missile;

@SuppressWarnings("serial")
public class Hobbit extends EnemyTroop {
	// Specific EnemyTroop, called Hobbit. Have little less life then other specific troop, less speed, and less damage.
	
	private static int maxHealth = 90;
	{
		super.health = maxHealth;
	}
	
	/**
	 * Hobbit with no parameter.
	 */
	public Hobbit() {
		super();
		//TODO remove sysout
		System.out.println("Hobbit.Hobbit() called");
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
		setDamage(missile.getHobbitDamage());
		System.out.println("Hobbit.interactWith(Missile) returned");
	}
}