package team.uninter.mordorq.gamespace;

import java.awt.Color;

abstract public class Casted extends GameObject {

	private int manaCost;
	
	public Casted(int x, int y) {
		super(x, y);
	}
	
	abstract void castOn(GameObject object);
	
	public int getCost(){
		// TODO remove sysout
		System.out.println("RoadGrid getCost() called");
		System.out.println("RoadGrid getCost() returned");
		return manaCost;
	}
	
	public void setImageColor(Color color){
		// TODO remove sysout
		System.out.println("RoadGrid setImageColor(Color color) called");
		System.out.println("RoadGrid setImageColor(Color color) returned");
	}

}
