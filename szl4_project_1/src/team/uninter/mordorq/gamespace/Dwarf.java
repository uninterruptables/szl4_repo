package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.gamespace.Tower.Missile;
import team.uninter.mordorq.utils.GameConstants;

@SuppressWarnings("serial")
public class Dwarf extends EnemyTroop {
	// Specific EnemyTroop, called Dwarf. Have much more life then other specific troop, less speed, and a little more damage
	
	/**
	 *  Dwarf with no parameter.
	 */
	public Dwarf() {
		super();
		//TODO remove sysout
		System.out.println("Dwarf.Dwarf() called");
		health = GameConstants.DWARF_HEALTH;
		damage = GameConstants.DWARF_DAMAGE;
		rewardMana = GameConstants.DWARF_REWARD;
		maxCooldown = cooldown = GameConstants.DWARF_COOLDOWN;
		System.out.println("Dwarf.Dwarf() returned");
	}
	
	/**
	 * Dwarf with two parameter
	 * @param x
	 * @param y
	 */
	public Dwarf(int x, int y) {
		super(x, y);
		//TODO remove sysout
		System.out.println("Dwarf.Dwarf(x,y) called");
		health = GameConstants.DWARF_HEALTH;
		damage = GameConstants.DWARF_DAMAGE;
		rewardMana = GameConstants.DWARF_REWARD;
		maxCooldown = cooldown = GameConstants.DWARF_COOLDOWN;
		System.out.println("Dwarf.Dwarf(x,y) returned");
	}

	/**
	 * Dwarf with five parameter, attributes .
	 * @param x
	 * @param y
	 * @param health
	 * @param damage
	 * @param reward
	 */
	public Dwarf(int x, int y, int health, int damage, int reward) {
		super(x, y);
		//TODO remove sysout
		this.health = health;
		this.damage = damage;
		this.rewardMana = reward;
		maxCooldown = cooldown = GameConstants.DWARF_COOLDOWN;
		System.out.println("Dwarf.Dwarf(x,y,health,damage,reward) called");
		System.out.println("Dwarf.Dwarf(x,y,health,damage,reward) returned");
	}
	
	/* Return the amount of the reward for one dwarf killing.
	 * (non-Javadoc)
	 * @see team.uninter.mordorq.gamespace.EnemyTroop#getReward()
	 */
	public int getReward()
	{
		//TODO remove sysout
		// If the player kill an enemy from this kind, get the proper reward(mana) for each enemy of thespecific type(species)
		System.out.println("Dwarf.getReward() called");
		System.out.println("Dwarf.getReward() returned");
		return rewardMana;
		
	}
	/* Method how and how many damage get the dwarf.
	 * (non-Javadoc)
	 * @see team.uninter.mordorq.gamespace.EnemyTroop#interactWith(team.uninter.mordorq.gamespace.Tower.Missile)
	 */
	@Override
	public void interactWith(Missile missile) {
		//TODO remove sysout
		System.out.println("Dwarf.interactWith(Missile) called");
		this.setHealth(this.getHealth() - missile.getDwarfDamage());
		if(health <= 0 && currentGrid != null) currentGrid.remove();
		System.out.println("Dwarf.interactWith(Missile) returned");
		
	}
}
