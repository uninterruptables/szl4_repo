package team.uninter.mordorq.gamespace;

public class DamageBoostDwarvenTowerRune extends TowerRune{
	
	//Class used to increase damage versus dwarves. On inject on, it calls the tower-s
	//setSpecies function, to increase it's damage
	int extraDamage;
	
	public DamageBoostDwarvenTowerRune() {
		super();
	}
	
	public DamageBoostDwarvenTowerRune(int x, int y) {
		super(x, y);
	}
	
	public void injectOn(Tower tower)	{
		tower.setSpeciesDamage("dwarf", tower.getSpeciesDamage("dwarf")+10);
	}	
}
