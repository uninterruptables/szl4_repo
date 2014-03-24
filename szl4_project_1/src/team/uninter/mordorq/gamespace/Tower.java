package team.uninter.mordorq.gamespace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import team.uninter.mordorq.gamespace.Tower.Missile.MissileState;
import team.uninter.mordorq.utils.GameConstants;

@SuppressWarnings("serial")
abstract public class Tower extends InjectionTarget 
					implements TargetSubscriber, Controlable{

	protected int cooldown;
	protected int radius;
	protected Missile missile;
	protected List<TargetPublisher> roadGrids;
	
	public Tower(int x, int y) {
		super(x, y);
		//TODO remove sysout
		System.out.println("Tower.Tower(x,y) called");
		missile = createMissile();
		roadGrids = new ArrayList<TargetPublisher>();
		System.out.println("Tower.Tower(x,y) returned");
	}
	
	public Tower(){
		super();
		//TODO remove sysout
		System.out.println("Tower.Tower() called");
		missile = createMissile();
		roadGrids = new ArrayList<TargetPublisher>();
		System.out.println("Tower.Tower() returned");
	}
	
	protected abstract Missile createMissile();
	
	public final void controlIt(){
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
	
	public final boolean canCastOn(TerrainGrid grid)
	{
		System.out.println("Tower.canCastOn(TerrainGrid) called");
		grid.isAvailableFor(this);
		System.out.println("Tower.canCastOn(TerrainGrid) returned");
		return false;
		
	}
	
	public final void inject(Injectable inject)
	{
		System.out.println("Tower.Inject(Injectable) returned");
		inject.injectOn(this);
		System.out.println("Tower.Inject(Injectable) returned");
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
	
	public EnemyTroop getNewTarget(){
		//TODO remove sysout
		System.out.println("Tower.getNewTarget() called");
		EnemyTroop target = (EnemyTroop) roadGrids.get(0);
		System.out.println("Tower.getNewTarget() returned");
		return null;
	}
	
	public abstract static class Missile extends GameObject implements Controlable{
		
		private int deltaXY;
		protected HashMap<String, Integer> racialDamages;
		protected int cooldown, maxCooldown;
		private MissileState state;
		private EnemyTroop target;
		private int targetX, targetY;
		
		protected Missile(int x, int y){
			super(x,y);
			//TODO remove sysout
			System.out.println("Missile.Missile(x,y) called");
			racialDamages = new HashMap<String, Integer>();
			racialDamages.put("dwarf", 10);
			racialDamages.put("human", 10);
			racialDamages.put("elf", 10);
			racialDamages.put("hobbit", 10);
			//biztonság kedvéért...kiszedni
			racialDamages.put("DWARF", 10);
			racialDamages.put("HUMAN", 10);
			racialDamages.put("ELF", 10);
			racialDamages.put("HOBBIT", 10);
			state = MissileState.WAITING;
			System.out.println("Missile.Missile(x,y) returned");
		}
		
		public final void controlIt(){
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
		
		public final MissileState getState(){
			//TODO remove sysout
			System.out.println("Missile.getState called");
			System.out.println("Missile.getState returned");
			return state;
		}
		
		public final void set(MissileState state){
			//TODO remove sysout
			System.out.println("Missile.set(MissileState) called");
			if(state.equals(MissileState.WAITING)) setTarget(null);
			this.state = state;
			System.out.println("Missile.set(MissileState) returned");
		}
		
		public final void set(int cooldown){
			//TODO remove sysout
			System.out.println("Missile.set(int cooldown) called");
			this.cooldown = cooldown;
			System.out.println("Missile.set(int cooldown) returned");
		}
		
		public final EnemyTroop getTarget(){
			//TODO remove sysout
			System.out.println("Missile.getTarget() called");
			System.out.println("Missile.getTarget() returned");
			return target;
		}
		
		public final void setTarget(EnemyTroop target){
			//TODO remove sysout
			System.out.println("Missile.setTarget(EnemyTroop) called");
			this.target = target;
			if(this.target != null){
				int x = this.target.getX();
				int y = this.target.getY();
				int _x = x + GameConstants.GRID_SIZE/2;
				int _y = y + GameConstants.GRID_SIZE/2;
				this.setTargetPosition( _x,_y );
				this.set(MissileState.ON_THE_FLY);
			}
			System.out.println("Missile.setTarget(EnemyTroop) returned");
		}
		
		public final void setDeltaXY(int deltaXY){
			//TODO remove sysout
			System.out.println("Missile.setDeltaXY(int) called");
			this.deltaXY = deltaXY;
			System.out.println("Missile.setDeltaXY(int) returned");
		}
		
		public final void moveAhead(){
			//TODO remove sysout
			System.out.println("Missile.moveAhead() called");
			this.x += deltaXY;
			this.y += deltaXY;
			System.out.println("Missile.moveAhead() returned");
		}
		
		public final void setPosition(int x, int y){
			//TODO remove sysout
			System.out.println("Missile.setPosition(x,y) called");
			this.setX(x);
			this.setY(y);
			System.out.println("Missile.setPosition(x,y) returned");
		}
		
		public final void setTargetPosition(int x, int y){
			//TODO remove sysout
			System.out.println("Missile.setTargetPosition(x,y) called");
			this.targetX = x;
			this.targetY = y;
			System.out.println("Missile.setTargetPosition(x,y) returned");
		}
		
		public final boolean isActive(){
			//TODO remove sysout
			System.out.println("Missile.isActive() called");
			System.out.println("Missile.isActive() returned");
			return !this.state.equals(MissileState.WAITING);
		}
		
		public final int getElfDamage(){
			//TODO remove sysout
			System.out.println("Tower.getElfDamage() called");
			System.out.println("Tower.getElfDamage() returned");
			return this.racialDamages.get("Elf");
		}
		
		public final int getHumanDamage(){
			//TODO remove sysout
			System.out.println("Tower.getHumanDamage() called");
			System.out.println("Tower.getHumanDamage() returned");
			return this.racialDamages.get("Human");
		}
		
		public final int getDwarfDamage(){
			//TODO remove sysout
			System.out.println("Tower.getDwarfDamage() called");
			System.out.println("Tower.getDwarfDamage() returned");
			return this.racialDamages.get("Dwarf");
		}
		
		public final int getHobbitDamage(){
			//TODO remove sysout
			System.out.println("Tower.getHobbitDamage() called");
			System.out.println("Tower.getHobbitDamage() returned");
			return this.racialDamages.get("Hobbit");
		}
		
		public enum MissileState{
			WAITING, DORMANT, FIRE_READY, ON_THE_FLY}
		}
		
	
}
