package team.uninter.mordorq.gamespace;

public abstract class TrapRune extends Rune{
	//Generic class used to handle runes that can only be placed upont traps.
	//When asked, if they can inject on tower, they return with a false.
	//On traps, they check, if they have enough space, and then if they do,
	//they return with true. (Space check is done by user in the skeleton.
	
	//If prequisitions are met, one can call the injectOn method, which is overwritten by
	//every descendant of this class.
	protected TrapRune() {
		super();
	}
	
	protected TrapRune(int x, int y) {
		super(x, y);
	}
	
	final public boolean canCastOn(TerrainGrid grid){
		return grid.isAvailableFor(this);
	}
	
	final public boolean canInjectOn(Tower tower) {
		return false;
	}
	
	final public boolean canInjectOn(Trap trap){
		return trap.getRunesRemained() > 0;
	}

	final public void injectOn(Tower tower) {}
}
