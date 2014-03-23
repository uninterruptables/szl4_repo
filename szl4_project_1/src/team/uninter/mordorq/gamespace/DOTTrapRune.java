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
	
	public boolean canInjectOn(Trap trap){
		System.out.println("DOTTrapRune.canInjectOn(Trap) : boolean called");
		if(trap.getRunesRemained()>0)
		{
			PoisonStatus poisonStatus=new PoisonStatus(damagePerTick);
			trap.addEffect(poisonStatus);
			System.out.println("DOTTrapRune.canInjectOn(Trap) : boolean returned");
			return true;
		}
		else
		{
			System.out.println("DOTTrapRune.canInjectOn(Trap) : boolean returned");
			return false;
		}
	}

}
