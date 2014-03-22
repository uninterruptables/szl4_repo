package team.uninter.mordorq.gamespace;

public class RadiusIncRune {
	int extraRadius;
	
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
	
	public boolean canInjectOn(Trap trap){
		System.out.println("RadiusIncRune.canInjectOn(Trap) : boolean called");
		System.out.println("RadiusIncRune.canInjectOn(Trap) : boolean returned");
		return false;
	}
}
