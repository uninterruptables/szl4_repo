package team.uninter.mordorq.gamespace;

public class GroundGrid extends TerrainGrid{

	private boolean available = true;
	private Tower tower;
	
	public GroundGrid(int x, int y) {
		super(x, y);
		//TODO remove sysout
		System.out.println("GroundGrid.GroundGrid(x,y) called");
		System.out.println("GroundGrid.GroundGrid(x,y) returned");
	}
	
	public GroundGrid(int utility) {
		super(utility);
		//TODO remove sysout
		System.out.println("GroundGrid.GroundGrid(utility) called");
		System.out.println("GroundGrid.GroundGrid(utility) returned");
	}
	
	public GroundGrid() {
		super(0);
		//TODO remove sysout
		System.out.println("GroundGrid.GroundGrid() called");
		System.out.println("GroundGrid.GroundGrid() returned");
	}
	
	public void reserve(Tower tower){
		//TODO remove sysout
		System.out.println("GroundGrid reserve(Tower tower) called");
		this.tower = tower;
		this.tower.setX(this.x);
		this.tower.setY(this.y);
		available = false;
		System.out.println("GroundGrid reserve(Tower tower) returned");
	}
	
	@Override
	public boolean isAvailableFor(Trap trap) {
		//TODO remove sysout
		System.out.println("GroundGrid isAvailableFor(Trap trap) called");
		System.out.println("GroundGrid isAvailableFor(Trap trap) returned false");
		return false;
	}

	@Override
	public boolean isAvailableFor(Tower tower) {
		//TODO remove sysout
		System.out.println("GroundGrid isAvailableFor(Tower tower) called");
		System.out.println("GroundGrid isAvailableFor(Tower tower) returned true");
		return true;
	}
	
	public void repaint(){
		//TODO remove sysout
		System.out.println("GroundGrid repaint() called");
		//TODO not implemented yet
		System.out.println("GroundGrid repaint() returned");
	}

	@Override
	public int getUtility() {
		// TODO remove sysout
		System.out.println("GroundGrid getUtility() called");
		System.out.println("GroundGrid getUtility() returned");
		return utility;
	}

	public Tower getTower(){
		// TODO remove sysout
		System.out.println("GroundGrid Tower getTower() called");
		System.out.println("GroundGrid Tower getTower() returned");
		return tower;
	}
	
}
