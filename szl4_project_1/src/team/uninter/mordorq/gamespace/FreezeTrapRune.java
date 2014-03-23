package team.uninter.mordorq.gamespace;

public class FreezeTrapRune extends TrapRune{
	
	float slowAmount;
	
	public FreezeTrapRune() {
		super();
		System.out.println("FreezeTrapRune() called");
		System.out.println("FreezeTrapRune() returned");
	}
	
	public FreezeTrapRune(int x, int y) {
		super(x, y);
		System.out.println("FreezeTrapRune(Int, Int) called");
		System.out.println("FreezeTrapRune(Int, Int) returned");
	}
	
	public boolean canInjectOn(Trap trap){
		System.out.println("DamageBoostDwarvenTowerRune.canInjectOn(Trap) : boolean called");
		if(trap.getRunesRemained()>0)
		{
			SlowStatus slowStatus=new SlowStatus(slowAmount);
			trap.addEffect(slowStatus);
			System.out.println("DamageBoostDwarvenTowerRune.canInjectOn(Trap) : boolean returned");
			return true;
		}
		else 
		{
			System.out.println("DamageBoostDwarvenTowerRune.canInjectOn(Trap) : boolean returned");
			return false;
		}
		
	}
}
