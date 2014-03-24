package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.gamespace.Tower.Missile;

@SuppressWarnings("serial")
public class Human extends EnemyTroop {
	// Specific EnemyTroop, called Human. It could be named "basic" troop, others will be compare to this.
	//Have average life, speed and damage
	
	private static int maxHealth = 150;
	{
		super.health = maxHealth;
	}
	
	public Human() {
		super();
		//TODO remove sysout
		System.out.println("Human.Human() called");
		System.out.println("Human.Human() returned");
	}
	
	public Human(int x, int y) {
		super(x, y);
		//TODO remove sysout
		System.out.println("Human.Human(x,y) called");
		System.out.println("Human.Human(x,y) returned");
	}
	
	public Human(int x, int y, int health, int damage, int reward) {
		super(x, y);
		//TODO remove sysout
		this.health = health;
		this.damage = damage;
		this.rewardMana = reward;
		System.out.println("Human.Human(x,y,health,damage,reward) called");
		System.out.println("Human.Human(x,y,health,damage,reward) returned");
	}
	
	public int getReward()
	{
		//TODO remove sysout
		// If the player kill an enemy from this kind, get the proper reward(mana) for each enemy of thespecific type(species)
		System.out.println("Human.getReward() called");
		System.out.println("Human.getReward() returned");
		return rewardMana;
		
	}
	@Override
	public void interactWith(Missile missile) {
		//TODO remove sysout
		System.out.println("Human.interactWith(Missile) called");
		this.setHealth(this.getHealth() - missile.getHumanDamage());
		System.out.println("Human.interactWith(Missile) returned");
		
	}
}
