package team.uninter.mordorq.gamespace;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
abstract public class Casted extends GameObject {

	// class used to hold together different objects the player will be able to
	// cast on the map.
	// All of them have manaCost. They two important methods are castOn
	// (determines what happens once the object is
	// casted) and canCastOn (returns, if the given object can be casted on a
	// terrainGrid. Good, for user feedback mostly)

	private static Logger logger = Logger.getLogger(Casted.class);
	protected static Map<ImageColor, Image> avalImages;
	protected ImageColor color;
	protected int manaCost;

	protected Casted() {
		super();
	}

	protected Casted(int x, int y) {
		super(x, y);
	}

	protected Casted(int x, int y, int manaCost) {
		super(x, y);
		this.manaCost = manaCost;
	}

	abstract public void castOn(TerrainGrid grid);

	public int getCost() {
		return manaCost;
	}

	public final void setImage(ImageColor color) {
		this.color = color;
	}
	
	@Override
	public void drawObject(Graphics g) {
		g.drawImage(avalImages.get(color), super.x, super.y, 16, 16, null);
	}

	abstract public boolean canCastOn(TerrainGrid grid);

	public static enum ImageColor {
		RED, NORMAL
	}

	protected static final void tryLoad(Map<ImageColor, Image> target, ImageColor color, File imageFile) {
		try {
			target.put(color, ImageIO.read(imageFile));
		} catch (Exception e) {
			logger.fatal("loading image " + imageFile.toString() + " failed");
		}
	}
}
