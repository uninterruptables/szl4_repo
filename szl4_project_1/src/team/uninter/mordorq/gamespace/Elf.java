package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.gamespace.Tower.Missile;

@SuppressWarnings("serial")
public class Elf extends EnemyTroop {

	protected Elf() {}
	
	protected Elf(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	protected int mana;
	public void setReward(int mana)
	{
		System.out.println("Elf.setReward() called");
		
		System.out.println("Elf.setReward() returned");
	}
	public int getReward()
	{
		System.out.println("Elf.getReward() called");
		System.out.println("Elf.getReward() returned");
		return mana;
		
	}
	@Override
	public void interactWith(Missile missile) {
		System.out.println("Elf.interactWith(Missile) called");
		System.out.println("Elf.interactWith(Missile) returned");
		
	}
}
