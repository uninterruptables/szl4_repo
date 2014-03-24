package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.skeleton.TroopStepSimulator;
import team.uninter.mordorq.utils.GameConstants;

@SuppressWarnings("serial")
public class Gimli extends Dwarf{
	//class representing one of the few bosses, that will show up once during the game.
	//An enemyTroop, a dwarf, exactly, with special values
	 private static Gimli instance = null;

	 private Gimli(int health, int damage){
		  super();
		  //TODO remove sysout
		  System.out.println("Gimli.Gimli(health,damage) called");
		  this.health = health;
		  this.damage = damage;
		  System.out.println("Gimli.Gimli(health,damage) returned");
	  }

	 public static Gimli getInstance(){
		  //TODO remove sysout
		  System.out.println("Gimli.getInstance() called");
		  if(instance == null){
			  instance = new Gimli(GameConstants.GIMLI_HEALTH, GameConstants.GIMLI_DAMAGE);
		  }
		  System.out.println("Gimli.getInstance() returned");
		  return instance;
	  }
}