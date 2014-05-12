package team.uninter.mordorq.gamespace;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
abstract public class Trap extends InjectionTarget {

	private static final Logger logger = Logger.getLogger(Trap.class);
	// generic class used to handle trap objects, that can be placed on roads.
	// They contain a number of different effects they can apply on enemy
	// troops.
	StatusModifier effect;

	protected Trap() {
		super();
	}

	protected Trap(int x, int y) {
		super(x, y);
	}

	// method used to add additional effects to the trap (mainly via runes)
	public void addEffect(StatusModifier newStatus) {
		this.effect = newStatus;
		logger.debug("effect " + effect.toString() + " was set for " + this.toString());
	}

	// method called, when it affects an enemy
	public void affect(EnemyTroop enemyTroop) {
		this.effect.apply(enemyTroop);

	}

	// method that helps to determine whether a certain injectable can be
	// injected on it, or not
	@Override
	public final boolean canInject(Injectable injectable) {
		return injectable.canInjectOn(this);
	}

	// during the cast of a terrainGrid
	@Override
	public final void castOn(TerrainGrid grid) {
		logger.debug("in Trap.castOn for " + this.toString());
		((RoadGrid) grid).setTrap(this);
		logger.debug("in Trap.castOn " + this.toString() + " wast cast onto " + grid.toString());
	}

	// checks, wheter it can be casted on a grid or not
	@Override
	public final boolean canCastOn(TerrainGrid grid) {
		boolean res = grid.isAvailableFor(this);
		logger.debug("in Trap.canCastOn " + this.toString() + " was " + (res == true ? "" : "not ") + "casted to " + grid.toString());
		return res;
	}

	// injects an injectable
	@Override
	public final void inject(Injectable inject) {
		inject.injectOn(this);
		logger.debug("in Trap.inject: " + this.toString() + " was injected on " + inject.toString());
		this.remainingRunePlace--;
		logger.debug(remainingRunePlace + " rune places remained in " + this.toString());
	}

	public StatusModifier getEffect() {
		logger.debug("effect " + effect.toString() + " was queried from " + this.toString());
		return this.effect;
	}

}
