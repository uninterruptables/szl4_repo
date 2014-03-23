package team.uninter.mordorq.gamespace;

public class IceWindMagic extends Magic{

	public IceWindMagic() {
		super();
		System.out.println("IceWindMagic() called");
		System.out.println("IceWindMagic() returned");
	}
	public IceWindMagic(int manaCost) {
		super(manaCost);
		System.out.println("IceWindMagic(Int) : boolean called");
		System.out.println("IceWindMagic(Int) : boolean returned");
	}
	
	public IceWindMagic(int x, int y) {
		super(x, y);
		System.out.println("IceWindMagic(Int, Int) called");
		System.out.println("IceWindMagic(Int, Int) returned");
	}
	public IceWindMagic(int x, int y, int manacost) {
		super(x, y, manacost);
		System.out.println("IceWindMagic(Int, Int, Int) called");
		System.out.println("IceWindMagic(Int, Int, Int) returned");
	}

	@Override
	public void castOn(GameObject object) {
		System.out.println("IceWindMagic.castOn(GameObject) called");
		System.out.println("IceWindMagic.castOn(GameObject) returned");
		
	}

}
