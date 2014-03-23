package team.uninter.mordorq.gamespace;

public class IceWindMagic extends Magic{

	
	//Class used to simulate a magical spell, that applies a slow status on every unit on the map
	public IceWindMagic() {
		super();
		System.out.println("IceWindMagic() called");
		effects.add(new SlowStatus());
		System.out.println("IceWindMagic() returned");
	}
	
	public IceWindMagic(int x, int y) {
		super(x, y);
		System.out.println("IceWindMagic(Int, Int) called");
		System.out.println("IceWindMagic(Int, Int) returned");
	}


}
