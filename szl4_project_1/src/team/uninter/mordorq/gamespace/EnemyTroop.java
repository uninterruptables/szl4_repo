package team.uninter.mordorq.gamespace;

import java.util.ArrayList;
import java.util.List;

import team.uninter.mordorq.gamespace.Tower.Missile;
import team.uninter.mordorq.utils.PathFinder;

@SuppressWarnings("serial")
abstract public class EnemyTroop extends DamageTaker implements Controlable{
// Class used to make a basic enemies, which will be the parent of all kind of species,enemies
//It is set all common attributes,roles for all species, and how they will act at the scene.
	protected int cooldown;
	protected int MaxCooldown;
	protected int damage;
	protected int health;
	protected int rewardMana;
	protected RoadGrid currentGrid;
	protected RoadGrid targetGrid;
	ArrayList<StatusModifier> statusModifiers;
	
	public EnemyTroop() {
		super();
		//TODO remove sysout
		System.out.println("EnemyTroop.EnemyTroop() called");
		System.out.println("EnemyTroop.EnemyTroop() returned");
	} 
	
	public EnemyTroop(int x, int y) {
		super(x, y);
		//TODO remove sysout
		System.out.println("EnemyTroop.EnemyTroop(x,y) called");
		System.out.println("EnemyTroop.EnemyTroop(x,y) returned");
	}
	
	public EnemyTroop(int x, int y, int health, int damage, int reward) {
		super(x, y);
		//TODO remove sysout
		this.health = health;
		this.damage = damage;
		this.rewardMana = reward;
		System.out.println("EnemyTroop.EnemyTroop(x,y,health,damage,reward) called");
		System.out.println("EnemyTroop.EnemyTroop(x,y,health,damage,reward) returned");
	}

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

	public final void setCurrentGrid(RoadGrid grid)
	{
		//TODO remove sysout
		System.out.println("EnemyTroop.setCurrentGrid(RoadGrid) called");
		this.currentGrid = grid;
		System.out.println("EnemyTroop.setCurrentGrid(RoadGrid) returned");
	}

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
	
	public final void add(StatusModifier sm)
	{
		//TODO remove sysout
		System.out.println("EnemyTroop.add(StatusModifier) called");
		this.statusModifiers.add(sm);
		System.out.println("EnemyTroop.add(StatusModifier) returned");		
	}
	
	public final int getDamage()
	{
		//TODO remove sysout
		System.out.println("EnemyTroop.getDamage() called");
		System.out.println("EnemyTroop.getDamage() returned");
		return this.damage;		
	}
	
	public final void setDamage(int damage)
	{
		//TODO remove sysout
		System.out.println("EnemyTroop.setDamage(damage) called");
		this.damage = damage;
		System.out.println("EnemyTroop.setDamage(damage) returned");	
	}
	
	public final int getHealth()
	{
		//TODO remove sysout
		System.out.println("EnemyTroop.getHealth() called");
		System.out.println("EnemyTroop.getHealth() returned");
		return this.health;	
	}

	public final int getCooldown()
	{
		//TODO remove sysout
		System.out.println("EnemyTroop.getCooldown() called");
		System.out.println("EnemyTroop.getCooldown() returned");
		return cooldown;	
	}
	
	public final void setCooldown(int cooldown)
	{
		//TODO remove sysout
		System.out.println("EnemyTroop.setCooldown(cooldown) called");
		this.cooldown = cooldown;
		System.out.println("EnemyTroop.setCooldown(cooldown) returned");	
	}
	
	public abstract int getReward();

}