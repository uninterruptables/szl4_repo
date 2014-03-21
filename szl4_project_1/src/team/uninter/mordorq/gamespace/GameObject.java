/**
 * GameObject.java
 */
package team.uninter.mordorq.gamespace;

import javax.swing.*;
import java.awt.*;


@SuppressWarnings("serial")
public abstract class GameObject extends JPanel{

	protected Image image;
	protected int x, y;
	
	protected GameObject(int x, int y){
		this.x = x; this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public Image getImage(){
		return image;
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(image, x, y, this);
	}
	
	//TODO:/* Optional */
	@Override
	public void repaint(){
		super.repaint();
	}
}
