package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.utils.GameConstants;

public class Nazgul extends Magic{

	//Class used to simulate a magical spell, that applies a weaken status on every unit on the map
	public Nazgul() {
		super();
//		System.out.println("Nazgul() called");
		effects.add(new WeakenStatus());	
		this.manaCost = GameConstants.NAZGUL_MAGIC_COST;
//		System.out.println("Nazgul() returned");
	}
	public Nazgul(int x, int y) {
		super(x, y);
		effects.add(new WeakenStatus());	
		this.manaCost = GameConstants.NAZGUL_MAGIC_COST;
//		System.out.println("Nazgul(Int, Int) called");
//		System.out.println("Nazgul(Int, Int) returned");
	}

}
