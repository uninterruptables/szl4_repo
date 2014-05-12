/**
 * Vulnerable.java
 * */
package team.uninter.mordorq.gamespace;

import java.awt.Graphics;

import team.uninter.mordorq.gamespace.Tower.Missile;

/**
 * 
 * @author 
 * @version "%I%, %G%"
 * */
public interface Vulnerable {
	void interactWith(EnemyTroop troop);

	void interactWith(Missile missile);
    void paint(Graphics g);
	void repaint();
}
