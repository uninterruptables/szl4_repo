package team.uninter.mordorq.gamespace;

@SuppressWarnings("serial")
abstract public class TerrainGrid extends GameObject{

	protected TerrainGrid(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public TerrainGrid get(Neighbour neighbour){
		System.out.println("TerrainGrid get called");
		//TODO return value
		System.out.println("TerrainGrid get returned");
		return null;
	}
	
	public void set(Neighbour neighbour, TerrainGrid grid){
		System.out.println("TerrainGrid set called");
		System.out.println("TerrainGrid set returned");
	}
	
	abstract public int getUtility();
	
	public boolean isAvailableFor(Trap trap){
		System.out.println("TerrainGrid isAvailableFor called");
		//TODO return value
		System.out.println("TerrainGrid isAvailableFor returned");
		return true;
	}
	
	public boolean isAvailableFor(Tower tower){
		System.out.println("TerrainGrid isAvailableFor called");
		//TODO return value
		System.out.println("TerrainGrid isAvailableFor returned");
		return true;
	}

}
