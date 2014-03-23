package team.uninter.mordorq.gamespace;

public abstract class TrapRune extends Rune{
	//Generic class used to handle runes that can only be placed upont traps.
	//When asked, if they can inject on tower, they return with a false.
	//On traps, they check, if they have enough space, and then if they do,
	//they return with true. (Space check is done by user in the skeleton.
	
	//If prequisitions are met, one can call the injectOn method, which is overwritten by
	//every descendant of this class.
	public TrapRune() {
		super();
		System.out.println("TrapRune() called");
		System.out.println("TrapRune() returned");
	}
	
	public TrapRune(int x, int y) {
		super(x, y);
		System.out.println("TrapRune(Int, Int) called");
		System.out.println("TrapRune(Int, Int) returned");
	}
	
	final public boolean canInjectOn(Tower tower)
	{
		System.out.println("TrapRune.canInjectOn(Tower) : boolean called");
		System.out.println("TrapRune.canInjectOn(Tower) : boolean returned");
		return false;
	}
	final public boolean canInjectOn(Trap trap){
		System.out.println("TrapRune.canInjectOn(Trap) : boolean called");
		if(trap.getRunesRemained()>0)
		{
			System.out.println("TrapRune.canInjectOn(Trap) : boolean returned");
			return true;
		}
		else
		{
			System.out.println("TrapRune.canInjectOn(Trap) : boolean returned");
			return false;
		}
	}
}
