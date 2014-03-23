package team.uninter.mordorq.gamespace;

public class RadiusIncRune extends TowerRune{
	int extraRadius;
	public RadiusIncRune() {
		super();
		System.out.println("RadiusIncRune() called");
		System.out.println("RadiusIncRune() returned");
	}
	
	public RadiusIncRune(int x, int y) {
		super(x, y);
		System.out.println("RadiusIncRune(Int, Int) called");
		System.out.println("RadiusIncRune(Int, Int) returned");
	}

	public boolean canInjectOn(Tower tower)
	{
		System.out.println("RadiusIncRune.canInjectOn(Tower) : boolean called");
		if(tower.getRunesRemained()>0)
		{
			System.out.println("RadiusIncRune.canInjectOn(Tower) : boolean returned");
			return true;
		}
		else{
			System.out.println("RadiusIncRune.canInjectOn(Tower) : boolean returned");
			return false;
		}
	}
	
}
