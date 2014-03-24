package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.skeleton.TroopStepSimulator;
import team.uninter.mordorq.utils.GameConstants;

@SuppressWarnings("serial")
public class Aragorn extends Human{
	//class representing one of the few bosses, that will show up once during the game.
	//An enemyTroop, a human, exactly, with special values
	
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