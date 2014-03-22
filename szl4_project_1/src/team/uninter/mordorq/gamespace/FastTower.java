package team.uninter.mordorq.gamespace;

import java.util.Vector;

public class FastTower extends Tower {
	private float radius;
	
	public FasTower( int x, int y){
		super (x, y);
		fmissile= createMissile();
		//TODO remove sysout
		System.out.println("FastTower.FastTower(x,y) called");
		System.out.println("FastTower.FastTower(x,y) returned");
	}
	
	public void fire(EnemyTroop target){
		this.notifyWith();
		//TODO remove sysout
				System.out.println("FastTower.fire(EnemyTroop targer) called");
				System.out.println("FastTower.fire(EnemyTroop targer) returned");
		
	}
	
	public void notifyWith(EnemyTroop target){
		//TODO remove sysout
			System.out.println("FastTower.notifyWith(EnemyTroop targer) called");
			System.out.println("FastTower.notifyWith(EnemyTroop targer) returned");
	
	final public void controlIt (){
		fmissile.controlIt();
		//TODO remove sysout
		System.out.println("FastTower.controlIt() called");
		System.out.println("FastTower.controlIt() returned");
	}
	
	public FastMissile createMissile(){	
		FastMissile fmissile = new FastMissile;
		//TODO remove sysout
				System.out.println("FastTower.createMissile() called");
				System.out.println("FastTower.createMissile() returned");
	}
	
	
	public void setRadius(float x){
		this.radius=x;
		//TODO remove sysout
		System.out.println("FastTower.setRadius() called");
		System.out.println("FastTower.setRadius() returned");
	}
	
	public float getRadius(){
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
	
	public void int getElfDamage(){
		//TODO remove sysout
		System.out.println("FastMissile.getElfDamage() called");
		System.out.println("FastMissile.getElfDamage() returned");
	}
	
	public void int getHumanDamage(){
		//TODO remove sysout
		System.out.println("FastMissile.getHumanDamage() called");
		System.out.println("FastMissile.getHumanDamage() returned");
	}
	
	public void int getDwarfDamage(){
		//TODO remove sysout
				System.out.println("FastMissile.getDwarfDamage() called");
				System.out.println("FastMissile.getDwarfDamage() returned");
	}
	
	public void int getHobbitDamage(){
		//TODO remove sysout
				System.out.println("FastMissile.getHobbitDamage() called");
				System.out.println("FastMissile.getHobbitDamage() returned");
	}
	
	
}
protected FastMissile fmissile;
}