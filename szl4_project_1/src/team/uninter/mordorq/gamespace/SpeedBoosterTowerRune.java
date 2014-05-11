package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.utils.GameConstants;

public class SpeedBoosterTowerRune extends TowerRune{
	
	//a class used to create runes that can increase a tower's speed.
	public SpeedBoosterTowerRune() {
		super();
//		System.out.println("SpeedBoosterTowerRune() called");
//		System.out.println("SpeedBoosterTowerRune() returned");
	}
	
	public SpeedBoosterTowerRune(int x, int y) {
		super(x, y);
//		System.out.println("SpeedBoosterTowerRune(Int, Int) called");
//		System.out.println("SpeedBoosterTowerRune(Int, Int) returned");
	}

	public void injectOn(Tower tower)
	{
//		System.out.println("SpeedBoosterTowerRune.injectOn(Tower) called");
		tower.setMaxCooldown(tower.getMaxCooldown() - GameConstants.PLUS_SPEED_TOWER_RUNE_SPEED_AMOUNT);
//		System.out.println("SpeedBoosterTowerRune.injectOn(Tower) returned");
	}
	
}
