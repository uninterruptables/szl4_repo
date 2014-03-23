package team.uninter.mordorq.gamespace;

public class DecreaseDamageTrap extends Trap{
	
	//Class use to create a trap, that decreases the enemy troops damage, by applying a
	//WeakenStatus statusmodifier
	public DecreaseDamageTrap() {
		super();
		System.out.println("DecreaseDamageTrap() called");
		WeakenStatus statMod=new WeakenStatus();
		addEffect(statMod);
		System.out.println("DecreaseDamageTrap() returned");
	}
	public DecreaseDamageTrap(int x, int y) {
		super(x, y);
		System.out.println("DecreaseDamageTrap(Int, Int) called");
		WeakenStatus statMod=new WeakenStatus();
		addEffect(statMod);
		System.out.println("DecreaseDamageTrap(Int, Int) returned");
	}
}
