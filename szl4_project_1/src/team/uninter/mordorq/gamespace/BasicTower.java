package team.uninter.mordorq.gamespace;

import java.awt.Image;
import java.io.File;
import java.util.HashMap;

import team.uninter.mordorq.utils.GameConstants;

@SuppressWarnings("serial")
public class BasicTower extends Tower {


	// One of the few descendants of the Tower class, with no special methods,
	// but certain values.
	public BasicTower(int x, int y) {
		super(x, y);
		avalImages = new HashMap<ImageColor, Image>();
		tryLoad(avalImages, ImageColor.RED, new File("resources/images/basic_tower_16p_red.png"));
		tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/basic_tower_16p.png"));
		super.image = avalImages.get(ImageColor.NORMAL);
		this.radius = GameConstants.BASIC_TOWER_RADIUS;
		this.manaCost = GameConstants.BASIC_TOWER_COST;
	}

	public BasicTower() {
		this(0, 0);
	}

	@Override
	public BasicMissile createMissile() {
		BasicMissile basicMissile = new BasicMissile(this.x, this.y);
		return basicMissile;
	}

	public static class BasicMissile extends Missile {

		public BasicMissile(int x, int y) {
			super(x, y);
			this.maxCooldown = GameConstants.BASIC_TOWER_MAXCOOLDOWN;
			racialDamages.put("dwarf", GameConstants.BASIC_MISSILE_DWARF_DAMAGE);
			racialDamages.put("human", GameConstants.BASIC_MISSILE_HUMAN_DAMAGE);
			racialDamages.put("elf", GameConstants.BASIC_MISSILE_ELF_DAMAGE);
			racialDamages.put("hobbit", GameConstants.BASIC_MISSILE_HOBBIT_DAMAGE);
		}

	}
}