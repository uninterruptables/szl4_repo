package team.uninter.mordorq.gamespace;

@SuppressWarnings("serial")
abstract public class DamageTaker extends GameObject implements Vulnerable{

	protected int health;
	
	protected DamageTaker() {
		// TODO remove sysout
		System.out.println("DamageTaker.DamageTaker() called");
		System.out.println("DamageTaker.DamageTaker() returned");
	}
	
	public DamageTaker(int x, int y) {
		super(x, y);
		// TODO remove sysout
		System.out.println("DamageTaker.DamageTaker(x,y) called");
		System.out.println("DamageTaker.DamageTaker(x,y) returned");
	}
	
	public int getHealth(){
		// TODO remove sysout
		System.out.println("DamageTaker getHealth() called");
		System.out.println("DamageTaker getHealth() returned");
		return health;
	}

}
