package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.skeleton.TroopStepSimulator;

@SuppressWarnings("serial")
public class Legolas extends Elf{

	 private static final Legolas INSTANCE = new Legolas();

	  protected Legolas(){
		  super.health = 400;
		  super.damage = 150;
	  }

	  public static Legolas getInstance(){
		  return INSTANCE;
	  }
}