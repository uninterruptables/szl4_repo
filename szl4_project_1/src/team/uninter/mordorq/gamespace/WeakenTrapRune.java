package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.utils.GameConstants;

public class WeakenTrapRune extends TrapRune{
	//Class used to add an extra weaken status modifier in the traps
	//effect list. On inject on, it calls the trap's
	//addEffect function, to add the extra effect
	int weakenAmount;
	
	public WeakenTrapRune() {
		super();
//		System.out.println("WeakenTrapRune() called");
		weakenAmount = GameConstants.WEAKEN_TRAP_RUNE_WEAKEN_AMOUNT;
//		System.out.println("WeakenTrapRune() returned");
	}
	
	public WeakenTrapRune(int x, int y) {
		super(x, y);
//		System.out.println("WeakenTrapRune(Int, Int) called");
		weakenAmount = GameConstants.WEAKEN_TRAP_RUNE_WEAKEN_AMOUNT;
//		System.out.println("WeakenTrapRune(Int, Int) returned");
	}
	
	public void injectOn(Trap trap){
//		System.out.println("WeakenTrapRune.injectOn(Trap) called");
//		WeakenStatus weakenStatus = new WeakenStatus(weakenAmount);
//		trap.addEffect(weakenStatus);
		int currentId = trap.getEffect().getId();
		trap.addEffect(new WeakenStatus(GameConstants.DECREASE_DAMAGE_TRAP_WEAKEN_AMOUNT + GameConstants.WEAKEN_TRAP_RUNE_WEAKEN_AMOUNT, GameConstants.WEAKEN_STATUS_DURATION, currentId));
//		System.out.println("WeakenTrapRune.injectOn(Trap) returned");
	}
}
