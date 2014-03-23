package team.uninter.mordorq.gamespace;

import java.util.Vector;
import java.util.HashMap;
import java.util.Map;

public class FastTower extends Tower implements Injectable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int radius;
	private Map<String, ?> damagetable;
	
	public FastTower( int x,int y){
		super (x, y);
		fmissile= createMissile();
		//TODO remove sysout
		System.out.println("FastTower.FastTower(x,y) called");
		System.out.println("FastTower.FastTower(x,y) returned");
	}
	
	public void fire(EnemyTroop target){
		this.notifyWith(target); 
		//TODO remove sysout
				System.out.println("FastTower.fire(EnemyTroop targer) called");
				System.out.println("FastTower.fire(EnemyTroop targer) returned");
		
	}
	
	public void notifyWith(EnemyTroop target){
		//TODO remove sysout
			System.out.println("FastTower.notifyWith(EnemyTroop targer) called");
			System.out.println("FastTower.notifyWith(EnemyTroop targer) returned");
	
	
	}
	
	public FastMissile createMissile(){	
		
		//TODO remove sysout
				System.out.println("FastTower.createMissile() called");
				FastMissile fmissile = new FastMissile(x,  y);
				
				
				System.out.println("FastTower.createMissile() returned");
				return fmissile;
	}
	
	
	public void setRadius(int x){
		this.radius=x;
		//TODO remove sysout
		System.out.println("FastTower.setRadius() called");
		System.out.println("FastTower.setRadius() returned");
	}
	
	public int getRadius(){
		//TODO remove sysout
		System.out.println("FastTower.setRadius() called");
		System.out.println("FastTower.setRadius() returned");
		
		return this.radius;
	}


public class FastMissile extends Missile {


	
	public FastMissile(int x, int y){
		super( x, y);
		
	}
	
	public void controlIt(){
		//TODO remove sysout
		System.out.println("FastMissile.controlIt() called");
		System.out.println("FastMissile.controlIt() returned");
		
	}
	public void set(int cooldown){
		//TODO remove sysout
				System.out.println("FastMissile.set(int cooldown) called");
				System.out.println("FastMissile.set(int cooldown) returned");
	}
	
	public Map<String, ?> getElfDamage(){
		//TODO remove sysout
		System.out.println("FastMissile.getElfDamage() called");
		System.out.println("FastMissile.getElfDamage() returned");
		return damagetable;
	}
	
	public Map<String, ?> getHumanDamage(){
		//TODO remove sysout
		System.out.println("FastMissile.getHumanDamage() called");
		System.out.println("FastMissile.getHumanDamage() returned");
		return damagetable;
	}
	
	public Map<String, ?> getDwarfDamage(){
		//TODO remove sysout
				System.out.println("FastMissile.getDwarfDamage() called");
				System.out.println("FastMissile.getDwarfDamage() returned");
				return damagetable;
				}
	
	public Map<String, ?> getHobbitDamage(){
		//TODO remove sysout
				System.out.println("FastMissile.getHobbitDamage() called");
								
				System.out.println("FastMissile.getHobbitDamage() returned");
				return damagetable; 
	}
	
	
}
protected FastMissile fmissile;

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

@Override
public void injectOn(InjectionTarget target) {
	// TODO Auto-generated method stub
	
}

@Override
public void inject(Injectable injectable) {
	// TODO Auto-generated method stub
	
}
}