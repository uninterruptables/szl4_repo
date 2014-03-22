package team.uninter.mordorq.gamespace;

@SuppressWarnings("serial")
abstract public class InjectionTarget extends Casted{

	private int remainingRunePlace;
	
	public InjectionTarget(int x, int y) {
		super(x, y);
		// TODO remove sysout
		System.out.println("InjectionTarget.InjectionTarget(x,y) called");
		System.out.println("InjectionTarget.InjectionTarget(x,y) returned");
	}
	
	public InjectionTarget(int x, int y, int manaCost) {
		super(x, y, manaCost);
		// TODO remove sysout
		System.out.println("InjectionTarget.InjectionTarget(x,y,manaCost) called");
		System.out.println("InjectionTarget.InjectionTarget(x,y,manaCost) returned");
	}
	
	public InjectionTarget(int manaCost) {
		// TODO remove sysout
		super(manaCost);
		System.out.println("Casted.Casted(manaCost) called");
		System.out.println("Casted.Casted(manaCost) returned");
	}
	
	abstract public void injectOn(Injectable injectable);
	
	public int getRunesRemained(){
		// TODO remove sysout
		System.out.println("InjectionTarget getRunesRemained() called");
		System.out.println("InjectionTarget getRunesRemained() returned");
		return remainingRunePlace;
	}

}
