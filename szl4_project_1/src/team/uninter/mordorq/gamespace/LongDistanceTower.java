package team.uninter.mordorq.gamespace;

import java.util.ArrayList;
import java.util.Vector;
import java.util.HashMap;
import java.util.Map;

import team.uninter.mordorq.gamespace.BasicTower.BasicMissile;
import team.uninter.mordorq.gamespace.Tower.Missile;
import team.uninter.mordorq.gamespace.Tower.Missile.MissileState;

public class LongDistanceTower extends Tower {

	public LongDistanceTower( int x,int y){
		super (x, y);
		//TODO remove sysout
		System.out.println("LongDistanceTower.LongDistanceTower(x,y) called");
		missile = createMissile();
		roadGrids = new ArrayList<TargetPublisher>();
		System.out.println("LongDistanceTower.LongDistanceTower(x,y) returned");
	}
	
	public LongDistanceTower(){
		super();
		//TODO remove sysout
		System.out.println("LongDistanceTower.LongDistanceTower() called");
		missile = createMissile();
		roadGrids = new ArrayList<TargetPublisher>();
		System.out.println("LongDistanceTower.LongDistanceTower() returned");
	}
	
	public void notifyWith(EnemyTroop target){
		//TODO remove sysout
		System.out.println("LongDistanceTower.notifyWith(EnemyTroop targer) called");
		MissileState actualState = this.missile.getState();
		if(actualState.equals(MissileState.WAITING)){
			fire(target);
		}
		System.out.println("LongDistanceTower.notifyWith(EnemyTroop targer) returned");
	}
	
	public LongDistanceMissile createMissile(){	
		//TODO remove sysout
		System.out.println("LongDistanceTower.createMissile() called");
		LongDistanceMissile longDistanceMissile = new LongDistanceMissile(this.x,this.y);
		System.out.println("LongDistanceTower.createMissile() returned");
		return longDistanceMissile;
	}
	
	
public static class LongDistanceMissile extends Missile {

	public LongDistanceMissile(int x, int y){
		super( x, y);
		//TODO remove sysout
		System.out.println("LongDistanceMissile.LongDistanceMissile(x,y) called");
		System.out.println("LongDistanceMissile.LongDistanceMissile(x,y) returned");
	}
	
}
	
}