package team.uninter.mordorq.gamespace;

public class DamageBoosterTowerRune extends TowerRune{
	
	float extraDamage;
	
	public DamageBoosterTowerRune() {
		super();
		System.out.println("DamageBoosterTowerRune() called");
		System.out.println("DamageBoosterTowerRune() returned");
	}
	public DamageBoosterTowerRune(int manaCost) {
		super(manaCost);
		System.out.println("DamageBoosterTowerRune(Int) called");
		System.out.println("DamageBoosterTowerRune(Int) returned");
	}
	
	public DamageBoosterTowerRune(int x, int y) {
		super(x, y);
		System.out.println("DamageBoosterTowerRune(Int, Int) called");
		System.out.println("DamageBoosterTowerRune(Int, Int) returned");
	}
	public DamageBoosterTowerRune(int x, int y, int manacost) {
		super(x, y, manacost);
		System.out.println("DamageBoosterTowerRune(Int, Int, Int) called");
		System.out.println("DamageBoosterTowerRune(Int, Int, Int) returned");
	}
	
	public boolean canInjectOn(Tower tower)
	{
		System.out.println("DamageBoosterTowerRune.canInjectOn(Tower) : boolean called");
		if(tower.getRunesRemained()>0)
		{
			System.out.println("DamageBoosterTowerRune.canInjectOn(Tower) : boolean returned");
			return true;
		}
		else
		{
			System.out.println("DamageBoosterTowerRune.canInjectOn(Tower) : boolean returned");
			return false;
		}
	}

	@Override
	public void castOn(GameObject object) {
		// TODO Auto-generated method stub
		
	}
	
}
