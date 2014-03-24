package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.skeleton.TroopStepSimulator;
import team.uninter.mordorq.utils.GameConstants;

/**
 * @author Danyik Dávid
 * Singleton class of the Dwarf race bosses, Gimli. It have special health and damage value not like the extended class
 * troops. There is only one of this troop.
 */
@SuppressWarnings("serial")
public class Gimli extends Dwarf{

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