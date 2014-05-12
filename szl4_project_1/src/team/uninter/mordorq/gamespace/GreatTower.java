package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.gamespace.Tower.Missile.MissileState;
import team.uninter.mordorq.utils.GameConstants;

@SuppressWarnings("serial")
public class GreatTower extends Tower {
	// One of the few descendants of the Tower class, with no special methods,
	// but certain values.
	public GreatTower(int x, int y) {
		super(x, y);
		this.radius = GameConstants.GREAT_TOWER_RADIUS;
	}

	public GreatTower() {
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
	public GreatMissile createMissile() {
		GreatMissile greatMissile = new GreatMissile(this.x, this.y);
		return greatMissile;
	}

	public static class GreatMissile extends Missile {

		public GreatMissile(int x, int y) {
			super(x, y);
			this.maxCooldown = GameConstants.GREAT_TOWER_MAXCOOLDOWN;
			racialDamages.put("dwarf", GameConstants.GREAT_MISSILE_DWARF_DAMAGE);
			racialDamages.put("human", GameConstants.GREAT_MISSILE_HUMAN_DAMAGE);
			racialDamages.put("elf", GameConstants.GREAT_MISSILE_ELF_DAMAGE);
			racialDamages.put("hobbit", GameConstants.GREAT_MISSILE_HOBBIT_DAMAGE);
		}

	}

}