package team.uninter.mordorq.gamespace;

public class DamageBoostDwarvenTowerRune extends TowerRune{
	public DamageBoostDwarvenTowerRune(int manaCost) {
		super(manaCost);
		// TODO Auto-generated constructor stub
	}

	float extraDamage;
	
	public boolean canInjectOn(Tower tower)
	{
		System.out.println("DamageBoostDwarvenTowerRune.canInjectOn(Tower) : boolean called");
		if(tower.getRunesRemained()>0)
		{
			System.out.println("DamageBoostDwarvenTowerRune.canInjectOn(Tower) : boolean returned");
			return true;
		}
		else
		{
			System.out.println("DamageBoostDwarvenTowerRune.canInjectOn(Tower) : boolean returned");
			return false;
		}
	}

	@Override
	public void castOn(GameObject object) {
		// TODO Auto-generated method stub
		
	}
	
}
