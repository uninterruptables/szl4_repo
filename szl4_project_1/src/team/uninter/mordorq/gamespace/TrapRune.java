package team.uninter.mordorq.gamespace;

public abstract class TrapRune extends Rune{

	public TrapRune(int manaCost) {
		super(manaCost);
		System.out.println("TrapRune(Int) : boolean called");
		System.out.println("TrapRune(Int) : boolean returned");
	}
	final public boolean canInjectOn(Tower tower)
	{
		System.out.println("TrapRune.canInjectOn(Tower) : boolean called");
		System.out.println("TrapRune.canInjectOn(Tower) : boolean returned");
		return false;
	}
	abstract public boolean canInjectOn(Trap trap);
}
