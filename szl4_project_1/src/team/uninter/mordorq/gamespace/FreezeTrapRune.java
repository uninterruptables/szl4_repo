package team.uninter.mordorq.gamespace;

public class FreezeTrapRune {
	float slowAmount;
	public boolean canInjectOn(Tower tower)
	{
		System.out.println("DamageBoostDwarvenTowerRune.canInjectOn(Tower) : boolean called");
		System.out.println("DamageBoostDwarvenTowerRune.canInjectOn(Tower) : boolean returned");
		return false;
	}
	
	public boolean canInjectOn(Trap trap){
		System.out.println("DamageBoostDwarvenTowerRune.canInjectOn(Trap) : boolean called");
		System.out.println("DamageBoostDwarvenTowerRune.canInjectOn(Trap) : boolean returned");
		if(trap.getRunesRemained()>0)
		{
			SlowStatus slowsStatus=new SlowStatus(slowAmount);
			trap.addStatusModifier(slowStatus);
		}
		return true;
	}
}
