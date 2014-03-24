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
	{
		System.out.println("Human.setReward() called");
		
		System.out.println("Human.setReward() returned");
	}
	public int getReward()
	{
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
