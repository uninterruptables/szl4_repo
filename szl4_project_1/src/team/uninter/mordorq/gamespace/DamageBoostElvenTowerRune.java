package team.uninter.mordorq.gamespace;

public class DamageBoostElvenTowerRune extends TowerRune{
float extraDamage;
	
	public boolean canInjectOn(Tower tower)
	{
		System.out.println("DamageBoostElvenTowerRune.canInjectOn(Tower) : boolean called");
		if(tower.getRunesRemained()>0)
		{
			System.out.println("DamageBoostElvenTowerRune.canInjectOn(Tower) : boolean returned");
			return true;
		}
		else
		{
			System.out.println("DamageBoostElvenTowerRune.canInjectOn(Tower) : boolean returned");
			return false;
		}
	}
	
	public boolean canInjectOn(Trap trap){
		System.out.println("DamageBoostElvenTowerRune.canInjectOn(Trap) : boolean called");
		System.out.println("DamageBoostElvenTowerRune.canInjectOn(Trap) : boolean returned");
		return false;
	}
}
