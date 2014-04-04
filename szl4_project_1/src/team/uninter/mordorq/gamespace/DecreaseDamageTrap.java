package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.utils.GameConstants;

public class DecreaseDamageTrap extends Trap{
	
	//Class use to create a trap, that decreases the enemy troops damage, by applying a
	//WeakenStatus statusmodifier
	public DecreaseDamageTrap() {
		super();
		System.out.println("DecreaseDamageTrap() called");
		WeakenStatus statMod = new WeakenStatus(GameConstants.DECREASE_DAMAGE_TRAP_WEAKEN_AMOUNT, GameConstants.WEAKEN_STATUS_DURATION);
		addEffect(statMod);
		System.out.println("DecreaseDamageTrap() returned");
	}
	public DecreaseDamageTrap(int x, int y) {
		super(x, y);
		System.out.println("DecreaseDamageTrap(Int, Int) called");
		WeakenStatus statMod = new WeakenStatus(GameConstants.DECREASE_DAMAGE_TRAP_WEAKEN_AMOUNT, GameConstants.WEAKEN_STATUS_DURATION);
		addEffect(statMod);
		System.out.println("DecreaseDamageTrap(Int, Int) returned");
	}
}
