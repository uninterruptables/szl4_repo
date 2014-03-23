package team.uninter.mordorq.gamespace;

public class FreezeTrapRune extends TrapRune{
	
	float slowAmount;
	
	public FreezeTrapRune() {
		super();
		System.out.println("FreezeTrapRune() called");
		System.out.println("FreezeTrapRune() returned");
	}
	
	public FreezeTrapRune(int x, int y) {
		super(x, y);
		System.out.println("FreezeTrapRune(Int, Int) called");
		System.out.println("FreezeTrapRune(Int, Int) returned");
	}
	
	public void injectOn(Trap trap){
		System.out.println("FreezeTrapRune.injectOn(Trap) called");
		SlowStatus slowStatus=new SlowStatus(slowAmount);
		trap.addEffect(slowStatus);
		System.out.println("FreezeTrapRune.injectOn(Trap) returned");
	}
}
