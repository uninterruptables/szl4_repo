package team.uninter.mordorq.gamespace;

import java.util.HashMap;

import team.uninter.mordorq.gamespace.Tower.Missile.MissileState;

@SuppressWarnings("serial")
abstract public class Tower extends InjectionTarget 
					implements TargetSubscriber, Controlable{

	int radius;
	protected Tower(int x, int y) {
		super(x, y);
		missile = createMissile();
	}
	
	final public void controlIt(){
		missile.controlIt();
	}
	
	public void fire(EnemyTroop enemy){
		missile.setPosition(getX(), getY());
		missile.setTarget(enemy);
	}
	
	public final void castOn(TerrainGrid grid)
	{
		//TODO:
		System.out.println("Tower.castOn(TerrainGrid) returned");
		System.out.println("Tower.castOn(TerrainGrid) returned");
	}
	
	public final boolean canInject(Injectable inj)
	{
		System.out.println("Tower.canInject(Injectable) : bool called");
		if(inj.canInjectOn(this))
		{
			System.out.println("Tower.canInject(Injectable) : bool returned");
			return true;
		}
		else
		{
			System.out.println("Tower.canInject(Injectable) : bool returned");
			return false;
		}
	}
	public final int getSpeciesDamage(String type)
	{
		System.out.println("Tower.getSpeciesDamage(String) : int called");
		System.out.println("Tower.getSpeciesDamage(String) : int returned");
		return (int)missile.racialDamages.get(type);
	}
	
	public final void setSpeciesDamage(String type, int value)
	{
		System.out.println("Tower.setSpeciesDamage(String, int) called");
		missile.racialDamages.put(type, missile.racialDamages.get(type) + value);
		System.out.println("Tower.setSpeciesDamage(String, int) returned");
	}
	
	public final int getRadius()
	{
		System.out.println("Tower.getRadius() : int called");
		System.out.println("Tower.getRadius() : int returned");
		return radius;	
	}
	
	public final void setRadius(int newRadius)
	{
		System.out.println("Tower.setRadius(int) called");
		radius=newRadius;
		System.out.println("Tower.setRadius(int) returned");
	}
	
	public final int getMaxCooldown()
	{
		System.out.println("Tower.getMaxCooldown() : int called");
		System.out.println("Tower.getMaxCooldown() : int returned");
		return missile.maxCooldown;
	}
	
	public final void setMaxCooldown(int newMaxCooldown)
	{
		System.out.println("Tower.setMaxCooldown(int) called");
		missile.maxCooldown=newMaxCooldown;
		System.out.println("Tower.setMaxCooldown(int) returned");
	}
	
	public void addAllDamage(int damage)
	{
		System.out.println("Tower.addAllDamage(int) called");
		for (String key : missile.racialDamages.keySet()) {
		    missile.racialDamages.put(key, missile.racialDamages.get(key)+damage);
		}
		System.out.println("Tower.addAllDamage(int) returned");
	}
	
	final public boolean isActive(){
		if(missile.state.equals(MissileState.FIRE_READY)){
			EnemyTroop target = getNewTarget();
			if(target == null) missile.set(MissileState.WAITING);
			else fire(target);
		}
		return missile.isActive();
	}
	
	protected abstract Missile createMissile();
	protected EnemyTroop getNewTarget(){
		//TODO:
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
			state = MissileState.WAITING;
		}
		
		public void controlIt(){
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
		}
		
		public void set(MissileState state){
			if(state.equals(MissileState.WAITING)) setTarget(null);
			this.state = state;
		}
		
		public EnemyTroop getTarget(){
			return target;
		}
		
		public void setTarget(EnemyTroop target){
			this.target = target;
			if(this.target != null){
				int x = this.target.getX();
				int y = this.target.getY();
				int _x = x + 10/2; //TODO
				int _y = y + 10/2;
				this.setTargetPosition( _x,_y );
				this.set(MissileState.ON_THE_FLY);
			}
		}
		
		public void setDeltaXY(int deltaXY){
			this.deltaXY = deltaXY;
		}
		
		protected void moveAhead(){
			this.x += deltaXY;
			this.y += deltaXY;
		}
		
		protected void setPosition(int x, int y){
			this.setX(x);
			this.setY(y);
		}
		
		public void setTargetPosition(int x, int y){
			this.targetX = x;
			this.targetY = y;
		}
		
		public boolean isActive(){
			// return this.state != MissileState.WAITING;
			return !this.state.equals(MissileState.WAITING);
		}
		
		public enum MissileState{
			WAITING, DORMANT, FIRE_READY, ON_THE_FLY
		}
	}
	
	protected Missile missile;
}
