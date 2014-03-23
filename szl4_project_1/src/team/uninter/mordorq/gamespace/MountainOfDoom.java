package team.uninter.mordorq.gamespace;
import java.util.*;

import team.uninter.mordorq.ApplicationContext;
import team.uninter.mordorq.gamespace.Tower.Missile;
import team.uninter.mordorq.skeleton.Skeleton;
import team.uninter.mordorq.gamespace.EnemyTroop;

@SuppressWarnings("serial")
public class MountainOfDoom extends DamageTaker{
	private static MountainOfDoom instance = null;
 
	private MountainOfDoom() {	}
	protected int health = 1;
	public static synchronized MountainOfDoom getInstance() {
		if (instance == null) {
                	instance = new MountainOfDoom ();
		}
		return instance;
	}

	public void setHealth(int healthDiff )
	{
		health-= troop.getDamage;
	}
	@Override
	public void interactWith(EnemyTroop troop)
	{
		System.out.println("MountainOfDoom.interactWith(EnemyTroop) called");
		System.out.println("MountainOfDoom.interactWith(EnemyTroop) returned");
	}

	@Override
	public void interactWith(Missile missile) {
		// TODO Auto-generated method stub, ez marad üres is.
		
	}
}