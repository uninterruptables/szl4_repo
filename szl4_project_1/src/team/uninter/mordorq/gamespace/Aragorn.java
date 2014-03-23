package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.skeleton.TroopStepSimulator;

@SuppressWarnings("serial")
public class Aragorn extends Human{

	  private static final Aragorn INSTANCE = new Aragorn();

	  protected Aragorn(){
		  super.health = 200;
		  super.damage = 200;
	  }

	  public static Aragorn getInstance(){
		  return INSTANCE;
	  }
}