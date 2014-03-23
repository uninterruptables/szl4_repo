package team.uninter.mordorq.gamespace;

public abstract class TrapRune extends Rune{

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
