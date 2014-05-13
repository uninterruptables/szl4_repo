package team.uninter.mordorq.gamespace;

import java.awt.Image;
import java.io.File;
import java.util.HashMap;

import team.uninter.mordorq.gamespace.Tower.Missile.MissileState;
import team.uninter.mordorq.utils.GameConstants;

@SuppressWarnings("serial")
public class LongDistanceTower extends Tower {
	// One of the few descendants of the Tower class, with no special methods,
	// but certain values.

//	static {
//		avalImages = new HashMap<ImageColor, Image>();
//		Casted.tryLoad(avalImages, ImageColor.RED, new File("resources/images/longr_tower_16p_red.png"));
//		Casted.tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/longr_tower_16p.png"));
//	}

	public LongDistanceTower(int x, int y) {
		super(x, y);
		avalImages = new HashMap<ImageColor, Image>();
		Casted.tryLoad(avalImages, ImageColor.RED, new File("resources/images/longr_tower_16p_red.png"));
		Casted.tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/longr_tower_16p.png"));
		super.image = avalImages.get(ImageColor.NORMAL);
		this.radius = GameConstants.LONG_DISTANCE_TOWER_RADIUS;
	}

	public LongDistanceTower() {
		this(0, 0);
	}

	@Override
	public void notifyWith(EnemyTroop target) {
		MissileState actualState = this.missile.getState();
		if (actualState.equals(MissileState.WAITING)) {
			fire(target);
		}
	}

	@Override
	public LongDistanceMissile createMissile() {
		LongDistanceMissile longDistanceMissile = new LongDistanceMissile(this.x, this.y);
		return longDistanceMissile;
	}

	public static class LongDistanceMissile extends Missile {

		public LongDistanceMissile(int x, int y) {
			super(x, y);
			this.maxCooldown = GameConstants.LONG_DISTANCE_TOWER_MAXCOOLDOWN;
			racialDamages.put("dwarf", GameConstants.LONG_DISTANCE_MISSILE_DWARF_DAMAGE);
			racialDamages.put("human", GameConstants.LONG_DISTANCE_MISSILE_HUMAN_DAMAGE);
			racialDamages.put("elf", GameConstants.LONG_DISTANCE_MISSILE_ELF_DAMAGE);
			racialDamages.put("hobbit", GameConstants.LONG_DISTANCE_MISSILE_HOBBIT_DAMAGE);
		}

	}

}