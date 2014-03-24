package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.skeleton.TroopStepSimulator;
import team.uninter.mordorq.utils.GameConstants;

@SuppressWarnings("serial")
public class Legolas extends Elf{
	//class representing one of the few bosses, that will show up once during the game.
	//An enemyTroop, an elf, exactly, with special values
	 private static Legolas instance = null;

	 private Legolas(int health, int damage){
		  super();
		  //TODO remove sysout
		  System.out.println("Legolas.Legolas(health,damage) called");
		  this.health = health;
		  this.damage = damage;
		  System.out.println("Legolas.Legolas(health,damage) returned");
	  }

	 public static Legolas getInstance(){
		  //TODO remove sysout
		  System.out.println("Legolas.getInstance() called");
		  if(instance == null){
			  instance = new Legolas(GameConstants.LEGOLAS_HEALTH, GameConstants.LEGOLAS_DAMAGE);
		  }
		  System.out.println("Legolas.getInstance() returned");
		  return instance;
	  }
}