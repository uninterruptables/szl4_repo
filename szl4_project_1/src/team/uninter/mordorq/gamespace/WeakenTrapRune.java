package team.uninter.mordorq.gamespace;

public class WeakenTrapRune extends TrapRune{

	float slowAmount;
	
	public WeakenTrapRune() {
		super();
		System.out.println("WeakenTrapRune() called");
		System.out.println("WeakenTrapRune() returned");
	}
	public WeakenTrapRune(int manaCost) {
		super(manaCost);
		System.out.println("WeakenTrapRune(Int) : boolean called");
		System.out.println("WeakenTrapRune(Int) : boolean returned");
	}
	
	public WeakenTrapRune(int x, int y) {
		super(x, y);
		System.out.println("WeakenTrapRune(Int, Int) called");
		System.out.println("WeakenTrapRune(Int, Int) returned");
	}
	protected WeakenTrapRune(int x, int y, int manacost) {
		super(x, y, manacost);
		System.out.println("WeakenTrapRune(Int, Int, Int) called");
		System.out.println("WeakenTrapRune(Int, Int, Int) returned");
	}
	
	public boolean canInjectOn(Trap trap){
		System.out.println("DOTTrapRune.canInjectOn(Trap) : boolean called");
		trap.getRunesRemained();
		if(trap.getRunesRemained()>0)
		{
			WeakenStatus weakenStatus=new WeakenStatus(slowAmount);
			trap.addEffect(weakenStatus);
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
