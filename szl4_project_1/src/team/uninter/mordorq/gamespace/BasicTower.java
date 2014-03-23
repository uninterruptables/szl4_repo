package team.uninter.mordorq.gamespace;

import java.util.Vector;
import java.util.HashMap;
import java.util.Map;

public class BasicTower extends Tower implements Injectable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int radius;
	private Map<String, ?> damagetable;
	protected int cooldown;
	
	public BasicTower( int x,int y){
			super (x, y);
		//TODO remove sysout
		System.out.println("BasicTower.Basictower(x,y) called");
	
		bmissile= createMissile();
		System.out.println("BasicTower.Basictower(x,y) returned");
	}
	
	public void fire(EnemyTroop target){
		
		//TODO remove sysout
				System.out.println("BasicTower.fire(EnemyTroop target) called");
				this.notifyWith(target); 
				
				System.out.println("BasicTower.fire(EnemyTroop target) returned");
		
	}
	
	public void notifyWith(EnemyTroop target){
		//TODO remove sysout
			System.out.println("BasicTower.notifyWith(EnemyTroop targer) called");
			System.out.println("BasicTower.notifyWith(EnemyTroop targer) returned");
	
	
	}
	
	public BasicMissile createMissile(){	
		
		//TODO remove sysout
				System.out.println("BasicTower.createMissile() called");
				BasicMissile bmissile = new BasicMissile(x,  y);
				
				
				System.out.println("Basic.createMissile() returned");
				return bmissile;
	}
	
	
	public void setRadius(int x){
		
		//TODO remove sysout
		System.out.println("BasicTower.setRadius() called");
		this.radius=x;
		System.out.println("BasicTower.setRadius() returned");
	}
	
	public float getRadius(){
		//TODO remove sysout
		System.out.println("BasicTower.getRadius() called");
		System.out.println("BasicTower.getRadius() returned");
		
		return this.radius;
	}


public class BasicMissile extends Missile {


	
	public BasicMissile(int x, int y){
		super( x, y);
		
	}
	
	public void controlIt(){
		//TODO remove sysout
		System.out.println("BasicMissile.controlIt() called");
		System.out.println("BasicMissile.controlIt() returned");
		
	}
	public void set(int cooldown){
		//TODO remove sysout
				System.out.println("BasicMissile.set(int cooldown) called");
				System.out.println("BasicMissile.set(int cooldown) returned");
	}
	
	public Map<String, ?> getElfDamage(){
		//TODO remove sysout
		System.out.println("BasicMissile.getElfDamage() called");
		System.out.println("BasicMissile.getElfDamage() returned");
		return damagetable;
	}
	
	public Map<String, ?> getHumanDamage(){
		//TODO remove sysout
		System.out.println("BasicMissile.getHumanDamage() called");
		System.out.println("BasicMissile.getHumanDamage() returned");
		return damagetable;
	}
	
	public Map<String, ?> getDwarfDamage(){
		//TODO remove sysout
				System.out.println("BasicMissile.getDwarfDamage() called");
				System.out.println("BasicMissile.getDwarfDamage() returned");
				return damagetable;
				}
	
	public Map<String, ?> getHobbitDamage(){
		//TODO remove sysout
				System.out.println("BasicMissile.getHobbitDamage() called");
								
				System.out.println("BasicMissile.getHobbitDamage() returned");
				return damagetable; 
	}
	
	
}
protected BasicMissile bmissile;

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