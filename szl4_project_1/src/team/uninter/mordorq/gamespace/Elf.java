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
		health = GameConstants.ELF_HEALTH;
		damage = GameConstants.ELF_DAMAGE;
		rewardMana = GameConstants.ELF_REWARD;
		maxCooldown = cooldown = GameConstants.ELF_COOLDOWN;
	}
	
	/**
	 * Elf with two parameter.
	 * @param x
	 * @param y
	 */
	public Elf(int x, int y) {
		super(x, y);
		health = GameConstants.ELF_HEALTH;
		damage = GameConstants.ELF_DAMAGE;
		rewardMana = GameConstants.ELF_REWARD;
		maxCooldown = cooldown = GameConstants.ELF_COOLDOWN;
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
		this.health = health;
		this.damage = damage;
		this.rewardMana = reward;
		maxCooldown = cooldown = GameConstants.ELF_COOLDOWN;
	}
	
	protected EnemyTroop createClone(int health){
		return new Elf(x, y, health, damage, rewardMana);
	}
	
	/* Return the amount of the reward for one elf killing.
	 * (non-Javadoc)
	 * @see team.uninter.mordorq.gamespace.EnemyTroop#getReward()
	 */
	public int getReward() {
		return rewardMana;		
	}
	
	/* Method how and how many damage get the elf.
	 * (non-Javadoc)
	 * @see team.uninter.mordorq.gamespace.EnemyTroop#interactWith(team.uninter.mordorq.gamespace.Tower.Missile)
	 */

	@Override
	protected void speciesInteractWith(Missile missile) {
		this.setHealth(this.getHealth() - missile.getElfDamage());
		if(health <= 0 && currentGrid != null) currentGrid.remove();
	}
}
