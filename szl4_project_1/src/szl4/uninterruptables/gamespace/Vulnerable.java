package szl4.uninterruptables.gamespace;

import szl4.uninterruptables.gamespace.Tower.Missile;

public interface Vulnerable {
	void interactWith(EnemyTroop troop);
	void interactWith(Missile missile);
}
