package team.uninter.mordorq.gamespace;

import java.awt.Color;

abstract public class Casted extends GameObject {

	private int manaCost;
	
	public Casted(int x, int y) {
		super(x, y);
		// TODO remove sysout
		System.out.println("Casted.Casted(x,y) called");
		System.out.println("Casted.Casted(x,y) returned");
	}
	
	public Casted(int x, int y, int manaCost) {
		super(x, y);
		// TODO remove sysout
		System.out.println("Casted.Casted(x,y,manaCost) called");
		this.manaCost = manaCost;
		System.out.println("Casted.Casted(x,y,manaCost) returned");
	}
	
	public Casted(int manaCost) {
		// TODO remove sysout
		System.out.println("Casted.Casted(manaCost) called");
		this.manaCost = manaCost;
		System.out.println("Casted.Casted(manaCost) returned");
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
