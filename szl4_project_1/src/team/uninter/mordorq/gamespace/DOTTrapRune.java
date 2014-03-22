package team.uninter.mordorq.gamespace;

public class DOTTrapRune {
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
		trap.getRunesRemained();
		return true;
	}
}
