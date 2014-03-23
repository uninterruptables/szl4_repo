package team.uninter.mordorq.gamespace;

public class FreezeTrapRune extends TrapRune{
	
	float slowAmount;
	
	public FreezeTrapRune() {
		super();
		System.out.println("FreezeTrapRune() called");
		System.out.println("FreezeTrapRune() returned");
	}
	public FreezeTrapRune(int manaCost) {
		super(manaCost);
		System.out.println("FreezeTrapRune(Int) called");
		System.out.println("FreezeTrapRune(Int) returned");
	}
	
	public FreezeTrapRune(int x, int y) {
		super(x, y);
		System.out.println("FreezeTrapRune(Int, Int) called");
		System.out.println("FreezeTrapRune(Int, Int) returned");
	}
	public FreezeTrapRune(int x, int y, int manacost) {
		super(x, y, manacost);
		System.out.println("FreezeTrapRune(Int, Int, Int) called");
		System.out.println("FreezeTrapRune(Int, Int, Int) returned");
	}
	
	public boolean canInjectOn(Trap trap){
		System.out.println("DamageBoostDwarvenTowerRune.canInjectOn(Trap) : boolean called");
		System.out.println("DamageBoostDwarvenTowerRune.canInjectOn(Trap) : boolean returned");
		if(trap.getRunesRemained()>0)
		{
			SlowStatus slowStatus=new SlowStatus(slowAmount);
			trap.addEffect(slowStatus);
			return true;
		}
		return false;
		
	}
}
