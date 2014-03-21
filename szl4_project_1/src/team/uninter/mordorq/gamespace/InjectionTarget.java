package team.uninter.mordorq.gamespace;

@SuppressWarnings("serial")
abstract public class InjectionTarget extends Casted{

	protected InjectionTarget(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	abstract public void injectOn(Injectable injectable);
	
	public int getRunesRemained(){
		System.out.println("InjectionTarget getRunesRemained called");
		//TODO return value
		System.out.println("InjectionTarget getRunesRemained returned");
		return 0;
	}

}
