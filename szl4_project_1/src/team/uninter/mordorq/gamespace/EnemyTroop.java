package team.uninter.mordorq.gamespace;

import java.util.ArrayList;
import java.util.List;

import team.uninter.mordorq.gamespace.Tower.Missile;

@SuppressWarnings("serial")
abstract public class EnemyTroop extends DamageTaker implements Controlable{

	protected int cooldown;
	protected int MaxCooldown;
	protected float damage;
	protected int health;
	protected int mana;
	public int currenGrid;
	public int targetGrid;
	ArrayList<StatusModifier> sm;
	
	protected EnemyTroop(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

final public void controlIt()
{
		EnemyTroop.controlIt();
}

public void addAll(List<StatusModifier> modifiers){}
public void setCurrentGrid(RoadGrid)
{
	System.out.println("EnemyTroop.setCurrentGrid(RoadGrid) called");
	System.out.println("EnemyTroop.setCurrentGrid(RoadGrid) returned");
}

public boolean isActive()
{
	System.out.println("EnemyTroop.isActive() called");
	System.out.println("EnemyTroop.isActive() returned");
}

public void interactWith(EnemyTroop troop)
{
	System.out.println("EnemyTroop.interactWith(EnemyTroop) called");
	System.out.println("EnemyTroop.interactWith(EnemyTroop) returned");	
}
public abstract void interactWith(Missile missile); 
private void add(StatusModifier sm)
{
	System.out.println("EnemyTroop.add(StatusModifier) called");
	System.out.println("EnemyTroop.add(StatusModifier) returned");		
}
public int getDamage()
{
	System.out.println("EnemyTroop.getDamage() called");
	System.out.println("EnemyTroop.getDamage() returned");		
}
public int setDamage(int damage)
{
	System.out.println("EnemyTroop.setDamage(damage) called");
	System.out.println("EnemyTroop.setDamage(damage) returned");	
}
public int getHealth()
{
	System.out.println("EnemyTroop.getHealth() called");
	System.out.println("EnemyTroop.getHealth() returned");	
}
public int setHealth(int health)
{
	System.out.println("EnemyTroop.setHealth(health) called");
	System.out.println("EnemyTroop.setHealth(health) returned");	
}
public int getCooldown()
{
	System.out.println("EnemyTroop.getCooldown() called");
	System.out.println("EnemyTroop.getCooldown() returned");	
}
public int setCooldown(int cooldown)
{
	System.out.println("EnemyTroop.setCooldown(cooldown) called");
	System.out.println("EnemyTroop.setCooldown(cooldown) returned");	
}
public abstract int getReward();


}