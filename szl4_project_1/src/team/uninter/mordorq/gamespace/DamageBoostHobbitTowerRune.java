package team.uninter.mordorq.gamespace;

public class DamageBoostHobbitTowerRune extends TowerRune{
float extraDamage;
	
	public boolean canInjectOn(Tower tower)
	{
		System.out.println("DamageBoostHobbitTowerRune.canInjectOn(Tower) : boolean called");
		if(tower.getRunesRemained()>0)
		{
			System.out.println("DamageBoostHobbitTowerRune.canInjectOn(Tower) : boolean returned");
			return true;
		}
		else
		{
			System.out.println("DamageBoostHobbitTowerRune.canInjectOn(Tower) : boolean returned");
			return false;
		}
	}
	
	public boolean canInjectOn(Trap trap){
		System.out.println("DamageBoostHobbitTowerRune.canInjectOn(Trap) : boolean called");
		System.out.println("DamageBoostHobbitTowerRune.canInjectOn(Trap) : boolean returned");
		return false;
	}
}
