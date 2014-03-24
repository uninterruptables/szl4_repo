package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.gamespace.Tower.Missile;

@SuppressWarnings("serial")
public class Dwarf extends EnemyTroop {

	protected Dwarf() {}
	
	protected Dwarf(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	protected int mana;
	public void setReward(int mana)
	{
		System.out.println("Dwarf.setReward() called");
		
		System.out.println("Dwarf.setReward() returned");
	}
	public int getReward()
	{
		System.out.println("Dwarf.getReward() called");
		System.out.println("Dwarf.getReward() returned");
		return mana;
		
	}
	@Override
	public void interactWith(Missile missile) {
		System.out.println("Dwarf.interactWith(Missile) called");
		System.out.println("Dwarf.interactWith(Missile) returned");
		
	}
}
