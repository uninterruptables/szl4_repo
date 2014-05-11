package team.uninter.mordorq.gamespace;



import java.io.File;
import java.io.IOException;

import team.uninter.mordorq.skeleton.TroopStepSimulator;
import team.uninter.mordorq.utils.GameConstants;

import javax.imageio.*;

/**
 * @author Danyik Dávid
 * Singleton class of the human race bosses, Aragorn. It have special health and damage value not like the extended class
 * troops. There is only one of this troop.
 */
@SuppressWarnings("serial")
public class Aragorn extends Human{
	
 
	 private static Aragorn instance = null;
		
	 
	  private Aragorn(int health, int damage, int reward){
		  super();
		  try {
	           image = ImageIO.read(new File("/resources/images/aragorn_16p.jpg"));
	       } catch (IOException e) {
	       }

		  //TODO remove sysout
//		  System.out.println("Aragorn.Aragorn(health,damage) called");
		  this.health = health;
		  this.damage = damage;
		  this.rewardMana = reward;
		  
//		  System.out.println("Aragorn.Aragorn(health,damage) returned");
	  }

	  public static Aragorn getInstance(){
		  //TODO remove sysout
//		  System.out.println("Aragorn.getInstance() called");
		  if(instance == null){
			  instance = new Aragorn(GameConstants.ARAGORN_HEALTH, GameConstants.ARAGORN_DAMAGE, GameConstants.ARAGORN_REWARD);
		  }
//		  System.out.println("Aragorn.getInstance() returned");
		  return instance;
	  }
	 
}
