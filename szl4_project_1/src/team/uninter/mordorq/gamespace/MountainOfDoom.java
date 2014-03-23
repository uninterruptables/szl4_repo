package team.uninter.mordorq.gamespace;
import java.util.*;

import team.uninter.mordorq.ApplicationContext;
import team.uninter.mordorq.gamespace.Tower.Missile;
import team.uninter.mordorq.skeleton.Skeleton;
import team.uninter.mordorq.gamespace.EnemyTroop;

@SuppressWarnings("serial")
public class MountainOfDoom extends DamageTaker{
	private static MountainOfDoom instance = null;
 
	private Scene owner;
	
	private MountainOfDoom(Scene owner) {
		this.owner = owner;
	}
	private MountainOfDoom() {}
	protected int health = 1;
	public static synchronized MountainOfDoom getInstance(Scene scene) {
		if (instance == null) {
                	instance = new MountainOfDoom (scene);
		}
		return instance;
	}

	public void setHealth(int healthDiff )
	{
	
	}
	@Override
	public void interactWith(EnemyTroop troop)
	{
		System.out.println("MountainOfDoom.interactWith(EnemyTroop) called");
		owner.endGame(false);
		System.out.println("MountainOfDoom.interactWith(EnemyTroop) returned");
	}

	@Override
	public void interactWith(Missile missile) {
		// TODO Auto-generated method stub, ez marad �res is.
		
	}
}