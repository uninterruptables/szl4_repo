package team.uninter.mordorq.gamespace;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
abstract public class TerrainGrid extends GameObject{

	protected int utility;
	protected Map<Neighbour,TerrainGrid> neighbours;
	
	public TerrainGrid(int x, int y) {
		super(x, y);
		//TODO remove sysout
		System.out.println("TerrainGrid.TerrainGrid(x,y) called");		
		neighbours = new HashMap<Neighbour,TerrainGrid>();
		System.out.println("TerrainGrid.TerrainGrid(x,y) returned");
	}
	
	public TerrainGrid(int utility) {
		//TODO remove sysout
		System.out.println("TerrainGrid.TerrainGrid(utility) called");	
		this.utility = utility;
		neighbours = new HashMap<Neighbour,TerrainGrid>();
		System.out.println("TerrainGrid.TerrainGrid(utility) returned");
	}
	
	public TerrainGrid(){
		//TODO remove sysout
		System.out.println("TerrainGrid.TerrainGrid() called");	
		neighbours = new HashMap<Neighbour,TerrainGrid>();
		System.out.println("TerrainGrid.TerrainGrid() returned");
	};
	
	public boolean isInRangeOf(Tower tower){
		//TODO remove sysout
		System.out.println("TerrainGrid isInRangeOf(Tower) called");
		int currentX = super.x;
		int currentY = super.y;
		int targetX = tower.getX();
		int targetY = tower.getY();
		int distanceX = targetX - currentX;
		int distanceY = targetY - currentY;
		int distance = (int) Math.sqrt(distanceX^2 + distanceY^2);
		if(distance <= tower.getRadius()){
			System.out.println("TerrainGrid isInRangeOf(Tower tower) returned true");
			return true;
		}
		else{
			System.out.println("TerrainGrid isInRangeOf(Tower tower) returned false");
			return false;
		}
	}
	
	abstract public int getUtility();

	abstract public boolean isAvailableFor(Trap trap);
	
	abstract public boolean isAvailableFor(Tower tower);
	
	public TerrainGrid get(Neighbour neighbour){
		//TODO remove sysout
		System.out.println("TerrainGrid get(Neighbour neightbour) called");
		TerrainGrid grid = neighbours.get(neighbour);
		System.out.println("TerrainGrid get(Neighbour neightbour) returned");
		return grid;
	}
	
	public void set(Neighbour neighbour, TerrainGrid grid){
		//TODO remove sysout
		System.out.println("TerrainGrid set(Neighbour neighbour, TerrainGrid grid) called");
		neighbours.put(neighbour, grid);
		System.out.println("TerrainGrid set(Neighbour neighbour, TerrainGrid grid) returned");
	}
}
