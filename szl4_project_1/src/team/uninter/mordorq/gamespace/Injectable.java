package team.uninter.mordorq.gamespace;
//Items, that can be injected, mainly runes
public interface Injectable {
	//method used to determine, if this can be injected on a tower
	boolean canInjectOn(Tower tower);
	//method used to determine, if this can be injected on a trap
	boolean canInjectOn(Trap trap);
	//method used to determine, what happens, it this is injected on a tower
	void injectOn(Tower tower);
	//method used to determine, what happens, it this is injected on a trap
	void injectOn(Trap trap); 
}
