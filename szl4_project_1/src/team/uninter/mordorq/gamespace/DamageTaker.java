package team.uninter.mordorq.gamespace;

@SuppressWarnings("serial")
abstract public class DamageTaker extends GameObject implements Vulnerable{

	int health;
	
	protected DamageTaker() {}
	
	public DamageTaker(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public int getHealth(){
		// TODO remove sysout
		System.out.println("DamageTaker getHealth() called");
		System.out.println("DamageTaker getHealth() returned");
		return health;
	}

}
