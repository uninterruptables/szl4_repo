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
	
	public void injectOn(Tower tower)
	{
		System.out.println("DamageBoostElvenTowerRune.injectOn(Tower) called");
		System.out.println("DamageBoostElvenTowerRune.injectOn(Tower) returned");
	}
	
}
