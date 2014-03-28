package team.uninter.mordorq.gamespace;

import java.util.ArrayList;
import java.util.Vector;
import java.util.HashMap;
import java.util.Map;

import team.uninter.mordorq.gamespace.Tower.Missile.MissileState;
import team.uninter.mordorq.utils.GameConstants;

public class BasicTower extends Tower {
	
	//One of the few descendants of the Tower class, with no special methods, but certain values.
	public BasicTower( int x,int y){
		super (x, y);
		//TODO remove sysout
		System.out.println("BasicTower.Basictower(x,y) called");
		this.radius = GameConstants.BASIC_TOWER_RADIUS;
		System.out.println("BasicTower.Basictower(x,y) returned");
	}
	
	public BasicTower(){
		super();
		//TODO remove sysout
		System.out.println("BasicTower.BasicTower() called");
		this.radius = GameConstants.BASIC_TOWER_RADIUS;
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
	
	
public static class BasicMissile extends Missile {

	public BasicMissile(int x, int y){
		super( x, y);
		//TODO remove sysout
		System.out.println("BasicMissile.BasicMissile(x,y) called");
		this.maxCooldown = GameConstants.BASIC_TOWER_MAXCOOLDOWN;
		racialDamages.put("dwarf", GameConstants.BASIC_MISSILE_DWARF_DAMAGE);
		racialDamages.put("human", GameConstants.BASIC_MISSILE_HUMAN_DAMAGE);
		racialDamages.put("elf", GameConstants.BASIC_MISSILE_ELF_DAMAGE);
		racialDamages.put("hobbit", GameConstants.BASIC_MISSILE_HOBBIT_DAMAGE);
		System.out.println("BasicMissile.BasicMissile(x,y) returned");
	}
	
}



}