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

	public void injectOn(Tower tower)
	{
		System.out.println("RadiusIncRune.injectOn(Tower) called");
		System.out.println("RadiusIncRune.injectOn(Tower) returned");
	}
	
}
