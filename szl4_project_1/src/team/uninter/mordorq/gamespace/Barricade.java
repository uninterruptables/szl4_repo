package team.uninter.mordorq.gamespace;

import java.awt.Image;
import java.io.File;
import java.util.HashMap;

import team.uninter.mordorq.gamespace.Tower.Missile;
import team.uninter.mordorq.utils.GameConstants;

@SuppressWarnings("serial")
public class Barricade extends Casted implements Vulnerable {

	// Class representing objects, that the player can place on the road, in
	// order to block the enemyTroops path.
	// As a descendant of the vunerable, it has a certain amount of health, that
	// is decreased by the amount of
	// damage that certain enemy type deals on it, during the interractWith
	// method.

	private int health;
	private RoadGrid currentGrid;

//	static {
//		avalImages = new HashMap<ImageColor, Image>();
//		Casted.tryLoad(avalImages, ImageColor.RED, new File("resources/images/barricade_16p_red.png"));
//		Casted.tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/barricade_16p.png"));
//	}

	public Barricade() {
		this(0, 0);
	}

	public Barricade(int x, int y) {
		super(x, y);
		avalImages = new HashMap<ImageColor, Image>();
		tryLoad(avalImages, ImageColor.RED, new File("resources/images/barricade_16p_red.png"));
		tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/barricade_16p.png"));
		super.image = avalImages.get(ImageColor.NORMAL);
		health = GameConstants.BARRICADE_HEALTH;
	}

	@Override
	public void interactWith(EnemyTroop troop) {
		this.setHealth(this.health - troop.getDamage());
		if (health <= 0 && currentGrid != null) {
			currentGrid.remove();
			this.currentGrid = null;
		}
	}

	@Override
	public void interactWith(Missile missile) {
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setCurrentGrid(RoadGrid grid) {
		this.currentGrid = grid;
	}

	@Override
	public void castOn(TerrainGrid grid) {
		if (grid.isAvailableFor(this)) {
			((RoadGrid) grid).setVulnerable(this);
		}
	}

	@Override
	public final boolean canCastOn(TerrainGrid grid) {
		if (grid.isAvailableFor(this))
			return true;
		else
			return false;
	}
}
