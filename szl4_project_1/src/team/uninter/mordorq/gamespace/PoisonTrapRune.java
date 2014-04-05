package team.uninter.mordorq.gamespace;

public class PoisonTrapRune extends TrapRune{
	
	//Class used to add an extra poisonus status modifier in the traps
	//effect list. On inject on, it calls the trap's
	//addEffect function, to add the extra effect
		
	public PoisonTrapRune() {
		super();
	}
	
	public PoisonTrapRune(int x, int y) {
		super(x, y);
	}
	
	public void injectOn(Trap trap){
		PoisonStatus poisonStatus = new PoisonStatus();
		trap.addEffect(poisonStatus);
	}

}
