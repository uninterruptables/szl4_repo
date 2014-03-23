package team.uninter.mordorq.gamespace;

import java.util.Vector;
import java.util.HashMap;
import java.util.Map;

public class LongDistanceTower extends Tower implements Injectable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int radius;
	private Map<String, ?> damagetable;
	protected int cooldown;
	
	public LongDistanceTower( int x,int y){
			super (x, y);
		//TODO remove sysout
		System.out.println("LongDistanceTower.LongDistanceTower(x,y) called");
		missile = createMissile();
		System.out.println("LongDistanceTower.LongDistanceTower(x,y) returned");
	}
	
	public void fire(EnemyTroop target){
		
		//TODO remove sysout
				System.out.println("LongDistanceTower.fire(EnemyTroop target) called");
				this.notifyWith(target); 
				
				System.out.println("LongDistanceTower.fire(EnemyTroop target) returned");
		
	}
	
	public void notifyWith(EnemyTroop target){
		//TODO remove sysout
			System.out.println("LongDistanceTower.notifyWith(EnemyTroop targer) called");
			System.out.println("LongDistanceTower.notifyWith(EnemyTroop targer) returned");
	
	
	}
	
	public LongDistanceMissile createMissile(){	
		
		//TODO remove sysout
				System.out.println("LongDistanceTower.createMissile() called");
				LongDistanceMissile lmissile = new LongDistanceMissile(x,  y);
				
				
				System.out.println("LongDistanceTower.createMissile() returned");
				return lmissile;
	}
	
	
	public void setRadius(int x){
		
		//TODO remove sysout
		System.out.println("LongDistanceTower.setRadius() called");
		this.radius=x;
		System.out.println("LongDistanceTower.setRadius() returned");
	}
	
	public float getRadius(){
		//TODO remove sysout
		System.out.println("LongDistanceTower.getRadius() called");
		System.out.println("LongDistanceTower.getRadius() returned");
		
		return this.radius;
	}


public class LongDistanceMissile extends Missile {


	
	public LongDistanceMissile(int x, int y){
		super( x, y);
		
	}
	
	
	public void set(int cooldown){
		//TODO remove sysout
				System.out.println("LongDistanceMissile.set(int cooldown) called");
				System.out.println("LongDistanceMissile.set(int cooldown) returned");
	}
	
	public Map<String, ?> getElfDamage(){
		//TODO remove sysout
		System.out.println("LongDistanceMissile.getElfDamage() called");
		System.out.println("LongDistanceMissile.getElfDamage() returned");
		return damagetable;
	}
	
	public Map<String, ?> getHumanDamage(){
		//TODO remove sysout
		System.out.println("LongDistanceMissile.getHumanDamage() called");
		System.out.println("LongDistanceMissile.getHumanDamage() returned");
		return damagetable;
	}
	
	public Map<String, ?> getDwarfDamage(){
		//TODO remove sysout
				System.out.println("LongDistanceMissile.getDwarfDamage() called");
				System.out.println("LongDistanceMissile.getDwarfDamage() returned");
				return damagetable;
				}
	
	public Map<String, ?> getHobbitDamage(){
		//TODO remove sysout
				System.out.println("LongDistanceMissile.getHobbitDamage() called");
								
				System.out.println("LongDistanceMissile.getHobbitDamage() returned");
				return damagetable; 
	}
	
	
}
protected LongDistanceMissile bmissile;

@Override
public void attach(TargetPublisher publisher) {
	// TODO Auto-generated method stub
	
}

@Override
public boolean canInjectOn(Tower tower) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean canInjectOn(Trap trap) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public void injectOn(Injectable injectable) {
	// TODO Auto-generated method stub
	
}

@Override
public void castOn(GameObject object) {
	// TODO Auto-generated method stub
	
}
}