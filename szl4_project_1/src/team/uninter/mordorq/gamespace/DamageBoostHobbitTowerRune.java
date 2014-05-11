package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.utils.GameConstants;

public class DamageBoostHobbitTowerRune extends TowerRune{
	
	
	//Class used to increase damage versus hobbits. On inject on, it calls the tower-s
	//setSpecies function, to increase it's damage
//	float extraDamage;
	
	public DamageBoostHobbitTowerRune() {
		super();
//		System.out.println("DamageBoostHobbitTowerRune() called");
//		System.out.println("DamageBoostHobbitTowerRune() returned");
	}
	
	public DamageBoostHobbitTowerRune(int x, int y) {
		super(x, y);
//		System.out.println("DamageBoostHobbitTowerRune(Int, Int) called");
//		System.out.println("DamageBoostHobbitTowerRune(Int, Int) returned");
	}
	
	public void injectOn(Tower tower)
	{
//		System.out.println("DamageBoostHobbitTowerRune.injectOn(Tower) called");
		tower.setSpeciesDamage("hobbit", tower.getSpeciesDamage("hobbit") + GameConstants.PLUS_HOBBIT_DAMAGE_TOWER_RUNE_DAMAGE_AMOUNT);
//		System.out.println("DamageBoostHobbitTowerRune.injectOn(Tower) returned");
	}
}
