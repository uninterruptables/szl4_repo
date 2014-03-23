package team.uninter.mordorq.gamespace;

public abstract class TowerRune extends Rune{
	public TowerRune() {
		super();
		System.out.println("TowerRune() called");
		System.out.println("TowerRune() returned");
	}
	
	public TowerRune(int x, int y) {
		super(x, y);
		System.out.println("TowerRune(Int, Int) called");
		System.out.println("TowerRune(Int, Int) returned");
	}
	final public boolean canInjectOn(Tower tower)
	{
		System.out.println("TowerRune.canInjectOn(Tower) : boolean called");
		if(tower.getRunesRemained()>0)
		{
			System.out.println("TowerRune.canInjectOn(Tower) : boolean returned");
			return true;
		}
		else
		{
			System.out.println("TowerRune.canInjectOn(Tower) : boolean returned");
			return false;
		}
	}
	final public boolean canInjectOn(Trap trap)
	{
		System.out.println("TowerRune.canInjectOn(Trap) : boolean called");
		System.out.println("TowerRune.canInjectOn(Trap) : boolean returned");
		return false;	
	}
}
