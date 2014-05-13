package team.uninter.mordorq.gamespace;

import java.awt.Image;
import java.io.File;
import java.util.HashMap;

import team.uninter.mordorq.gamespace.Tower.Missile.MissileState;
import team.uninter.mordorq.utils.GameConstants;

@SuppressWarnings("serial")
public class FastTower extends Tower {
	// One of the few descendants of the Tower class, with no special methods,
	// but certain values.

//	static {
//		avalImages = new HashMap<ImageColor, Image>();
//		Casted.tryLoad(avalImages, ImageColor.RED, new File("resources/images/fast_tower_16p_red.png"));
//		Casted.tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/fast_tower_16p.png"));
//	}

	public FastTower(int x, int y) {
		super(x, y);
		avalImages = new HashMap<ImageColor, Image>();
		Casted.tryLoad(avalImages, ImageColor.RED, new File("resources/images/fast_tower_16p_red.png"));
		Casted.tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/fast_tower_16p.png"));
		super.image = avalImages.get(ImageColor.NORMAL);
		this.radius = GameConstants.FAST_TOWER_RADIUS;
	}

	public FastTower() {
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
	public FastMissile createMissile() {
		FastMissile fastMissile = new FastMissile(this.x, this.y);
		return fastMissile;
	}

	public static class FastMissile extends Missile {

		public FastMissile(int x, int y) {
			super(x, y);
			this.maxCooldown = GameConstants.FAST_TOWER_MAXCOOLDOWN;
			racialDamages.put("dwarf", GameConstants.FAST_MISSILE_DWARF_DAMAGE);
			racialDamages.put("human", GameConstants.FAST_MISSILE_HUMAN_DAMAGE);
			racialDamages.put("elf", GameConstants.FAST_MISSILE_ELF_DAMAGE);
			racialDamages.put("hobbit", GameConstants.FAST_MISSILE_HOBBIT_DAMAGE);
		}

	}

}