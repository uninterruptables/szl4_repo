package team.uninter.mordorq.gamespace;

import java.util.List;
import java.lang.Math;

public class RoadGrid extends TerrainGrid implements TargetPublisher{

	private Trap trap;
	private Vulnerable vulnerable;
	private List<TargetSubscriber> subscribers;
	
	
	public RoadGrid(int x, int y) {
		super(x, y);
		//TODO remove sysout
		System.out.println("RoadGrid.RoadGrid(x,y) called");
		System.out.println("RoadGrid.RoadGrid(x,y) returned");
	}
	
	public RoadGrid(int utility) {
		super(utility);
		//TODO remove sysout
		System.out.println("RoadGrid.RoadGrid(utility) called");
		System.out.println("RoadGrid.RoadGrid(utility) returned");
	}
	
	public RoadGrid(){
		super();
		//TODO remove sysout
		System.out.println("RoadGrid.RoadGrid() called");
		System.out.println("RoadGrid.RoadGrid() returned");
	}

	@Override
	public void attach(TargetSubscriber subscriber) {
		// TODO remove sysout
		System.out.println("RoadGrid attach(TargetSubscriber subscriber) called");
		subscribers.add(subscriber);
		System.out.println("RoadGrid attach(TargetSubscriber subscriber) returned");
		
	}

	@Override
	public void detach(TargetSubscriber subscriber) {
		// TODO remove sysout
		System.out.println("RoadGrid detach(TargetSubscriber subscriber) called");
		subscribers.remove(subscribers.indexOf(subscriber));
		System.out.println("RoadGrid detach(TargetSubscriber subscriber) returned");
		
	}

	@Override
	public void notifyAllWith(EnemyTroop troop) {
		// TODO remove sysout
		System.out.println("RoadGrid notifyAllWith() called");
		setVulnerable(troop);
		for(TargetSubscriber t : subscribers){
			t.notifyWith(troop);
		}
		System.out.println("RoadGrid notifyAllWith() returned");
	}
	
	@Override
	public boolean contains(EnemyTroop troop) {
		// TODO remove sysout
		System.out.println("RoadGrid notifyAllWith() called");
		System.out.println("RoadGrid notifyAllWith() returned");
		return subscribers.contains(troop);
	}
	
	public void remove(){
		//TODO remove sysout
		System.out.println("RoadGrid remove() called");
		vulnerable = null;
		System.out.println("RoadGrid remove() returned");
	}
	
	public boolean isAvailableFor(Trap trap){
		//TODO remove sysout
		System.out.println("RoadGrid isAvailableFor(Trap trap) called");
		System.out.println("RoadGrid isAvailableFor(Trap trap) returned true");
		return true;
	}
	
	public boolean isAvailableFor(Tower tower){
		//TODO remove sysout
		System.out.println("RoadGrid isAvailableFor(Tower tower) called");
		System.out.println("RoadGrid isAvailableFor(Tower tower) returned false");
		return false;
	}
	
	public void repaint(){
		//TODO remove sysout
		System.out.println("RoadGrid repaint() called");
		//TODO not implemented yet
		System.out.println("RoadGrid repaint() returned");
	}
	
	@Override
	public EnemyTroop getTarget() {
		// TODO remove sysout
		System.out.println("RoadGrid getTarget() called");
		EnemyTroop targetEnemy = null;
		if(vulnerable instanceof EnemyTroop){
			targetEnemy = (EnemyTroop)vulnerable;
		}
		System.out.println("RoadGrid getTarget() returned");
		return targetEnemy;
	}
	
	public Trap getTrap(){
		//TODO remove sysout
		System.out.println("RoadGrid getTrap() called");
		System.out.println("RoadGrid getTrap() returned");
		return trap;
	}
	
	public Vulnerable getVulnerable(){
		//TODO remove sysout
		System.out.println("RoadGrid getVulnerable() called");
		System.out.println("RoadGrid getVulnerable() returned");
		return vulnerable;
	}
	
	public void setUtility(int utility){
		//TODO remove sysout
		System.out.println("RoadGrid setUtility(int utility) called");
		this.utility = utility;
		System.out.println("RoadGrid setUtility(int utility) returned");
	}
	
	public void setTrap(Trap trap){
		//TODO remove sysout
		System.out.println("RoadGrid setTrap called");
		this.trap = trap;
		System.out.println("RoadGrid setTrap returned");
	}
	
	public void setVulnerable(Vulnerable vulnerable){
		//TODO remove sysout
		System.out.println("RoadGrid setVulnerable(Vulnerable vulnerable) called");
		this.vulnerable = vulnerable;
		((GameObject)this.vulnerable).setX(this.x);
		((GameObject)this.vulnerable).setY(this.y);
		System.out.println("RoadGrid setVulnerable(Vulnerable vulnerable) returned");
	}

	@Override
	public InjectionTarget getInjectionTarget() {
		//TODO remove sysout
		System.out.println("RoadGrid getInjectionTarget() called");
		System.out.println("RoadGrid getInjectionTarget() returned");
		return trap;
	}

	@Override
	public boolean isAvailableFor(Barricade barricade) {
		//TODO remove sysout
		System.out.println("RoadGrid isAvailableFor(Barricade) called");
		System.out.println("RoadGrid isAvailableFor(Barricade) returned");
		return true;
	}


}
