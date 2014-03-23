package team.uninter.mordorq.gamespace;

public abstract class TowerRune extends Rune{
	public TowerRune() {
		super();
		System.out.println("TowerRune() called");
		System.out.println("TowerRune() returned");
	}
	public TowerRune(int manaCost) {
		super(manaCost);
		System.out.println("TowerRune(Int) : boolean called");
		System.out.println("TowerRune(Int) : boolean returned");
	}
	
	public TowerRune(int x, int y) {
		super(x, y);
		System.out.println("TowerRune(Int, Int) called");
		System.out.println("TowerRune(Int, Int) returned");
	}
	protected TowerRune(int x, int y, int manacost) {
		super(x, y, manacost);
		System.out.println("TowerRune(Int, Int, Int) called");
		System.out.println("TowerRune(Int, Int, Int) returned");
	}
	abstract public boolean canInjectOn(Tower tower);
	final public boolean canInjectOn(Trap trap)
	{
		System.out.println("TowerRune.canInjectOn(Trap) : boolean called");
		System.out.println("TowerRune.canInjectOn(Trap) : boolean returned");
		return false;	
	}
}
