package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.skeleton.TroopStepSimulator;

@SuppressWarnings("serial")
public class Gimli extends Dwarf{
	//Singleton class used to play Dwarf Boss, have special attributions(health, damage)
	 private static final Gimli INSTANCE = new Gimli();
	//Special value for the boss.
	  protected Gimli(){
		  super.health = 800;
		  super.damage = 250;
	  }

	  public static Gimli getInstance(){
		  return INSTANCE;
	  }
}