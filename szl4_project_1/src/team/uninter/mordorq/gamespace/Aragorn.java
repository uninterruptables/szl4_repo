package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.skeleton.TroopStepSimulator;

@SuppressWarnings("serial")
public class Aragorn extends Human{
//Singleton class used to play Human Boss, have special attributions(health, damage)
	  private static final Aragorn INSTANCE = new Aragorn();
//Special value for the boss.
	  protected Aragorn(){
		  super.health = 200;
		  super.damage = 200;
	  }

	  public static Aragorn getInstance(){
		  return INSTANCE;
	  }
}