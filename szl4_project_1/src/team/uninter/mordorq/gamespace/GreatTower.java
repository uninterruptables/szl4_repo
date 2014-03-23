package team.uninter.mordorq.gamespace;

import java.util.Vector;
import java.util.HashMap;
import java.util.Map;

public class GreatTower extends Tower implements Injectable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int radius;
	private Map<String, ?> damagetable;
	protected int cooldown;
	
	public GreatTower( int x,int y){
			super (x, y);
		//TODO remove sysout
		System.out.println("GreatTower.LongDistanceTower(x,y) called");
		gmissile = createMissile();
		System.out.println("GreatTower.LongDistanceTower(x,y) returned");
	}
	
	public void fire(EnemyTroop target){
		
		//TODO remove sysout
				System.out.println("GreatTower.fire(EnemyTroop target) called");
				this.notifyWith(target); 
				
				System.out.println("GreatTower.fire(EnemyTroop target) returned");
		
	}
	
	public void notifyWith(EnemyTroop target){
		//TODO remove sysout
			System.out.println("GreatTower.notifyWith(EnemyTroop targer) called");
			System.out.println("GreatTower.notifyWith(EnemyTroop targer) returned");
	
	
	}
	
	public GreatMissile createMissile(){	
		
		//TODO remove sysout
				System.out.println("GreatTower.createMissile() called");
				GreatMissile gmissile = new GreatMissile(x,  y);
				
				
				System.out.println("GreatTower.createMissile() returned");
				return gmissile;
	}
	
	
	public void setRadius(int x){
		
		//TODO remove sysout
		System.out.println("GreatTower.setRadius() called");
		this.radius=x;
		System.out.println("GreatTower.setRadius() returned");
	}
	
	public float getRadius(){
		//TODO remove sysout
		System.out.println("GreatTower.getRadius() called");
		System.out.println("GreatTower.getRadius() returned");
		
		return this.radius;
	}


public class GreatMissile extends Missile {


	
	public GreatMissile(int x, int y){
		super( x, y);
		
	}
	
	
	public void set(int cooldown){
		//TODO remove sysout
				System.out.println("GreatMissile.set(int cooldown) called");
				System.out.println("GreatMissile.set(int cooldown) returned");
	}
	
	public Map<String, ?> getElfDamage(){
		//TODO remove sysout
		System.out.println("GreatMissile.getElfDamage() called");
		System.out.println("GreatMissile.getElfDamage() returned");
		return damagetable;
	}
	
	public Map<String, ?> getHumanDamage(){
		//TODO remove sysout
		System.out.println("GreatMissile.getHumanDamage() called");
		System.out.println("GreatMissile.getHumanDamage() returned");
		return damagetable;
	}
	
	public Map<String, ?> getDwarfDamage(){
		//TODO remove sysout
				System.out.println("GreatMissile.getDwarfDamage() called");
				System.out.println("GreatMissile.getDwarfDamage() returned");
				return damagetable;
				}
	
	public Map<String, ?> getHobbitDamage(){
		//TODO remove sysout
				System.out.println("GreatMissile.getHobbitDamage() called");
								
				System.out.println("GreatMissile.getHobbitDamage() returned");
				return damagetable; 
	}
	
	
}
protected GreatMissile gmissile;

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