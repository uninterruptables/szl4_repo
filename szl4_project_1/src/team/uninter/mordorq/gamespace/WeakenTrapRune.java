package team.uninter.mordorq.gamespace;

public class WeakenTrapRune extends TrapRune{
	//Class used to add an extra weaken status modifier in the traps
	//effect list. On inject on, it calls the trap's
	//addEffect function, to add the extra effect
	float weakenAmount;
	
	public WeakenTrapRune() {
		super();
		System.out.println("WeakenTrapRune() called");
		System.out.println("WeakenTrapRune() returned");
	}
	
	public WeakenTrapRune(int x, int y) {
		super(x, y);
		System.out.println("WeakenTrapRune(Int, Int) called");
		System.out.println("WeakenTrapRune(Int, Int) returned");
	}
	
	public void injectOn(Trap trap){
		System.out.println("WeakenTrapRune.injectOn(Trap) called");
		WeakenStatus weakenStatus=new WeakenStatus(weakenAmount);
		trap.addEffect(weakenStatus);
		System.out.println("WeakenTrapRune.injectOn(Trap) returned");
	}
}
