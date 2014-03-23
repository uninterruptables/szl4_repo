package team.uninter.mordorq.gamespace;

public class SpeedBoosterTowerRune extends TowerRune{
	public SpeedBoosterTowerRune() {
		super();
		System.out.println("SpeedBoosterTowerRune() called");
		System.out.println("SpeedBoosterTowerRune() returned");
	}
	public SpeedBoosterTowerRune(int manaCost) {
		super(manaCost);
		System.out.println("SpeedBoosterTowerRune(Int) called");
		System.out.println("SpeedBoosterTowerRune(Int) returned");
	}
	
	public SpeedBoosterTowerRune(int x, int y) {
		super(x, y);
		System.out.println("SpeedBoosterTowerRune(Int, Int) called");
		System.out.println("SpeedBoosterTowerRune(Int, Int) returned");
	}
	public SpeedBoosterTowerRune(int x, int y, int manaCost) {
		super(x, y, manaCost);
		System.out.println("SpeedBoosterTowerRune(Int, Int, Int) called");
		System.out.println("SpeedBoosterTowerRune(Int, Int, Int) returned");
	}

	public boolean canInjectOn(Tower tower)
	{
		System.out.println("SpeedBoosterTowerRune.canInjectOn(Tower) : boolean called");
		if(tower.getRunesRemained()>0)
		{
			System.out.println("SpeedBoosterTowerRune.canInjectOn(Tower) : boolean returned");
			return true;
		}
		else{
			System.out.println("SpeedBoosterTowerRune.canInjectOn(Tower) : boolean returned");
			return false;
		}
	}
	
	@Override
	public void castOn(GameObject object) {
		System.out.println("SpeedBoosterTowerRune.castOn(GameObject) called");
		System.out.println("SpeedBoosterTowerRune.castOn(GameObject) returned");
		
	}
}
