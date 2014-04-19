package team.uninter.mordorq.gamespace;

public class RadiusIncTowerRune extends TowerRune{
	
	//a class used to create runes that can increase a tower's radius.
	int extraRadius;
	public RadiusIncTowerRune() {
		super();
//		System.out.println("RadiusIncRune() called");
//		System.out.println("RadiusIncRune() returned");
	}
	
	public RadiusIncTowerRune(int x, int y) {
		super(x, y);
//		System.out.println("RadiusIncRune(Int, Int) called");
//		System.out.println("RadiusIncRune(Int, Int) returned");
	}

	public void injectOn(Tower tower)
	{
//		System.out.println("RadiusIncRune.injectOn(Tower) called");
		tower.setRadius(tower.getRadius()+10);
//		System.out.println("RadiusIncRune.injectOn(Tower) returned");
	}
	
}
