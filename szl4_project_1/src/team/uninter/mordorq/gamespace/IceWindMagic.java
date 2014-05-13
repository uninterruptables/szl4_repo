package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.utils.GameConstants;

public class IceWindMagic extends Magic{

	
	//Class used to simulate a magical spell, that applies a slow status on every unit on the map
	public IceWindMagic() {
		super();
		effects.add(new SlowStatus(GameConstants.ICE_WIND_MAGIC_STRENGHT,GameConstants.ICE_WIND_MAGIC_DURATION));
		this.manaCost = GameConstants.ICE_WIND_MAGIC_COST;
	}
	
	public IceWindMagic(int x, int y) {
		super(x, y);
		effects.add(new SlowStatus(GameConstants.ICE_WIND_MAGIC_STRENGHT,GameConstants.ICE_WIND_MAGIC_DURATION));
		this.manaCost = GameConstants.ICE_WIND_MAGIC_COST;
	}


}