package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.gamespace.Tower.Missile;

@SuppressWarnings("serial")
public class Elf extends EnemyTroop {
// Specific EnemyTroop, called Elf. Have less life then other specific troop, more speed, and a little more damage
	protected Elf() {}
	
	protected Elf(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	protected int mana;
	public void setReward(int mana)
	{// Set the amount of the reward
		System.out.println("Elf.setReward() called");
		
		System.out.println("Elf.setReward() returned");
	}
	public int getReward()
	{// If the player kill an enemy from this kind, get the proper reward(mana) for each enemy of thespecific type(species)
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
