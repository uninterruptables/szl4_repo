package team.uninter.mordorq.gamespace;

public class IceWindMagic extends Magic{

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

	@Override
	public void castOn(GameObject object) {
		System.out.println("IceWindMagic.castOn(GameObject) called");
		System.out.println("IceWindMagic.castOn(GameObject) returned");
		
	}

}
