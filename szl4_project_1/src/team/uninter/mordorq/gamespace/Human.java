package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.gamespace.Tower.Missile;

@SuppressWarnings("serial")
public class Human extends EnemyTroop {
	// Specific EnemyTroop, called Human. It could be named "basic" troop, others will be compare to this.
	//Have average life, speed and damage
	protected Human() {}
	
	protected Human(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	protected int mana;
	public void setReward(int mana)
	{// Set the amount of the reward
		System.out.println("Human.setReward() called");
		
		System.out.println("Human.setReward() returned");
	}
	public int getReward()
	{// If the player kill an enemy from this kind, get the proper reward(mana) for each enemy of thespecific type(species)
		System.out.println("Human.getReward() called");
		System.out.println("Human.getReward() returned");
		return mana;
		
	}
	@Override
	public void interactWith(Missile missile) {
		System.out.println("Human.interactWith(Missile) called");
		System.out.println("Human.interactWith(Missile) returned");
		
	}
}
