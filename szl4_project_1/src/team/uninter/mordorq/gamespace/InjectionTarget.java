package team.uninter.mordorq.gamespace;

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
	
	abstract public void inject(Injectable injectable);
	abstract public boolean canInject(Injectable injectable);
	
	public int getRunesRemained(){
		// TODO remove sysout
		System.out.println("InjectionTarget getRunesRemained() called");
		System.out.println("InjectionTarget getRunesRemained() returned");
		return remainingRunePlace;
	}

}
