package team.uninter.mordorq.gamespace;

public abstract class TrapRune extends Rune{

	public TrapRune() {
		super();
		System.out.println("TrapRune() called");
		System.out.println("TrapRune() returned");
	}
	public TrapRune(int manaCost) {
		super(manaCost);
		System.out.println("TrapRune(Int) : boolean called");
		System.out.println("TrapRune(Int) : boolean returned");
	}
	
	public TrapRune(int x, int y) {
		super(x, y);
		System.out.println("TrapRune(Int, Int) called");
		System.out.println("TrapRune(Int, Int) returned");
	}
	protected TrapRune(int x, int y, int manacost) {
		super(x, y, manacost);
		System.out.println("TrapRune(Int, Int, Int) called");
		System.out.println("TrapRune(Int, Int, Int) returned");
	}
	
	final public boolean canInjectOn(Tower tower)
	{
		System.out.println("TrapRune.canInjectOn(Tower) : boolean called");
		System.out.println("TrapRune.canInjectOn(Tower) : boolean returned");
		return false;
	}
	abstract public boolean canInjectOn(Trap trap);
}
