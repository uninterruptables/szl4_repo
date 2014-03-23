package team.uninter.mordorq.gamespace;

public class DecreaseDamageTrap extends Trap{
	public DecreaseDamageTrap() {
		super();
		System.out.println("DecreaseDamageTrap() called");
		WeakenStatus statMod=new WeakenStatus();
		addEffect(statMod);
		System.out.println("DecreaseDamageTrap() returned");
	}
	public DecreaseDamageTrap(int manaCost) {
		super(manaCost);
		System.out.println("DecreaseDamageTrap(Int) called");
		WeakenStatus statMod=new WeakenStatus();
		addEffect(statMod);
		System.out.println("DecreaseDamageTrap(Int) returned");
	}
	public DecreaseDamageTrap(int x, int y) {
		super(x, y);
		System.out.println("DecreaseDamageTrap(Int, Int) called");
		WeakenStatus statMod=new WeakenStatus();
		addEffect(statMod);
		System.out.println("DecreaseDamageTrap(Int, Int) returned");
	}
	protected DecreaseDamageTrap(int x, int y, int manacost) {
		super(x, y, manacost);
		System.out.println("DecreaseDamageTrap(Int, Int, Int) called");
		WeakenStatus statMod=new WeakenStatus();
		addEffect(statMod);
		System.out.println("DecreaseDamageTrap(Int, Int, Int) returned");
	}
}
