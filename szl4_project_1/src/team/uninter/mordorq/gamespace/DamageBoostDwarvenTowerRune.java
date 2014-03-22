package team.uninter.mordorq.gamespace;

public class DamageBoostDwarvenTowerRune extends TowerRune{
	float extraDamage;
	
	public boolean canInjectOn(Tower tower)
	{
		System.out.println("DamageBoostDwarvenTowerRune.canInjectOn(Tower) : boolean called");
		if(tower.getRunesRemained()>0)
		{
			System.out.println("DamageBoostDwarvenTowerRune.canInjectOn(Tower) : boolean returned");
			return true;
		}
		else
		{
			System.out.println("DamageBoostDwarvenTowerRune.canInjectOn(Tower) : boolean returned");
			return false;
		}
	}
	
	public boolean canInjectOn(Trap trap){
		System.out.println("DamageBoostDwarvenTowerRune.canInjectOn(Trap) : boolean called");
		System.out.println("DamageBoostDwarvenTowerRune.canInjectOn(Trap) : boolean returned");
		return false;
	}
}
