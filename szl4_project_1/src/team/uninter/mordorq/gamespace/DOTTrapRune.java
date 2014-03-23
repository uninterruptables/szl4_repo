package team.uninter.mordorq.gamespace;

public class DOTTrapRune extends TrapRune{
	
	float damagePerTick;
	
	public DOTTrapRune() {
		super();
		System.out.println("DOTTrapRune() called");
		System.out.println("DOTTrapRune() returned");
	}
	public DOTTrapRune(int manaCost) {
		super(manaCost);
		System.out.println("DOTTrapRune(Int) called");
		System.out.println("DOTTrapRune(Int) returned");
	}
	
	public DOTTrapRune(int x, int y) {
		super(x, y);
		System.out.println("DOTTrapRune(Int, Int) called");
		System.out.println("DOTTrapRune(Int, Int) returned");
	}
	public DOTTrapRune(int x, int y, int manacost) {
		super(x, y, manacost);
		System.out.println("DOTTrapRune(Int, Int, Int) called");
		System.out.println("DOTTrapRune(Int, Int, Int) returned");
	}
	
	public boolean canInjectOn(Trap trap){
		System.out.println("DOTTrapRune.canInjectOn(Trap) : boolean called");
		trap.getRunesRemained();
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

	@Override
	public void castOn(GameObject object) {
		// TODO Auto-generated method stub
		
	}
}
