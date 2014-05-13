package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.utils.GameConstants;

public class PoisonFogMagic extends Magic{

	//Class used to simulate a magical spell, that applies a poison status on every unit on the map
	public PoisonFogMagic() {
		super();
		effects.add(new PoisonStatus(GameConstants.POISON_FOG_MAGIC_STRENGHT,GameConstants.POISON_FOG_MAGIC_DURATION));
		this.manaCost = GameConstants.POISON_FOG_MAGIC_COST;
	}
	
	public PoisonFogMagic(int x, int y) {
		super(x, y);
		effects.add(new PoisonStatus(GameConstants.POISON_FOG_MAGIC_STRENGHT,GameConstants.POISON_FOG_MAGIC_DURATION));
		this.manaCost = GameConstants.POISON_FOG_MAGIC_COST;
	}



}