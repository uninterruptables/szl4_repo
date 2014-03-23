package team.uninter.mordorq.gamespace;

public class PoisonFogMagic extends Magic{

	//Class used to simulate a magical spell, that applies a poison status on every unit on the map
	public PoisonFogMagic() {
		super();
		System.out.println("PoisonFogMagic() called");
		effects.add(new PoisonStatus());
		System.out.println("PoisonFogMagic() returned");
	}
	
	public PoisonFogMagic(int x, int y) {
		super(x, y);
		System.out.println("PoisonFogMagic(Int, Int) called");
		System.out.println("PoisonFogMagic(Int, Int) returned");
	}



}
