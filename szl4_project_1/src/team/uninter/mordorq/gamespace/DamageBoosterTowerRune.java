package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.utils.GameConstants;

public class DamageBoosterTowerRune extends TowerRune{
	
	//Class used to increase damage versus everything. On inject on, it calls the tower-s
	//setAllDamage function, to increase it's damage
	float extraDamage;
	
	public DamageBoosterTowerRune() {
		super();
		System.out.println("DamageBoosterTowerRune() called");
		System.out.println("DamageBoosterTowerRune() returned");
	}
	
	public DamageBoosterTowerRune(int x, int y) {
		super(x, y);
		System.out.println("DamageBoosterTowerRune(Int, Int) called");
		System.out.println("DamageBoosterTowerRune(Int, Int) returned");
	}
	
	public void injectOn(Tower tower)
	{
		System.out.println("DamageBoosterTowerRune.injectOn(Tower) called");
		tower.addAllDamage(GameConstants.DAMAGE_BOOST_TOWER_RUNE);
		System.out.println("DamageBoosterTowerRune.injectOn(Tower) returned");
	}

	
}
