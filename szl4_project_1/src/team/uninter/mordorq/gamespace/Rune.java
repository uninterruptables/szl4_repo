package team.uninter.mordorq.gamespace;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public abstract class Rune extends Casted implements Injectable {

	private static final Logger logger = Logger.getLogger(Rune.class);

	protected Rune() {
		super();
	}

	protected Rune(int x, int y) {
		super(x, y);
	}

	@Override
	public boolean canCastOn(TerrainGrid grid) {
		logger.debug("in Rune.canCastOn for " + this.toString());

		InjectionTarget target = grid.getInjectionTarget();
		if (target != null) {
			boolean ret = target.canInject(this);
			logger.debug("Rune.canCastOn " + grid.toString() + " returns " + ret + " for " + this.toString());
			return ret;
		}
		else {
			logger.debug("Rune.canCastOn returns false for " + this.toString() + " in [else]");
			return false;
		}
	}

	@Override
	public final void castOn(TerrainGrid grid) {
		logger.debug("in Rune.castOn " + grid.toString() + " for " + this.toString());

		InjectionTarget target = grid.getInjectionTarget();
		if (target != null) {
			if (target.canInject(this)) {
				target.inject(this);
				logger.debug("grid " + grid.toString() + " injected " + this.toString());
			}
		}
		logger.debug("on " + grid.toString() + " injectionTarget was null: " + (target == null));
	}

}
