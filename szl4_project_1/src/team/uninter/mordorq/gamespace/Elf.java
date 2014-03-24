package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.gamespace.Tower.Missile;

@SuppressWarnings("serial")
public class Elf extends EnemyTroop {
// Specific EnemyTroop, called Elf. Have less life then other specific troop, more speed, and a little more damage
	
	private static int maxHealth = 100;
	{
		super.health = maxHealth;
	}
	
	public Elf() {
		super();
		//TODO remove sysout
		System.out.println("Elf.Elf() called");
		System.out.println("Elf.Elf() returned");
	}
	
	public Elf(int x, int y) {
		super(x, y);
		//TODO remove sysout
		System.out.println("Elf.Elf(x,y) called");
		System.out.println("Elf.Elf(x,y) returned");
	}
	
	public Elf(int x, int y, int health, int damage, int reward) {
		super(x, y);
		//TODO remove sysout
		this.health = health;
		this.damage = damage;
		this.rewardMana = reward;
		System.out.println("Elf.Elf(x,y,health,damage,reward) called");
		System.out.println("Elf.Elf(x,y,health,damage,reward) returned");
	}
	
	public int getReward()
	{
		//TODO remove sysout
		// If the player kill an enemy from this kind, get the proper reward(mana) for each enemy of thespecific type(species)
		System.out.println("Elf.getReward() called");
		System.out.println("Elf.getReward() returned");
		return rewardMana;
		
	}
	
	@Override
	public void interactWith(Missile missile) {
		//TODO remove sysout
		System.out.println("Elf.interactWith(Missile) called");
		setDamage(missile.getElfDamage());
		System.out.println("Elf.interactWith(Missile) returned");
	}
}
