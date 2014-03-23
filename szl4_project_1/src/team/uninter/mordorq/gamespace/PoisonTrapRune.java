package team.uninter.mordorq.gamespace;

public class PoisonTrapRune extends TrapRune{
	
	//Class used to add an extra poisonus status modifier in the traps
	//effect list. On inject on, it calls the trap's
	//addEffect function, to add the extra effect
	
	float damagePerTick;
	
	public PoisonTrapRune() {
		super();
		System.out.println("PoisonTrapRune() called");
		System.out.println("PoisonTrapRune() returned");
	}
	
	public PoisonTrapRune(int x, int y) {
		super(x, y);
		System.out.println("PoisonTrapRune(Int, Int) called");
		System.out.println("PoisonTrapRune(Int, Int) returned");
	}
	
	public void injectOn(Trap trap){
		System.out.println("PoisonTrapRune.injectOn(Trap) called");
		PoisonStatus poisonStatus=new PoisonStatus(damagePerTick);
		trap.addEffect(poisonStatus);
		System.out.println("PoisonTrapRune.injectOn(Trap) returned");
	}

}
