package team.uninter.mordorq.gamespace;

public class DamageBoostHobbitTowerRune extends TowerRune{
	
	float extraDamage;
	
	public DamageBoostHobbitTowerRune() {
		super();
		System.out.println("DamageBoostHobbitTowerRune() called");
		System.out.println("DamageBoostHobbitTowerRune() returned");
	}
	public DamageBoostHobbitTowerRune(int manaCost) {
		super(manaCost);
		System.out.println("DamageBoostHobbitTowerRune(Int) called");
		System.out.println("DamageBoostHobbitTowerRune(Int) returned");
	}
	
	public DamageBoostHobbitTowerRune(int x, int y) {
		super(x, y);
		System.out.println("DamageBoostHobbitTowerRune(Int, Int) called");
		System.out.println("DamageBoostHobbitTowerRune(Int, Int) returned");
	}
	public DamageBoostHobbitTowerRune(int x, int y, int manacost) {
		super(x, y, manacost);
		System.out.println("DamageBoostHobbitTowerRune(Int, Int, Int) called");
		System.out.println("DamageBoostHobbitTowerRune(Int, Int, Int) returned");
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

	@Override
	public void castOn(GameObject object) {
		// TODO Auto-generated method stub
		
	}
}
