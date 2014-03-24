package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.gamespace.Tower.Missile;

@SuppressWarnings("serial")
public class Hobbit extends EnemyTroop {

	protected Hobbit() {}
	
	protected Hobbit(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	protected int mana;
	public void setReward(int mana)
	{
		System.out.println("Hobbit.setReward() called");
		
		System.out.println("Hobbit.setReward() returned");
	}
	public int getReward()
	{
		System.out.println("Hobbit.getReward() called");
		System.out.println("Hobbit.getReward() returned");
		return mana;
		
	}
	@Override
	public void interactWith(Missile missile) {
		System.out.println("Hobbit.interactWith(Missile) called");
		System.out.println("Hobbit.interactWith(Missile) returned");
	}
}