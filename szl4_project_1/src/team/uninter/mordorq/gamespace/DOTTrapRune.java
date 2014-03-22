package team.uninter.mordorq.gamespace;

public class DOTTrapRune extends TrapRune{
	float damagePerTick;
	public boolean canInjectOn(Tower tower)
	{
		System.out.println("DOTTrapRune.canInjectOn(Tower) : boolean called");
		System.out.println("DOTTrapRune.canInjectOn(Tower) : boolean returned");
		return false;
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
			return false
		}
	}
}
