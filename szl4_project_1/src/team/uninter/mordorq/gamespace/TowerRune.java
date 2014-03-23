package team.uninter.mordorq.gamespace;

public abstract class TowerRune extends Rune{
	
	//Generic class used to handle runes that can only be placed upont towers.
	//When asked, if they can inject on trap, they return with a false.
	//On tower-s, they check, if they have enough space, and then if they do,
	//they return with true. (Space check is done by user in the skeleton.
	
	//If prequisitions are met, one can call the injectOn method, which is overwritten by
	//every descendant of this class.
	protected TowerRune() {
		super();
		System.out.println("TowerRune() called");
		System.out.println("TowerRune() returned");
	}
	
	protected TowerRune(int x, int y) {
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
