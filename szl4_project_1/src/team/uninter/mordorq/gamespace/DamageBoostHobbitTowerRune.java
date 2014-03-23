package team.uninter.mordorq.gamespace;

public class DamageBoostHobbitTowerRune extends TowerRune{
	
	float extraDamage;
	
	public DamageBoostHobbitTowerRune() {
		super();
		System.out.println("DamageBoostHobbitTowerRune() called");
		System.out.println("DamageBoostHobbitTowerRune() returned");
	}
	
	public DamageBoostHobbitTowerRune(int x, int y) {
		super(x, y);
		System.out.println("DamageBoostHobbitTowerRune(Int, Int) called");
		System.out.println("DamageBoostHobbitTowerRune(Int, Int) returned");
	}
	
	public boolean canInjectOn(Tower tower)
	{
		System.out.println("DamageBoostHobbitTowerRune.canInjectOn(Tower) : boolean called");
		if(tower.getRunesRemained()>0)
		{
			System.out.println("DamageBoostHobbitTowerRune.canInjectOn(Tower) : boolean returned");
			return true;
		}
		else
		{
			System.out.println("DamageBoostHobbitTowerRune.canInjectOn(Tower) : boolean returned");
			return false;
		}
	}
}
