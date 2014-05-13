package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.utils.GameConstants;

public class Nazgul extends Magic{

	//Class used to simulate a magical spell, that applies a weaken status on every unit on the map
	public Nazgul() {
		super();
		effects.add(new WeakenStatus(GameConstants.NAZGUL_MAGIC_STRENGHT, GameConstants.NAZGUL_MAGIC_DURATION));	
		this.manaCost = GameConstants.NAZGUL_MAGIC_COST;
	}
	public Nazgul(int x, int y) {
		super(x, y);
		effects.add(new WeakenStatus(GameConstants.NAZGUL_MAGIC_STRENGHT, GameConstants.NAZGUL_MAGIC_DURATION));	
		this.manaCost = GameConstants.NAZGUL_MAGIC_COST;
	}

}