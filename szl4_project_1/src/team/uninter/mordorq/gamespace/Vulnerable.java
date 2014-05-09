package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.gamespace.Tower.Missile;

public interface Vulnerable {
	void interactWith(EnemyTroop troop);

	void interactWith(Missile missile);

	void repaint();
}
