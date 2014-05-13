package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.utils.GameConstants;

public class IceWindMagic extends Magic{

	
	//Class used to simulate a magical spell, that applies a slow status on every unit on the map
	public IceWindMagic() {
		super();
//		System.out.println("IceWindMagic() called");
		effects.add(new SlowStatus());
		this.manaCost = GameConstants.ICE_WIND_MAGIC_COST;
//		System.out.println("IceWindMagic() returned");
	}
	
	public IceWindMagic(int x, int y) {
		super(x, y);
		effects.add(new SlowStatus());
		this.manaCost = GameConstants.ICE_WIND_MAGIC_COST;
//		System.out.println("IceWindMagic(Int, Int) called");
//		System.out.println("IceWindMagic(Int, Int) returned");
	}


}
