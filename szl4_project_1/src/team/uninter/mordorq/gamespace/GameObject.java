/**
 * GameObject.java
 */
package team.uninter.mordorq.gamespace;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
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

	public void drawObject(Graphics g) {
		g.drawImage(image, x, y, 16, 16, null);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

	// protected static final void tryLoad(File imageFile) {
	protected final void tryLoad(File imageFile) {
		try {
			image = ImageIO.read(imageFile);
		} catch (Exception e) {
		}
	}
}
