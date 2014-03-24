package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.skeleton.TroopStepSimulator;
import team.uninter.mordorq.utils.GameConstants;

/**
 * @author Danyik Dávid
 * Singleton class of the human race bosses, Aragorn. It have special health and damage value not like the extended class
 * troops. There is only one of this troop.
 */
@SuppressWarnings("serial")
public class Aragorn extends Human{
	
	  private static Aragorn instance = null;

	  private Aragorn(int health, int damage){
		  super();
		  //TODO remove sysout
		  System.out.println("Aragorn.Aragorn(health,damage) called");
		  this.health = health;
		  this.damage = damage;
		  System.out.println("Aragorn.Aragorn(health,damage) returned");
	  }

	  public static Aragorn getInstance(){
		  //TODO remove sysout
		  System.out.println("Aragorn.getInstance() called");
		  if(instance == null){
			  instance = new Aragorn(GameConstants.ARAGORN_HEALTH, GameConstants.ARAGORN_DAMAGE);
		  }
		  System.out.println("Aragorn.getInstance() returned");
		  return instance;
	  }
}
