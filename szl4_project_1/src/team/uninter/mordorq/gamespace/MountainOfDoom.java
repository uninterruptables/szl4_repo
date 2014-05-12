package team.uninter.mordorq.gamespace;

import java.io.File;

import team.uninter.mordorq.gamespace.Tower.Missile;

@SuppressWarnings("serial")
public class MountainOfDoom extends DamageTaker {
	private static MountainOfDoom instance = null;
	// Special class at the program, only role is to tell the player,
	// he lost the game if any of the enemies reach this on the scene
	
	static {
		tryLoad(new File("resources/images/Mount_Doom_16_48.png"));
	}
	
	private Scene owner;

	private MountainOfDoom(Scene owner) {
		super();
		this.owner = owner;
		this.health = 1;
	}

	public static synchronized MountainOfDoom getInstance(Scene scene) {
		if (instance == null) {
			instance = new MountainOfDoom(scene);
		}
		return instance;
	}

	@Override
	public void interactWith(EnemyTroop troop) {
		owner.endGame(false);
	}

	@Override
	public void interactWith(Missile missile) {
	}
}