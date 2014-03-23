package team.uninter.mordorq.gamespace;

public class DOTTrapRune extends TrapRune{
	
	float damagePerTick;
	
	public DOTTrapRune() {
		super();
		System.out.println("DOTTrapRune() called");
		System.out.println("DOTTrapRune() returned");
	}
	
	public DOTTrapRune(int x, int y) {
		super(x, y);
		System.out.println("DOTTrapRune(Int, Int) called");
		System.out.println("DOTTrapRune(Int, Int) returned");
	}
	
	public void injectOn(Trap trap){
		System.out.println("DOTTrapRune.injectOn(Trap) called");
		PoisonStatus poisonStatus=new PoisonStatus(damagePerTick);
		trap.addEffect(poisonStatus);
		System.out.println("DOTTrapRune.injectOn(Trap) returned");
	}

}
