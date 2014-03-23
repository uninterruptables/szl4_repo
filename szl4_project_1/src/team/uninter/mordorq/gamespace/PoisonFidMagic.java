package team.uninter.mordorq.gamespace;

public class PoisonFidMagic extends Magic{

	//Class used to simulate a magical spell, that applies a poison status on every unit on the map
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



}
