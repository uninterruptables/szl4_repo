package team.uninter.mordorq.gamespace;

import java.awt.Color;

@SuppressWarnings("serial")
abstract public class Casted extends GameObject {

	protected int manaCost;
	
	protected Casted() {
		super();
		// TODO remove sysout
		System.out.println("Casted.Casted() called");
		System.out.println("Casted.Casted() returned");
	}
	
	protected Casted(int x, int y) {
		super(x, y);
		// TODO remove sysout
		System.out.println("Casted.Casted(x,y) called");
		System.out.println("Casted.Casted(x,y) returned");
	}
	
	protected Casted(int x, int y, int manaCost) {
		super(x, y);
		// TODO remove sysout
		System.out.println("Casted.Casted(x,y,manaCost) called");
		this.manaCost = manaCost;
		System.out.println("Casted.Casted(x,y,manaCost) returned");
	}
	
	abstract public void castOn(TerrainGrid grid);
	
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
	abstract public boolean canCastOn(TerrainGrid grid);

}
