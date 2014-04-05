package team.uninter.mordorq.gamespace;

public class FreezeTrapRune extends TrapRune{
	//Class used to add an extra slowdown status modifier in the traps
	//effect list. On inject on, it calls the trap's
	//addEffect function, to add the extra effect
	
	public FreezeTrapRune() {
		super();
	}
	
	public FreezeTrapRune(int x, int y) {
		super(x, y);
	}
	
	public void injectOn(Trap trap){
		trap.addEffect(new SlowStatus());
	}
}
