package team.uninter.mordorq.gamespace;
//items, one can inject on, mainly towers, traps.
@SuppressWarnings("serial")
abstract public class InjectionTarget extends Casted{

	private int remainingRunePlace;
	
	protected InjectionTarget() {
		super();
		// TODO remove sysout
		System.out.println("InjectionTarget.InjectionTarget() called");
		System.out.println("InjectionTarget.InjectionTarget() returned");
	}
	
	protected InjectionTarget(int x, int y) {
		super(x, y);
		// TODO remove sysout
		System.out.println("InjectionTarget.InjectionTarget(x,y) called");
		System.out.println("InjectionTarget.InjectionTarget(x,y) returned");
	}
	//method used to determine, what happens during an injection.
	abstract public void inject(Injectable injectable);
	//method used to determine whether an object can be injected on this or not.
	abstract public boolean canInject(Injectable injectable);
	
	public int getRunesRemained(){
		// TODO remove sysout
		System.out.println("InjectionTarget getRunesRemained() called");
		System.out.println("InjectionTarget getRunesRemained() returned");
		return remainingRunePlace;
	}

}
