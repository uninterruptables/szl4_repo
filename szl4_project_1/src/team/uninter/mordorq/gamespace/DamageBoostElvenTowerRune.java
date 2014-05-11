package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.utils.GameConstants;

public class DamageBoostElvenTowerRune extends TowerRune{
	
	//Class used to increase damage versus elves. On inject on, it calls the tower-s
	//setSpecies function, to increase it's damage
//	float extraDamage;
	
	public DamageBoostElvenTowerRune() {
		super();
//		System.out.println("DamageBoostElvenTowerRune() called");
//		System.out.println("DamageBoostElvenTowerRune() returned");
	}

	public DamageBoostElvenTowerRune(int x, int y) {
		super(x, y);
//		System.out.println("DamageBoostElvenTowerRune(Int, Int) called");
//		System.out.println("DamageBoostElvenTowerRune(Int, Int) returned");
	}
	
	public void injectOn(Tower tower)
	{
//		System.out.println("DamageBoostElvenTowerRune.injectOn(Tower) called");
		tower.setSpeciesDamage("elf", tower.getSpeciesDamage("elf") + GameConstants.PLUS_ELF_DAMAGE_TOWER_RUNE_DAMAGE_AMOUNT);
//		System.out.println("DamageBoostElvenTowerRune.injectOn(Tower) returned");
	}
	
}
