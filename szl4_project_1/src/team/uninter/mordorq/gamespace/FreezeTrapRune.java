package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.utils.GameConstants;

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
//		trap.addEffect(new SlowStatus());
		int currentId = trap.getEffect().getId();
		trap.addEffect(new SlowStatus(GameConstants.SLOWER_TRAP_SLOW_AMOUNT + GameConstants.SLOWER_TRAP_RUNE_SLOW_AMOUNT, GameConstants.SLOWER_STATUS_DURATION, currentId));
	}
}
