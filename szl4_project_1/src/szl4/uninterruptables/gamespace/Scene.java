/**
 * Scene.java
 * */
package szl4.uninterruptables.gamespace;

import szl4.uninterruptables.utils.*;
import team.uninter.mordorq.gamespace.Controlable;
import team.uninter.mordorq.gamespace.GroundGrid;
import team.uninter.mordorq.gamespace.RoadGrid;
import team.uninter.mordorq.gamespace.Tower;
import team.uninter.mordorq.gamespace.Trap;

import javax.swing.*;

import java.awt.*;

/**
 * 
 * @author Imre Szekeres
 * */
@SuppressWarnings("serial")
public class Scene extends JFrame{
	
	private java.util.List<Controlable> towers;
	private java.util.List<Controlable> enemies;
	
	public void nextRound(){
		System.out.println("Scene nextRound called");
		System.out.println("Scene nextRound returned");
	}
	
	public void endRound(){
		System.out.println("Scene endRound called");
		System.out.println("Scene endRound returned");
	}
	
	public void endGame(){
		System.out.println("Scene endGame called");
		System.out.println("Scene endGame returned");
	}
	
	public void repaint(){
		System.out.println("Scene repaint called");
		System.out.println("Scene repaint returned");
	}
	
	public void place(Barricade barricade, RoadGrid grid){
		System.out.println("Scene place called");
		System.out.println("Scene place returned");
	}
	
	public void place(Tower tower, GroundGrid grid){
		System.out.println("Scene place called");
		System.out.println("Scene place returned");
	}
	
	public void place(Rune rune, Tower tower){
		System.out.println("Scene place called");
		System.out.println("Scene place returned");
	}
	
	public void place(Rune rune, Trap trap){
		System.out.println("Scene place called");
		System.out.println("Scene place returned");
	}
	
	public int rewardUser(int reward){
		System.out.println("Scene rewardUser called");
		//TODO return value
		System.out.println("Scene rewardUser returned");
		return 0;
	}
	
	public void setActiveObject(String objectString){
		System.out.println("Scene setActiveObject called");
		System.out.println("Scene setActiveObject returned");
	}
}
