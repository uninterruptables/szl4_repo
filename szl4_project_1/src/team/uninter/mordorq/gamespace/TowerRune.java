package team.uninter.mordorq.gamespace;

public abstract class TowerRune extends Rune{
	public TowerRune(int manaCost) {
		super(manaCost);
		System.out.println("TowerRune(Int) called");
		System.out.println("TowerRune(Int) returned");
	}
	abstract public boolean canInjectOn(Tower tower);
	final public boolean canInjectOn(Trap trap)
	{
		System.out.println("TowerRune.canInjectOn(Trap) : boolean called");
		System.out.println("TowerRune.canInjectOn(Trap) : boolean returned");
		return false;	
	}
}
