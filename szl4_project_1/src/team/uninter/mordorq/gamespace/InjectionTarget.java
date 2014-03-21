package team.uninter.mordorq.gamespace;

@SuppressWarnings("serial")
abstract public class InjectionTarget extends Casted{

	private int remainingRunePlace;
	
	public InjectionTarget(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	abstract public void injectOn(Injectable injectable);
	
	public int getRunesRemained(){
		// TODO remove sysout
		System.out.println("InjectionTarget getRunesRemained() called");
		System.out.println("InjectionTarget getRunesRemained() returned");
		return remainingRunePlace;
	}

}
