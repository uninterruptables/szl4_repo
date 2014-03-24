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
	protected int cooldown;
	protected int MaxCooldown;
	protected int damage;
	protected int health;
	protected int rewardMana;
	protected RoadGrid currentGrid;
	protected RoadGrid targetGrid;
	ArrayList<StatusModifier> statusModifiers;
	
	/**
	 * EnemyTroop no parameter (default)
	 */
	public EnemyTroop() {
		
		super();
		//TODO remove sysout
		System.out.println("EnemyTroop.EnemyTroop() called");
		System.out.println("EnemyTroop.EnemyTroop() returned");
	} 
	
	/**
	 * EnemyTroop with two parameters
	 * @param x
	 * @param y
	 */
	public EnemyTroop(int x, int y) {
		super(x, y);
		//TODO remove sysout
		System.out.println("EnemyTroop.EnemyTroop(x,y) called");
		System.out.println("EnemyTroop.EnemyTroop(x,y) returned");
	}
	
	/**EnemyTroop with five parameter, attributes.
	 * @param x
	 * @param y
	 * @param health
	 * @param damage
	 * @param reward
	 */
	public EnemyTroop(int x, int y, int health, int damage, int reward) {
		super(x, y);
		//TODO remove sysout
		this.health = health;
		this.damage = damage;
		this.rewardMana = reward;
		System.out.println("EnemyTroop.EnemyTroop(x,y,health,damage,reward) called");
		System.out.println("EnemyTroop.EnemyTroop(x,y,health,damage,reward) returned");
	}

	/* This class used to EnemyTroop act at scene, at grids.
	 * (non-Javadoc)
	 * @see team.uninter.mordorq.gamespace.Controlable#controlIt()
	 */
	public final void controlIt()
	{
		//TODO remove sysout
		System.out.println("EnemyTroop.controlIt()) called");
		targetGrid = PathFinder.findPathFrom(this.currentGrid);
		Vulnerable targetVulnerable = targetGrid.getVulnerable();
		if(targetVulnerable == null){
			targetGrid.setVulnerable(this);
		}
		else{
			targetVulnerable.interactWith(this);
		}
		
		Trap targetTrap = targetGrid.getTrap();
		if(targetTrap != null){
			targetTrap.affect(this);
		}
		System.out.println("EnemyTroop.controlIt() returned");	
	}

	/**
	 * THis class set the troops current grids.
	 * @param grid
	 */
	public final void setCurrentGrid(RoadGrid grid)
	{
		//TODO remove sysout
		System.out.println("EnemyTroop.setCurrentGrid(RoadGrid) called");
		this.currentGrid = grid;
		System.out.println("EnemyTroop.setCurrentGrid(RoadGrid) returned");
	}

	/*This class used to check if a troop have more health than 0. 
	 * If not....the troop is not active more, means the trrop is dead.
	 *  (non-Javadoc)
	 * @see team.uninter.mordorq.gamespace.Controlable#isActive()
	 */
	public final boolean isActive()
	{
		//TODO remove sysout
		System.out.println("EnemyTroop.isActive() called");
		if(health > 0){
			System.out.println("EnemyTroop.isActive() returned true");
			return true;
		}
		else{
			System.out.println("EnemyTroop.isActive() returned false");
			return false;
		}
	}

	public final void interactWith(EnemyTroop troop)
	{
		//TODO remove sysout
		System.out.println("EnemyTroop.interactWith(EnemyTroop) called");
		//do nothing
		System.out.println("EnemyTroop.interactWith(EnemyTroop) returned");	
	}
	
	public abstract void interactWith(Missile missile);
	
	/** Troop get a modifier for their status from a magic or trap.
	 * @param sm
	 */
	public final void add(StatusModifier sm)
	{
		//TODO remove sysout
		System.out.println("EnemyTroop.add(StatusModifier) called");
		this.statusModifiers.add(sm);
		System.out.println("EnemyTroop.add(StatusModifier) returned");		
	}
	
	/**Modifier all troop status.
	 * @param sm
	 */
	public final void addAll(List<StatusModifier> sm)
	{
		//TODO remove sysout
		System.out.println("EnemyTroop.addAll(List<StatusModifier>) called");
		for(StatusModifier statusModifier : sm){
			this.add(statusModifier);
		}
		System.out.println("EnemyTroop.addAll(List<StatusModifier>) returned");		
	}
	
	/** Return with the value of the troop damage
	 * @return
	 */
	public final int getDamage()
	{
		//TODO remove sysout
		System.out.println("EnemyTroop.getDamage() called");
		System.out.println("EnemyTroop.getDamage() returned");
		return this.damage;		
	}
	
	/** This method set the value of the troop damage.
	 * @param damage
	 */
	public final void setDamage(int damage)
	{
		//TODO remove sysout
		System.out.println("EnemyTroop.setDamage(damage) called");
		this.damage = damage;
		System.out.println("EnemyTroop.setDamage(damage) returned");	
	}
	
	/* Return with the troop health 
	 * (non-Javadoc)
	 * @see team.uninter.mordorq.gamespace.DamageTaker#getHealth()
	 */
	public final int getHealth()
	{
		//TODO remove sysout
		System.out.println("EnemyTroop.getHealth() called");
		System.out.println("EnemyTroop.getHealth() returned");
		return this.health;	
	}

	/** Return the current value of Cooldown.
	 * @return
	 */
	public final int getCooldown()
	{
		//TODO remove sysout
		System.out.println("EnemyTroop.getCooldown() called");
		System.out.println("EnemyTroop.getCooldown() returned");
		return cooldown;	
	}
	
	/** This method can set the value of the cooldown
	 * @param cooldown
	 */
	public final void setCooldown(int cooldown)
	{
		//TODO remove sysout
		System.out.println("EnemyTroop.setCooldown(cooldown) called");
		this.cooldown = cooldown;
		System.out.println("EnemyTroop.setCooldown(cooldown) returned");	
	}
	
	public abstract int getReward();

}