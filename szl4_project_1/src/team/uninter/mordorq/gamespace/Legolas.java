package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.skeleton.TroopStepSimulator;

@SuppressWarnings("serial")
public class Legolas extends Elf{
	//Singleton class used to play Elf Boss, have special attribution(health, damage)
	 private static final Legolas INSTANCE = new Legolas();
	//Special value for the boss.
	  protected Legolas(){
		  super.health = 400;
		  super.damage = 150;
	  }

	  public static Legolas getInstance(){
		  return INSTANCE;
	  }
}