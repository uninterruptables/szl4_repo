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
