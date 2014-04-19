package team.uninter.mordorq.gamespace;

import java.util.ArrayList;
import java.util.List;

import team.uninter.mordorq.gamespace.Tower.Missile;
import team.uninter.mordorq.utils.PathFinder;

@SuppressWarnings("serial")
abstract public class EnemyTroop extends DamageTaker implements Controlable{
	/**
	 * Class used to make a basic enemies, which will be the parent of all kind of species,enemies
	 *	It is set all common attributes,roles for all species, and how they will act at the scene.
	 **/
	
	/**
	 * All attributes for enemies and for their children. How many damage they can take on barricade,
	 * how many health they have, how fast they can move from a roadgrid to an another roadgrid.
	 * If they fall at the storm of the battle, how many mana (reward) will go to the player.
	 * 
	 */
	protected static int speciesCooldown;
	protected static int rewardMana;
	
	protected int cooldown;
	protected int maxCooldown;
	protected int damage;
	protected RoadGrid currentGrid;
	protected RoadGrid targetGrid;
	ArrayList<StatusModifier> statusModifiers;
	
	/**
	 * EnemyTroop no parameter (default)
	 */
	public EnemyTroop() {		
		super();
		statusModifiers = new ArrayList<StatusModifier>();
	} 
	
	/**
	 * EnemyTroop with two parameters
	 * @param x
	 * @param y
	 */
	public EnemyTroop(int x, int y) {
		super(x, y);
		statusModifiers = new ArrayList<StatusModifier>();
		this.maxCooldown = speciesCooldown;
		this.cooldown = this.maxCooldown;
	}
	
	/**EnemyTroop with five parameter, attributes.
	 * @param x
	 * @param y
	 * @param health
	 * @param damage
	 * @param reward
	 */
	public EnemyTroop(int x, int y, int health, int damage, int reward) {
		this(x, y);
		this.health = health;
		this.damage = damage;
		this.rewardMana = reward;
	}

	/** This class used to EnemyTroop act at scene, at grids.
	 * (non-Javadoc)
	 * @see team.uninter.mordorq.gamespace.Controlable#controlIt()
	 */
	public final void controlIt()
	{
		if(cooldown > 0){
			cooldown--;
			if(cooldown <= 0){
				targetGrid = PathFinder.findPathFrom(this.currentGrid);
				Vulnerable targetVulnerable = targetGrid.getVulnerable();
				if(targetVulnerable == null){
					currentGrid.remove();
					targetGrid.notifyAllWith(this);
				}
				else{
					targetVulnerable.interactWith(this);
				}
				
				Trap targetTrap = targetGrid.getTrap();
				if(targetTrap != null){
					targetTrap.affect(this);
				}
				
				cooldown = maxCooldown;
				return;
			}
		}
		for(StatusModifier sm : statusModifiers){
			sm.setDuration(sm.getDuration() - 1);
			if(sm.getDuration() <= 0){
				sm.reverseAffect(this);
				statusModifiers.remove(sm);
				return;
			}
		}
	}
	
	/**
	 * @return the maxCooldown
	 */
	public int getMaxCooldown() {
		return maxCooldown;
	}
	
	/**
	 * @param maxCooldown the maxCooldown to set
	 */
	public void setMaxCooldown(int maxCooldown) {
		this.maxCooldown = maxCooldown;
	}
	
	/**
	 * @return the rewardMana
	 */
	public int getRewardMana() {
		return rewardMana;
	}
	
	/**
	 * @param rewardMana the rewardMana to set
	 */
	public void setRewardMana(int rewardMana) {
		this.rewardMana = rewardMana;
	}

	/**
	 * THis class set the troops current grids.
	 * @param grid
	 */
	public final void setCurrentGrid(RoadGrid grid){
		this.currentGrid = grid;
	}
	
	public final RoadGrid getCurrentGrid() {
		return this.currentGrid;
	}

	/*This class used to check if a troop have more health than 0. 
	 * If not....the troop is not active more, means the trrop is dead.
	 *  (non-Javadoc)
	 * @see team.uninter.mordorq.gamespace.Controlable#isActive()
	 */
	public final boolean isActive() {
		return health > 0;
	}

	public final void interactWith(EnemyTroop troop)	{}
	
	public final void interactWith(Missile missile){
		if(Math.random()*1000 - 2 <= 0) split(currentGrid);
		speciesInteractWith(missile);
	}
	
	protected abstract EnemyTroop createClone(int health);
	
	/**
	 * Recursive method for cloning this instance and finding the first
	 * free grid for it.
	 * 
	 * @param grid onto which we want to place the clone or from which the search starts
	 * @return true only if the clone could be placed
	 * */
	private boolean split(RoadGrid grid){
		if(grid.getVulnerable() == null){
			int h;
			this.setHealth((h = this.getHealth()/2));
			grid.notifyAllWith(createClone(h));
			return true;
		}
		for(Neighbour n : Neighbour.values())
			if(grid.get(n).getUtility() > 0 && split((RoadGrid)grid.get(n)))
				return true;
		return false;
	}
	
	protected abstract void speciesInteractWith(Missile missile);
	
	/** Troop get a modifier for their status from a magic or trap.
	 * @param sm
	 */
	public final void add(StatusModifier sm)	{
		this.statusModifiers.add(sm);
	}
	
	/**Modifier all troop status.
	 * @param sm
	 */
	public final void addAll(List<StatusModifier> sm) {
		for(StatusModifier statusModifier : sm){
			this.add(statusModifier);
		}
	}
	
	public final List<StatusModifier> getModifiers() {
		return this.statusModifiers;
	}
	
	/** Return with the value of the troop damage
	 * @return
	 */
	public final int getDamage() {
		return this.damage;		
	}
	
	/** This method set the value of the troop damage.
	 * @param damage
	 */
	public final void setDamage(int damage) {
		this.damage = damage;
	}

	/** Return the current value of Cooldown.
	 * @return
	 */
	public final int getCooldown() {
		return cooldown;	
	}
	
	/** This method can set the value of the cooldown
	 * @param cooldown
	 */
	public final void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}
	
	public abstract int getReward();

}
