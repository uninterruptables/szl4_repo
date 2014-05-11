package team.uninter.mordorq.gamespace;

public class PoisonTrap extends Trap {
	//Class use to create a trap, that decreases the enemy troops health, by applying a
	//PoisonStatus statusmodifier
	
	public PoisonTrap() {
		super();
//		System.out.println("PoisonTrap() called");
		PoisonStatus statMod = new PoisonStatus();
		addEffect(statMod);
//		System.out.println("PoisonTrap() returned");
	}
	public PoisonTrap(int x, int y) {
		super(x, y);
//		System.out.println("PoisonTrap(Int, Int) called");
		PoisonStatus statMod = new PoisonStatus();
		addEffect(statMod);
//		System.out.println("PoisonTrap(Int, Int) returned");
	}
}
