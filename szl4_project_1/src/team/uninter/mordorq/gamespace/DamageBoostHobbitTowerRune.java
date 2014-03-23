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
	
	public void injectOn(Tower tower)
	{
		System.out.println("DamageBoostHobbitTowerRune.injectOn(Tower) called");
		tower.setSpeciesDamage("hobbit", tower.getSpeciesDamage("hobbit")+10);
		System.out.println("DamageBoostHobbitTowerRune.injectOn(Tower) returned");
	}
}
