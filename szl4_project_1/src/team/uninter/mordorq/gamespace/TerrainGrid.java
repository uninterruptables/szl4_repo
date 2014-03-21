package team.uninter.mordorq.gamespace;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
abstract public class TerrainGrid extends GameObject{

	private Map<Neighbour,TerrainGrid> neighbours;
	
	public TerrainGrid(int x, int y) {
		super(x, y);
		neighbours = new HashMap<Neighbour,TerrainGrid>();
	}
	
	abstract public int getUtility();

	abstract boolean isAvailableFor(Trap trap);
	
	abstract boolean isAvailableFor(Tower tower);
	
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
