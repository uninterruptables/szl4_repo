package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.skeleton.TroopStepSimulator;
import team.uninter.mordorq.utils.GameConstants;

/**
 * @author Danyik Dávid
 * Singleton class of the Elf race bosses, Legolas. It have special health and damage value not like the extended class
 * troops. There is only one of this troop.
 */
@SuppressWarnings("serial")
public class Legolas extends Elf{
	
	 private static Legolas instance = null;

	 private Legolas(int health, int damage, int reward){
		  super();
		  //TODO remove sysout
//		  System.out.println("Legolas.Legolas(health,damage) called");
		  this.health = health;
		  this.damage = damage;
		  this.rewardMana = reward;
//		  System.out.println("Legolas.Legolas(health,damage) returned");
	  }

	 public static Legolas getInstance(){
		  //TODO remove sysout
//		  System.out.println("Legolas.getInstance() called");
		  if(instance == null){
			  instance = new Legolas(GameConstants.LEGOLAS_HEALTH, GameConstants.LEGOLAS_DAMAGE, GameConstants.LEGOLAS_REWARD);
		  }
//		  System.out.println("Legolas.getInstance() returned");
		  return instance;
	  }
}
