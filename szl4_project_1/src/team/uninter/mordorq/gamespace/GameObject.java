/**
 * GameObject.java
 */
package team.uninter.mordorq.gamespace;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

//generic class used to handle all gameObjects. All of them have coordinates, and an image, that
//will be rendered to them. 
@SuppressWarnings("serial")
public abstract class GameObject extends JPanel {

	protected Image image;
	protected int x, y;

	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public GameObject() {
		super();
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getImage() {
		return image;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(image, x, y, this);
	}

	@Override
	public void repaint() {
		super.repaint();
	}
}
