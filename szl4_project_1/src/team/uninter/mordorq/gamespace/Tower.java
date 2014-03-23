package team.uninter.mordorq.gamespace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import team.uninter.mordorq.gamespace.Tower.Missile.MissileState;

@SuppressWarnings("serial")
abstract public class Tower extends InjectionTarget 
					implements TargetSubscriber, Controlable{

	protected int radius;
	protected Missile missile;
	protected List<TargetPublisher> roadGrids;
	
	protected Tower(int x, int y) {
		super(x, y);
		//TODO remove sysout
		System.out.println("Tower.Tower(x,y) called");
		missile = createMissile();
		roadGrids = new ArrayList<TargetPublisher>();
		System.out.println("Tower.Tower(x,y) returned");
	}
	
	protected Tower(){
		super();
		//TODO remove sysout
		System.out.println("Tower.Tower() called");
		missile = createMissile();
		roadGrids = new ArrayList<TargetPublisher>();
		System.out.println("Tower.Tower() returned");
	}
	
	protected abstract Missile createMissile();
	
	final public void controlIt(){
		//TODO remove sysout
		System.out.println("Tower controlIt() called");
		missile.controlIt();
		System.out.println("Tower controlIt() returned");
	}
	
	public void fire(EnemyTroop enemy){
		//TODO remove sysout
		System.out.println("Tower controlIt() called");
		missile.setPosition(getX(), getY());
		missile.setTarget(enemy);
		System.out.println("Tower controlIt() returned");
	}
	
	public final void castOn(TerrainGrid targetGrid){
		//TODO remove sysout
		System.out.println("Tower.castOn(TerrainGrid) called");
		((GroundGrid)targetGrid).reserve(this);
		System.out.println("Tower.castOn(TerrainGrid) returned");
	}
	
	public final boolean canInject(Injectable inj){
		//TODO remove sysout
		System.out.println("Tower.canInject(Injectable) : bool called");
		if(inj.canInjectOn(this))
		{
			System.out.println("Tower.canInject(Injectable) : true returned");
			return true;
		}
		else
		{
			System.out.println("Tower.canInject(Injectable) : false returned");
			return false;
		}
	}
	
	public final int getSpeciesDamage(String type){
		//TODO remove sysout
		System.out.println("Tower.getSpeciesDamage(String) : int called");
		int damage = (int)missile.racialDamages.get(type);
		System.out.println("Tower.getSpeciesDamage(String) : int returned");
		return damage;
	}
	
	public final void setSpeciesDamage(String type, int value){
		//TODO remove sysout
		System.out.println("Tower.setSpeciesDamage(String, int) called");
		missile.racialDamages.put(type, value);
		System.out.println("Tower.setSpeciesDamage(String, int) returned");
	}
	
	public final int getRadius()
	{
		//TODO remove sysout
		System.out.println("Tower.getRadius() : int called");
		System.out.println("Tower.getRadius() : int returned");
		return radius;	
	}
	
	public final void setRadius(int newRadius)
	{
		//TODO remove sysout
		System.out.println("Tower.setRadius(int) called");
		this.radius = newRadius;
		System.out.println("Tower.setRadius(int) returned");
	}
	
	public final int getMaxCooldown()
	{
		//TODO remove sysout
		System.out.println("Tower.getMaxCooldown() : int called");
		System.out.println("Tower.getMaxCooldown() : int returned");
		return missile.maxCooldown;
	}
	
	public final void setMaxCooldown(int newMaxCooldown)
	{
		//TODO remove sysout
		System.out.println("Tower.setMaxCooldown(int) called");
		missile.maxCooldown = newMaxCooldown;
		System.out.println("Tower.setMaxCooldown(int) returned");
	}
	
	public void addAllDamage(int damage)
	{
		//TODO remove sysout
		System.out.println("Tower.addAllDamage(int) called");
		for (String key : missile.racialDamages.keySet()) {
		    missile.racialDamages.put(key, missile.racialDamages.get(key)+damage);
		}
		System.out.println("Tower.addAllDamage(int) returned");
	}
	
	final public boolean isActive(){
		//TODO remove sysout
		System.out.println("Tower.isActive() called");
		if(missile.state.equals(MissileState.FIRE_READY)){
			EnemyTroop target = getNewTarget();
			if(target == null) missile.set(MissileState.WAITING);
			else fire(target);
		}
		System.out.println("Tower.isActive() returned");
		return missile.isActive();
	}
	
	protected EnemyTroop getNewTarget(){
		//TODO remove sysout
		System.out.println("Tower.getNewTarget() called");
		EnemyTroop target = (EnemyTroop) roadGrids.get(0);
		System.out.println("Tower.getNewTarget() returned");
		return null;
	}
	
	public abstract static class Missile extends GameObject implements Controlable{
		
		private int deltaXY;
		private HashMap<String, Integer> racialDamages;
		private int cooldown, maxCooldown;
		private MissileState state;
		private EnemyTroop target;
		private int targetX, targetY;
		
		protected Missile(int x, int y){
			super(x,y);
			//TODO remove sysout
			System.out.println("Missile.Missile(x,y) called");
			state = MissileState.WAITING;
			System.out.println("Missile.Missile(x,y) returned");
		}
		
		public void controlIt(){
			//TODO remove sysout
			System.out.println("Missile.controlIt() called");
			if(cooldown > 0){
				cooldown--;
				if(cooldown <= 0) state = MissileState.FIRE_READY;
			}
			else{
				moveAhead();
				if(this.getX()==targetX && this.getY()==targetY){
					target.interactWith(this);
				}
			}
			System.out.println("Missile.controlIt() returned");
		}
		
		public void set(MissileState state){
			//TODO remove sysout
			System.out.println("Missile.set(MissileState) called");
			if(state.equals(MissileState.WAITING)) setTarget(null);
			this.state = state;
			System.out.println("Missile.set(MissileState) returned");
		}
		
		public EnemyTroop getTarget(){
			//TODO remove sysout
			System.out.println("Missile.getTarget() called");
			System.out.println("Missile.getTarget() returned");
			return target;
		}
		
		public void setTarget(EnemyTroop target){
			//TODO remove sysout
			System.out.println("Missile.setTarget(EnemyTroop) called");
			this.target = target;
			if(this.target != null){
				int x = this.target.getX();
				int y = this.target.getY();
				int _x = x + 10/2; //TODO
				int _y = y + 10/2;
				this.setTargetPosition( _x,_y );
				this.set(MissileState.ON_THE_FLY);
			}
			System.out.println("Missile.setTarget(EnemyTroop) returned");
		}
		
		public void setDeltaXY(int deltaXY){
			//TODO remove sysout
			System.out.println("Missile.setDeltaXY(int) called");
			this.deltaXY = deltaXY;
			System.out.println("Missile.setDeltaXY(int) returned");
		}
		
		protected void moveAhead(){
			//TODO remove sysout
			System.out.println("Missile.moveAhead() called");
			this.x += deltaXY;
			this.y += deltaXY;
			System.out.println("Missile.moveAhead() returned");
		}
		
		protected void setPosition(int x, int y){
			//TODO remove sysout
			System.out.println("Missile.setPosition(x,y) called");
			this.setX(x);
			this.setY(y);
			System.out.println("Missile.setPosition(x,y) returned");
		}
		
		public void setTargetPosition(int x, int y){
			//TODO remove sysout
			System.out.println("Missile.setTargetPosition(x,y) called");
			this.targetX = x;
			this.targetY = y;
			System.out.println("Missile.setTargetPosition(x,y) returned");
		}
		
		public boolean isActive(){
			//TODO remove sysout
			System.out.println("Missile.isActive() called");
			System.out.println("Missile.isActive() returned");
			return !this.state.equals(MissileState.WAITING);
		}
		
		public enum MissileState{
			WAITING, DORMANT, FIRE_READY, ON_THE_FLY}
		}
	
	
}
