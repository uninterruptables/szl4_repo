package team.uninter.mordorq.gamespace;

public class GroundGrid extends TerrainGrid{

	private boolean available = true;
	private Tower tower;
	private int utility = 0;
	
	public GroundGrid(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public void reserve(Tower tower){
		//TODO remove sysout
		System.out.println("GroundGrid reserve(Tower tower) called");
		this.tower = tower;
		available = false;
		System.out.println("GroundGrid reserve(Tower tower) returned");
	}
	
	@Override
	boolean isAvailableFor(Trap trap) {
		//TODO remove sysout
		System.out.println("GroundGrid isAvailableFor(Trap trap) called");
		System.out.println("GroundGrid isAvailableFor(Trap trap) returned");
		return false;
	}

	@Override
	boolean isAvailableFor(Tower tower) {
		//TODO remove sysout
		System.out.println("GroundGrid isAvailableFor(Tower tower) called");
		System.out.println("GroundGrid isAvailableFor(Tower tower) returned");
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
