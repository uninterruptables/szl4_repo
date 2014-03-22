package team.uninter.mordorq.gamespace;

public class DamageBoostElvenTowerRune {
float extraDamage;
	
	public boolean canInjectOn(Tower tower)
	{
		System.out.println("DamageBoostDwarvenTowerRune.canInjectOn(Tower) : boolean called");
		System.out.println("DamageBoostDwarvenTowerRune.canInjectOn(Tower) : boolean returned");
		tower.getRunesRemained();
		return true;
	}
	
	public boolean canInjectOn(Trap trap){
		System.out.println("DamageBoostDwarvenTowerRune.canInjectOn(Trap) : boolean called");
		System.out.println("DamageBoostDwarvenTowerRune.canInjectOn(Trap) : boolean returned");
		return false;
	}
}
