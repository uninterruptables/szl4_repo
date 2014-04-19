package team.uninter.mordorq.gamespace;
import java.util.*;

import team.uninter.mordorq.ApplicationContext;
import team.uninter.mordorq.gamespace.Tower.Missile;
import team.uninter.mordorq.skeleton.Skeleton;
import team.uninter.mordorq.gamespace.EnemyTroop;

@SuppressWarnings("serial")
public class MountainOfDoom extends DamageTaker{
	private static MountainOfDoom instance = null;
 //Special class at the program, only role is to tell the player,
 //he lost the game if any of the enemies reach this on the scene
	private Scene owner;
	
	private MountainOfDoom(Scene owner) {
		this.owner = owner;
	}
	private MountainOfDoom() {}
	protected int health = 1; // If an enemy reach the MountainOfDoom, the game will be end. It is symbolic life.
	public static synchronized MountainOfDoom getInstance(Scene scene) {
		if (instance == null) {
                	instance = new MountainOfDoom(scene);
		}
		return instance;
	}

	@Override
	public void interactWith(EnemyTroop troop)
	{// class tell to the player, the game is end and lost. Game will be stopped.
//		System.out.println("MountainOfDoom.interactWith(EnemyTroop) called");
		owner.endGame(false);
//		System.out.println("MountainOfDoom.interactWith(EnemyTroop) returned");
	}

	@Override
	public void interactWith(Missile missile) {
		// TODO Auto-generated method stub, ez marad �res is.
		
	}
}