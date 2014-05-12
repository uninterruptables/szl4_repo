/**
 * GameObject.java
 */
package team.uninter.mordorq.gamespace;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

//generic class used to handle all gameObjects. All of them have coordinates, and an image, that
//will be rendered to them. 
@SuppressWarnings("serial")
public abstract class GameObject extends JPanel {

	private static final Logger logger = Logger.getLogger(GameObject.class);

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
		logger.debug("paint was called for " + this.getClass());
	}

	@Override
	public void repaint() {
		super.repaint();
		logger.debug("repaint was called in " + this.getClass());
	}

	protected final void tryLoad(File imageFile) {
		try {
			image = ImageIO.read(imageFile);
		} catch (Exception e) {
			logger.fatal("image load failed in " + this.toString());
		}
	}
}
