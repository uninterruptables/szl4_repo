package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.gamespace.Tower.Missile;
import team.uninter.mordorq.utils.GameConstants;

@SuppressWarnings("serial")
public class Elf extends EnemyTroop {
// Specific EnemyTroop, called Elf. Have less life then other specific troop, more speed, and a little more damage
	
	/**
	 * Elf with no parameter.
	 */
	public Elf() {
		super();
		//TODO remove sysout
		System.out.println("Elf.Elf() called");
		health = GameConstants.ELF_HEALTH;
		damage = GameConstants.ELF_DAMAGE;
		rewardMana = GameConstants.ELF_REWARD;
		maxCooldown = cooldown = GameConstants.ELF_COOLDOWN;
		System.out.println("Elf.Elf() returned");
	}
	
	/**
	 * Elf with two parameter.
	 * @param x
	 * @param y
	 */
	public Elf(int x, int y) {
		super(x, y);
		//TODO remove sysout
		System.out.println("Elf.Elf(x,y) called");
		health = GameConstants.ELF_HEALTH;
		damage = GameConstants.ELF_DAMAGE;
		rewardMana = GameConstants.ELF_REWARD;
		maxCooldown = cooldown = GameConstants.ELF_COOLDOWN;
		System.out.println("Elf.Elf(x,y) returned");
	}
	
	/**
	 * Elf with five parameter, attributes.
	 * @param x
	 * @param y
	 * @param health
	 * @param damage
	 * @param reward
	 */
	public Elf(int x, int y, int health, int damage, int reward) {
		super(x, y);
		//TODO remove sysout
		this.health = health;
		this.damage = damage;
		this.rewardMana = reward;
		maxCooldown = cooldown = GameConstants.ELF_COOLDOWN;
		System.out.println("Elf.Elf(x,y,health,damage,reward) called");
		System.out.println("Elf.Elf(x,y,health,damage,reward) returned");
	}
	
	/* Return the amount of the reward for one elf killing.
	 * (non-Javadoc)
	 * @see team.uninter.mordorq.gamespace.EnemyTroop#getReward()
	 */
	public int getReward()
	{
		//TODO remove sysout
		// If the player kill an enemy from this kind, get the proper reward(mana) for each enemy of thespecific type(species)
		System.out.println("Elf.getReward() called");
		System.out.println("Elf.getReward() returned");
		return rewardMana;
		
	}
	
	/* Method how and how many damage get the elf.
	 * (non-Javadoc)
	 * @see team.uninter.mordorq.gamespace.EnemyTroop#interactWith(team.uninter.mordorq.gamespace.Tower.Missile)
	 */

	@Override
	public void interactWith(Missile missile) {
		//TODO remove sysout
		System.out.println("Elf.interactWith(Missile) called");
		this.setHealth(this.getHealth() - missile.getElfDamage());
		if(health <= 0 && currentGrid != null) currentGrid.remove();
		System.out.println("Elf.interactWith(Missile) returned");
	}
}
