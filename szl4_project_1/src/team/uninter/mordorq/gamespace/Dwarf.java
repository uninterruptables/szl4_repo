package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.gamespace.Tower.Missile;

@SuppressWarnings("serial")
public class Dwarf extends EnemyTroop {
	// Specific EnemyTroop, called Dwarf. Have much more life then other specific troop, less speed, and a little more damage
	
	public Dwarf() {
		super();
		//TODO remove sysout
		System.out.println("Dwarf.Dwarf() called");
		System.out.println("Dwarf.Dwarf() returned");
	}
	
	public Dwarf(int x, int y) {
		super(x, y);
		//TODO remove sysout
		System.out.println("Dwarf.Dwarf(x,y) called");
		System.out.println("Dwarf.Dwarf(x,y) returned");
	}

	public Dwarf(int x, int y, int health, int damage, int reward) {
		super(x, y);
		//TODO remove sysout
		this.health = health;
		this.damage = damage;
		this.rewardMana = reward;
		System.out.println("Dwarf.Dwarf(x,y,health,damage,reward) called");
		System.out.println("Dwarf.Dwarf(x,y,health,damage,reward) returned");
	}
	
	public int getReward()
	{
		//TODO remove sysout
		// If the player kill an enemy from this kind, get the proper reward(mana) for each enemy of thespecific type(species)
		System.out.println("Dwarf.getReward() called");
		System.out.println("Dwarf.getReward() returned");
		return rewardMana;
		
	}
	@Override
	public void interactWith(Missile missile) {
		//TODO remove sysout
		System.out.println("Dwarf.interactWith(Missile) called");
		setDamage(missile.getDwarfDamage());
		System.out.println("Dwarf.interactWith(Missile) returned");
		
	}
}
