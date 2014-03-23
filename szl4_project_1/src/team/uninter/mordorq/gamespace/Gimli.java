package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.skeleton.TroopStepSimulator;

@SuppressWarnings("serial")
public class Gimli extends Dwarf{

	 private static final Gimli INSTANCE = new Gimli();

	  protected Gimli(){
		  super.health = 800;
		  super.damage = 250;
	  }

	  public static Gimli getInstance(){
		  return INSTANCE;
	  }
}