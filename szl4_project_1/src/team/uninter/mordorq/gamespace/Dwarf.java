package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.gamespace.Tower.Missile;

@SuppressWarnings("serial")
public class Dwarf extends EnemyTroop {
	// Specific EnemyTroop, called Dwarf. Have much more life then other specific troop, less speed, and a little more damage
	protected Dwarf() {}
	
	protected Dwarf(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	protected int mana;
	public void setReward(int mana)
	{// Set the amount of the reward
		System.out.println("Dwarf.setReward() called");
		
		System.out.println("Dwarf.setReward() returned");
	}
	public int getReward()
	{// If the player kill an enemy from this kind, get the proper reward(mana) for each enemy of thespecific type(species)
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
