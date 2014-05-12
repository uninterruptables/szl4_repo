package team.uninter.mordorq.gamespace;

import java.util.ArrayList;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public abstract class Magic extends Casted {

	// Class used to handle different global spells. It contains a list of
	// status modifiers, that
	// can be applied on the enemy units.
	// It's manacost can be asked, for user input check.
	private static final Logger logger = Logger.getLogger(Magic.class);

	int manaCost;
	protected ArrayList<StatusModifier> effects;

	protected Magic() {
		super();
		effects = new ArrayList<StatusModifier>();
	}

	protected Magic(int x, int y) {
		super(x, y);
		effects = new ArrayList<StatusModifier>();
	}

	public ArrayList<StatusModifier> getStatusModifiers() {
		return effects;
	}

	@Override
	public final void castOn(TerrainGrid grid) {
		logger.debug(this.toString() + " was casted on " + grid.toString());
	}

	@Override
	public final boolean canCastOn(TerrainGrid grid) {
		logger.debug("can cast " + this.toString() + " on " + grid.toString());
		return true;
	}

}
