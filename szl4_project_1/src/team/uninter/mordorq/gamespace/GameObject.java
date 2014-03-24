/**
 * GameObject.java
 */
package team.uninter.mordorq.gamespace;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

//generic class used to handle all gameObjects. All of them have coordinates, and an image, that
//will be rendered to them. 
@SuppressWarnings("serial")
public abstract class GameObject extends JPanel{

	protected Image image;
	protected int x, y;
	
	public GameObject(int x, int y){
		// TODO remove sysout
		System.out.println("GameObject.GameObject(x,y) called");
		this.x = x; this.y = y;
		System.out.println("GameObject.GameObject(x,y) returned");
	}
	
	public GameObject(){
		// TODO remove sysout
		System.out.println("GameObject.GameObject() called");
		System.out.println("GameObject.GameObject() returned");
	}
	
	public int getX(){
		// TODO remove sysout
		System.out.println("GameObject getX() called");
		System.out.println("GameObject getX() returned");
		return x;
	}
	
	public int getY(){
		// TODO remove sysout
		System.out.println("GameObject getY() called");
		System.out.println("GameObject getY() returned");
		return y;
	}
	
	public void setX(int x){
		// TODO remove sysout
		System.out.println("GameObject setX(x) called");
		this.x = x;
		System.out.println("GameObject setX(x) returned");
	}
	
	public void setY(int y){
		// TODO remove sysout
		System.out.println("GameObject setY(y) called");
		this.y = y;
		System.out.println("GameObject setY(y) returned");
	}
	
	public Image getImage(){
		// TODO remove sysout
		System.out.println("GameObject getImage() called");
		System.out.println("GameObject getImage() returned");
		return image;
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		// TODO remove sysout
		System.out.println("GameObject paint(Graphics) called");
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(image, x, y, this);
		System.out.println("GameObject paint(Graphics) returned");
	}
	
	//TODO:/* Optional */
	@Override
	public void repaint(){
		super.repaint();
		// TODO remove sysout
		System.out.println("GameObject repaint() called");
		System.out.println("GameObject repaint() returned");
	}
}
