package team.uninter.mordorq.gamespace;

public class DamageBoostElvenTowerRune extends TowerRune{
	
	float extraDamage;
	
	public DamageBoostElvenTowerRune() {
		super();
		System.out.println("DamageBoostElvenTowerRune() called");
		System.out.println("DamageBoostElvenTowerRune() returned");
	}

	public DamageBoostElvenTowerRune(int x, int y) {
		super(x, y);
		System.out.println("DamageBoostElvenTowerRune(Int, Int) called");
		System.out.println("DamageBoostElvenTowerRune(Int, Int) returned");
	}
	
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
	
}
