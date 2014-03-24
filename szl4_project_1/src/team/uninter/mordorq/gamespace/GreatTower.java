package team.uninter.mordorq.gamespace;

import java.util.ArrayList;
import java.util.Vector;
import java.util.HashMap;
import java.util.Map;

import team.uninter.mordorq.gamespace.BasicTower.BasicMissile;
import team.uninter.mordorq.gamespace.Tower.Missile;
import team.uninter.mordorq.gamespace.Tower.Missile.MissileState;

public class GreatTower extends Tower {
	
	public GreatTower( int x,int y){
		super (x, y);
		//TODO remove sysout
		System.out.println("GreatTower.GreatTower(x,y) called");
		missile = createMissile();
		roadGrids = new ArrayList<TargetPublisher>();
		System.out.println("GreatTower.GreatTower(x,y) returned");
	}
	
	public GreatTower(){
		super();
		//TODO remove sysout
		System.out.println("GreatTower.GreatTower() called");
		missile = createMissile();
		roadGrids = new ArrayList<TargetPublisher>();
		System.out.println("GreatTower.GreatTower() returned");
	}
	
	public void notifyWith(EnemyTroop target){
		//TODO remove sysout
		System.out.println("GreatTower.notifyWith(EnemyTroop targer) called");
		MissileState actualState = this.missile.getState();
		if(actualState.equals(MissileState.WAITING)){
			fire(target);
		}
		System.out.println("GreatTower.notifyWith(EnemyTroop targer) returned");
	}
	
	public GreatMissile createMissile(){	
		//TODO remove sysout
		System.out.println("GreatTower.createMissile() called");
		GreatMissile greatMissile = new GreatMissile(this.x,this.y);
		System.out.println("GreatTower.createMissile() returned");
		return greatMissile;
	}
	
	
public static class GreatMissile extends Missile {

	public GreatMissile(int x, int y){
		super( x, y);
		//TODO remove sysout
		System.out.println("GreatMissile.GreatMissile(x,y) called");
		System.out.println("GreatMissile.GreatMissile(x,y) returned");
	}
	
}
	
}