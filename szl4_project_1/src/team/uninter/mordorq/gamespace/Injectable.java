package team.uninter.mordorq.gamespace;

public interface Injectable {
	boolean canInjectOn(Tower tower);
	boolean canInjectOn(Trap trap);
	void injectOn(Tower tower);
	void injectOn(Trap trap); 
}
