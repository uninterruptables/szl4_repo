package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.utils.GameConstants;

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
//		PoisonStatus poisonStatus = new PoisonStatus();
//		trap.addEffect(poisonStatus);
		int currentId = trap.getEffect().getId();
		trap.addEffect(new PoisonStatus(GameConstants.POISONOUS_TRAP_POISON_AMOUNT + GameConstants.POISONOUS_TRAP_RUNE_POISON_AMOUNT, GameConstants.POISONOUS_STATUS_DURATION, currentId));
	}

}
