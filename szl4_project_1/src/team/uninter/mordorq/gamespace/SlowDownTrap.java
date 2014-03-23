package team.uninter.mordorq.gamespace;

public class SlowDownTrap extends Trap {
	public SlowDownTrap() {
		super();
		System.out.println("SlowDownTrap() called");
		SlowStatus statMod=new SlowStatus();
		addEffect(statMod);
		System.out.println("SlowDownTrap() returned");
	}
	public SlowDownTrap(int x, int y) {
		super(x, y);
		System.out.println("SlowDownTrap(Int, Int) called");
		SlowStatus statMod=new SlowStatus();
		addEffect(statMod);
		System.out.println("SlowDownTrap(Int, Int) returned");
	}
}
