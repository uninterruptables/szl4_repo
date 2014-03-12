package szl4.uninterruptables.gamespace;

public interface Injectable {
	boolean canInjectOn(Tower tower);
	boolean canInjectOn(Trap trap);
}
