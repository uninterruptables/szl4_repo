package team.uninter.mordorq.gamespace;

public class SpeedBoosterTowerRune extends TowerRune{
	public SpeedBoosterTowerRune() {
		super();
		System.out.println("SpeedBoosterTowerRune() called");
		System.out.println("SpeedBoosterTowerRune() returned");
	}
	
	public SpeedBoosterTowerRune(int x, int y) {
		super(x, y);
		System.out.println("SpeedBoosterTowerRune(Int, Int) called");
		System.out.println("SpeedBoosterTowerRune(Int, Int) returned");
	}

	public void injectOn(Tower tower)
	{
		System.out.println("SpeedBoosterTowerRune.injectOn(Tower) called");
		System.out.println("SpeedBoosterTowerRune.injectOn(Tower) returned");
	}
	
}
