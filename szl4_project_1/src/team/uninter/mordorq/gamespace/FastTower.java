package team.uninter.mordorq.gamespace;

import java.util.ArrayList;
import java.util.Vector;
import java.util.HashMap;
import java.util.Map;

import team.uninter.mordorq.gamespace.BasicTower.BasicMissile;
import team.uninter.mordorq.gamespace.Tower.Missile;
import team.uninter.mordorq.gamespace.Tower.Missile.MissileState;
import team.uninter.mordorq.utils.GameConstants;

public class FastTower extends Tower {
	//One of the few descendants of the Tower class, with no special methods, but certain values.
	public FastTower( int x,int y){
		super (x, y);
		//TODO remove sysout
		System.out.println("FastTower.FastTower(x,y) called");
		missile = createMissile();
		roadGrids = new ArrayList<TargetPublisher>();
		System.out.println("FastTower.FastTower(x,y) returned");
	}
	
	public FastTower(){
		super();
		//TODO remove sysout
		System.out.println("FastTower.FastTower() called");
		missile = createMissile();
		roadGrids = new ArrayList<TargetPublisher>();
		System.out.println("FastTower.FastTower() returned");
	}
	
	public void notifyWith(EnemyTroop target){
		//TODO remove sysout
		System.out.println("FastTower.notifyWith(EnemyTroop targer) called");
		MissileState actualState = this.missile.getState();
		if(actualState.equals(MissileState.WAITING)){
			fire(target);
		}
		System.out.println("FastTower.notifyWith(EnemyTroop targer) returned");
	}
	
	public FastMissile createMissile(){	
		//TODO remove sysout
		System.out.println("FastTower.createMissile() called");
		FastMissile fastMissile = new FastMissile(this.x,this.y);
		System.out.println("FastTower.createMissile() returned");
		return fastMissile;
	}
	
	
public static class FastMissile extends Missile {

	public FastMissile(int x, int y){
		super( x, y);
		//TODO remove sysout
		System.out.println("FastMissile.FastMissile(x,y) called");
		System.out.println("FastMissile.FastMissile(x,y) returned");
	}
	
}

}