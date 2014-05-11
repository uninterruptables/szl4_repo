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
		health = GameConstants.DWARF_HEALTH;
		damage = GameConstants.DWARF_DAMAGE;
		rewardMana = GameConstants.DWARF_REWARD;
		maxCooldown = cooldown = GameConstants.DWARF_COOLDOWN;
	}
	
	/**
	 * Dwarf with two parameter
	 * @param x
	 * @param y
	 */
	public Dwarf(int x, int y) {
		super(x, y);
		health = GameConstants.DWARF_HEALTH;
		damage = GameConstants.DWARF_DAMAGE;
		rewardMana = GameConstants.DWARF_REWARD;
		maxCooldown = cooldown = GameConstants.DWARF_COOLDOWN;
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
		this.health = health;
		this.damage = damage;
		this.rewardMana = reward;
		maxCooldown = cooldown = GameConstants.DWARF_COOLDOWN;
	}
	
	protected EnemyTroop createClone(int health){
		return new Dwarf(x, y, health, damage, rewardMana);
	}
	
	/* Return the amount of the reward for one dwarf killing.
	 * (non-Javadoc)
	 * @see team.uninter.mordorq.gamespace.EnemyTroop#getReward()
	 */
//	public int getReward() {
//		return rewardMana;		
//	}
	
	/* Method how and how many damage get the dwarf.
	 * (non-Javadoc)
	 * @see team.uninter.mordorq.gamespace.EnemyTroop#interactWith(team.uninter.mordorq.gamespace.Tower.Missile)
	 */
	@Override
	protected void speciesInteractWith(Missile missile) {
		this.setHealth(this.getHealth() - missile.getDwarfDamage());
		if(health <= 0 && currentGrid != null) currentGrid.remove();
	}
}
