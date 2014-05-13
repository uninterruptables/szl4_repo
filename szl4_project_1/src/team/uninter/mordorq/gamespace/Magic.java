package team.uninter.mordorq.gamespace;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import team.uninter.mordorq.gamespace.Casted.ImageColor;

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
		avalImages = new HashMap<ImageColor, Image>();
		tryLoad(avalImages, ImageColor.RED, new File("resources/images/magic.png"));
		tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/magic.png"));
	}

	protected Magic(int x, int y) {
		super(x, y);
		effects = new ArrayList<StatusModifier>();
		avalImages = new HashMap<ImageColor, Image>();
		tryLoad(avalImages, ImageColor.RED, new File("resources/images/magic.png"));
		tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/magic.png"));
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
	
	@Override
	public void drawObject(Graphics g) {
		g.drawImage(avalImages.get(color), super.x, super.y, 50, 20, null);
	}

}
