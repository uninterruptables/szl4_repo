package team.uninter.mordorq.gamespace;

public class RoadGrid extends TerrainGrid implements TargetPublisher{

	protected RoadGrid(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getUtility() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void attach(TargetSubscriber subscriber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detach(TargetSubscriber subscriber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifySubscribers() {
		// TODO Auto-generated method stub
		
	}
	
	//TODO szerintem ez nem is kell
	public EnemyTroop getTarget(){
		System.out.println("RoadGrid getTarget called");
		//TODO return value
		System.out.println("RoadGrid getTarget returned");
		return null;
	}
	
	public Trap getTrap(){
		System.out.println("RoadGrid getTrap called");
		//TODO return value
		System.out.println("RoadGrid getTrap returned");
		return null;
	}
	
	public void setTrap(Trap trap){
		System.out.println("RoadGrid setTrap called");
		System.out.println("RoadGrid setTrap returned");
	}
	
	public Vulnerable getVulnerable(){
		System.out.println("RoadGrid getVulnerable called");
		//TODO return value
		System.out.println("RoadGrid getVulnerable returned");
		return null;
	}
	
	public void setVulnerable(Vulnerable vulnerable){
		System.out.println("RoadGrid setVulnerable called");
		System.out.println("RoadGrid setVulnerable returned");
	}
	
	public void remove(Vulnerable vulnerable){
		System.out.println("RoadGrid remove called");
		System.out.println("RoadGrid remove returned");
	}
	
	public void setUtility(int utility){
		System.out.println("RoadGrid setUtility called");
		System.out.println("RoadGrid setUtility returned");
	}
	
	public boolean isAvailableFor(Trap trap){
		System.out.println("RoadGrid isAvailableFor called");
		//TODO return value
		System.out.println("RoadGrid isAvailableFor returned");
		return true;
	}
	
	public boolean isAvailableFor(Tower tower){
		System.out.println("RoadGrid isAvailableFor called");
		//TODO return value
		System.out.println("RoadGrid isAvailableFor returned");
		return true;
	}
	
	public void repaint(){
		System.out.println("RoadGrid repaint called");
		System.out.println("RoadGrid repaint returned");
	}
}
