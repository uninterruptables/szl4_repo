package team.uninter.mordorq.gamespace;

public class PoisonFidMagic extends Magic{

	public PoisonFidMagic() {
		super();
		System.out.println("PoisonFidMagic() called");
		effects.add(new PoisonStatus());
		System.out.println("PoisonFidMagic() returned");
	}
	
	public PoisonFidMagic(int x, int y) {
		super(x, y);
		System.out.println("PoisonFidMagic(Int, Int) called");
		System.out.println("PoisonFidMagic(Int, Int) returned");
	}

	@Override
	public void castOn(GameObject object) {
		System.out.println("PoisonFidMagic.castOn(GameObject) called");
		System.out.println("PoisonFidMagic.castOn(GameObject) returned");
		
	}

}
