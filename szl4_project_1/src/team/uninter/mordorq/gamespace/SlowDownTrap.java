package team.uninter.mordorq.gamespace;

public class SlowDownTrap extends Trap {
	public SlowDownTrap() {
		super();
		System.out.println("SlowDownTrap() called");
		SlowStatus statMod=new SlowStatus();
		addEffect(statMod);
		System.out.println("SlowDownTrap() returned");
	}
	public SlowDownTrap(int manaCost) {
		super(manaCost);
		System.out.println("SlowDownTrap(Int) called");
		SlowStatus statMod=new SlowStatus();
		addEffect(statMod);
		System.out.println("SlowDownTrap(Int) returned");
	}
	public SlowDownTrap(int x, int y) {
		super(x, y);
		System.out.println("SlowDownTrap(Int, Int) called");
		SlowStatus statMod=new SlowStatus();
		addEffect(statMod);
		System.out.println("SlowDownTrap(Int, Int) returned");
	}
	protected SlowDownTrap(int x, int y, int manacost) {
		super(x, y, manacost);
		System.out.println("SlowDownTrap(Int, Int, Int) called");
		SlowStatus statMod=new SlowStatus();
		addEffect(statMod);
		System.out.println("SlowDownTrap(Int, Int, Int) returned");
	}
}
