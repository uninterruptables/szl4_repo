package team.uninter.mordorq.gamespace;
import java.util.*;

import team.uninter.mordorq.gamespace.Tower.Missile;

@SuppressWarnings("serial")
public class MountainOfDoom extends DamageTaker{
	private static MountainOfDoom instance = null;
 
	private MountainOfDoom() {	}
 
	public static synchronized MountainOfDoom getInstance() {
		if (instance == null) {
                	instance = new MountainOfDoom ();
		}
		return instance;
	}

	@Override
	public void interactWith(EnemyTroop troop) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interactWith(Missile missile) {
		// TODO Auto-generated method stub, ez marad üres is.
		
	}
}