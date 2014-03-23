package team.uninter.mordorq.gamespace;

public class DamageBoostDwarvenTowerRune extends TowerRune{
	
	float extraDamage;
	
	public DamageBoostDwarvenTowerRune() {
		super();
		System.out.println("DamageBoostDwarvenTowerRune() called");
		System.out.println("DamageBoostDwarvenTowerRune() returned");
	}
	
	public DamageBoostDwarvenTowerRune(int x, int y) {
		super(x, y);
		System.out.println("DamageBoostDwarvenTowerRune(Int, Int) called");
		System.out.println("DamageBoostDwarvenTowerRune(Int, Int) returned");
	}
	
	public void injectOn(Tower tower)
	{
		System.out.println("DamageBoostDwarvenTowerRune.injectOn(Tower) called");
		System.out.println("DamageBoostDwarvenTowerRune.injectOn(Tower) returned");
	}

	
}
