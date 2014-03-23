package team.uninter.mordorq.gamespace;

public class DamageBoostDwarvenTowerRune extends TowerRune{
	
	float extraDamage;
	
	public DamageBoostDwarvenTowerRune() {
		super();
		System.out.println("DamageBoostDwarvenTowerRune() called");
		System.out.println("DamageBoostDwarvenTowerRune() returned");
	}
	public DamageBoostDwarvenTowerRune(int manaCost) {
		super(manaCost);
		System.out.println("DamageBoostDwarvenTowerRune(Int) called");
		System.out.println("DamageBoostDwarvenTowerRune(Int) returned");
	}
	
	public DamageBoostDwarvenTowerRune(int x, int y) {
		super(x, y);
		System.out.println("DamageBoostDwarvenTowerRune(Int, Int) called");
		System.out.println("DamageBoostDwarvenTowerRune(Int, Int) returned");
	}
	public DamageBoostDwarvenTowerRune(int x, int y, int manacost) {
		super(x, y, manacost);
		System.out.println("DamageBoostDwarvenTowerRune(Int, Int, Int) called");
		System.out.println("DamageBoostDwarvenTowerRune(Int, Int, Int) returned");
	}
	
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

	
}
