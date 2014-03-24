package team.uninter.mordorq.gamespace;

import java.util.ArrayList;
import java.util.Vector;
import java.util.HashMap;
import java.util.Map;

import team.uninter.mordorq.gamespace.Tower.Missile.MissileState;
import team.uninter.mordorq.utils.GameConstants;

public class BasicTower extends Tower {
	
	public BasicTower( int x,int y){
		super (x, y);
		//TODO remove sysout
		System.out.println("BasicTower.Basictower(x,y) called");
		missile = createMissile();
		roadGrids = new ArrayList<TargetPublisher>();
		System.out.println("BasicTower.Basictower(x,y) returned");
	}
	
	public BasicTower(){
		super();
		//TODO remove sysout
		System.out.println("BasicTower.BasicTower() called");
		missile = createMissile();
		roadGrids = new ArrayList<TargetPublisher>();
		System.out.println("BasicTower.BasicTower() returned");
	}
	
	public void notifyWith(EnemyTroop target){
		//TODO remove sysout
		System.out.println("BasicTower.notifyWith(EnemyTroop targer) called");
		MissileState actualState = this.missile.getState();
		if(actualState.equals(MissileState.WAITING)){
			fire(target);
		}
		System.out.println("BasicTower.notifyWith(EnemyTroop targer) returned");
	}
	
	public BasicMissile createMissile(){	
		//TODO remove sysout
		System.out.println("BasicTower.createMissile() called");
		BasicMissile basicMissile = new BasicMissile(this.x,this.y);
		System.out.println("BasicTower.createMissile() returned");
		return basicMissile;
	}

	@Override
	public void attach(TargetPublisher publisher) {
		//TODO remove sysout
		System.out.println("BasicTower.attach() called");
		this.roadGrids.add(publisher);
		System.out.println("BasicTower.attach() returned");
	}
	
	@Override
	public void inject(Injectable injectable) {
		//TODO remove sysout
		System.out.println("BasicTower.inject() called");
		injectable.injectOn(this);
		System.out.println("BasicTower.inject() returned");
		
	}
	
public static class BasicMissile extends Missile {

	public BasicMissile(int x, int y){
		super( x, y);
		//TODO remove sysout
		System.out.println("BasicMissile.BasicMissile(x,y) called");
		System.out.println("BasicMissile.BasicMissile(x,y) returned");
	}
	
}


}