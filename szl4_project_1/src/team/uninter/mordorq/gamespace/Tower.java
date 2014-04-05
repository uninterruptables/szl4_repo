package team.uninter.mordorq.gamespace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import team.uninter.mordorq.gamespace.Tower.Missile.MissileState;
import team.uninter.mordorq.utils.GameConstants;

@SuppressWarnings("serial")
abstract public class Tower extends InjectionTarget 
					implements TargetSubscriber, Controlable{

	protected int radius;
	protected Missile missile;
	protected FogStatus fogStatus = null;
	protected List<TargetPublisher> roadGrids;
	
	public Tower(int x, int y) {
		super(x, y);
		missile = createMissile();
		roadGrids = new ArrayList<TargetPublisher>();
	}
	
	public Tower(){
		super();
		missile = createMissile();
		roadGrids = new ArrayList<TargetPublisher>();
	}
	
	
	protected abstract Missile createMissile();
	
	/**
	 * Controls the behavior of the <code>Tower</code> and also
	 * the <code>Missile</code> managed by this tower.
	 * */
	public final void controlIt(){
		if(fogStatus != null) {
			fogStatus.setDuration(fogStatus.getDuration() - 1);
			if(fogStatus.getDuration() - 1 <= 0) {
				removeFogStatus();
			}
		}
		missile.controlIt();
	}
	
	/**
	 * Sets the currently active <code>FogStatus</code>.
	 * 
	 * @param fogStatus the new instance of <code>FogStatus</code> that is about to be active.
	 * */
	public void setFogStatus(FogStatus fogStatus){
		if(this.fogStatus != null) removeFogStatus();
		this.fogStatus = fogStatus;
		this.fogStatus.affect(this);
	}
	
	/**
	 * Removes the effects of the currently active <code>FogStatus</code>
	 * */
	private void removeFogStatus(){
		fogStatus.reverseAffect(this);
		fogStatus = null;
	}
	
	public FogStatus getFogStatus(){
		return fogStatus;
	}
	
	public void fire(EnemyTroop enemy){
		missile.setPosition(getX(), getY());
		missile.setTarget(enemy);
	}
	
	public final void castOn(TerrainGrid targetGrid){
		((GroundGrid)targetGrid).reserve(this);
	}
	
	public final boolean canInject(Injectable inj){
		if(inj.canInjectOn(this)) return true;
		else	return false;
	}
	
	public final void attach(TargetPublisher publisher) {
		this.roadGrids.add(publisher);
	}
	
	public final boolean canCastOn(TerrainGrid grid) {
		if(grid.isAvailableFor(this)) return true;
		else return false;	
	}
	
	public final void inject(Injectable inject) {
		inject.injectOn(this);
	}
	
	public final int getSpeciesDamage(String type){
		return (int)missile.racialDamages.get(type);
	}
	
	public final void setSpeciesDamage(String type, int value){
		missile.racialDamages.put(type, value);
	}
	
	public final int getRadius() {
		return radius;	
	}
	
	public final void setRadius(int newRadius) {
		this.radius = newRadius;
	}
	
	public final int getMaxCooldown()	{
		return missile.maxCooldown;
	}
	
	public final void setMaxCooldown(int newMaxCooldown)	{
		missile.maxCooldown = newMaxCooldown;
	}
	
	public void addAllDamage(int damage) {
		for (String key : missile.racialDamages.keySet()) {
		    missile.racialDamages.put(key, missile.racialDamages.get(key)+damage);
		}
	}
	
	final public boolean isActive(){
		if(missile.state.equals(MissileState.FIRE_READY)){
			EnemyTroop target = getNewTarget();
			if(target == null) missile.set(MissileState.WAITING);
			else fire(target);
		}
		return missile.isActive();
	}
	
	/**
	 * Acquire a new target for the <code>Missile</code> that is about to be
	 * fired.
	 * 
	 * @return a new target acquired from the <code>TargetPublisher</code>s in range
	 * of this Tower
	 * @see Tower#fire(EnemyTroop)
	 * */
	private EnemyTroop getNewTarget(){
		List<TargetPublisher> inrangeGrids = inRange(roadGrids);
		for(TargetPublisher publisher : inrangeGrids) {
			if(publisher.contains(missile.getTarget())) {
				return missile.getTarget();
			}
		}
		for(TargetPublisher publisher : inrangeGrids){
			EnemyTroop target = publisher.getTarget();
			if(target != null) {
				return target;
			}
		}
		return null;
	}
	
	/**
	 * Filters the given list if its necessary and by the new radius set
	 * by an active <code>FogStatus</code>.
	 * 
	 * @param publishers that needed to be filtered
	 * @return a list containing the filtered, valid results
	 * */
	private List<TargetPublisher> inRange(List<TargetPublisher> publishers){
		if(fogStatus == null) return publishers;
		List<TargetPublisher> result = new ArrayList<TargetPublisher>();
		for(TargetPublisher pub : publishers)
			if(pub.isInRangeOf(this)) result.add(pub);
		return result;
	}
	
	public abstract static class Missile extends GameObject implements Controlable{
		
		private int deltaX, deltaY;
		protected HashMap<String, Integer> racialDamages;
		protected int cooldown, maxCooldown;
		private MissileState state;
		private EnemyTroop target;
		private int targetX, targetY;
		
		protected Missile(int x, int y){
			super(x,y);
			racialDamages = new HashMap<String, Integer>();
			state = MissileState.WAITING;
		}
		
		public final void controlIt(){
			if(cooldown > 0){
				cooldown--;
				if(cooldown <= 0) state = MissileState.FIRE_READY;
			}
			else{
				moveAhead();
				if(inRange()){
					target.interactWith(this);
					this.set(maxCooldown);
					this.set(MissileState.DORMANT);
				}
			}
		}
		
		protected boolean inRange(){
			int xDistance = Math.abs(targetX - getX());
			int yDistance = Math.abs(targetY - getY());
			int distance = (int) Math.sqrt(xDistance^2 + yDistance^2);
			
			if(distance <= GameConstants.MISSILE_VELOCITY) return true;
			else return false;
		}
		
		public final MissileState getState(){
			return state;
		}
		
		public final void set(MissileState state){
			if(state.equals(MissileState.WAITING)) setTarget(null);
			this.state = state;
		}
		
		public final void set(int cooldown){
			this.cooldown = cooldown;
		}
		
		public final EnemyTroop getTarget(){
			return target;
		}
		
		public final void setTarget(EnemyTroop target){
			this.target = target;
			if(this.target != null){
				this.set(MissileState.ON_THE_FLY);
			}
		}
		
		protected final void setDeltaX(int deltaX){
			this.deltaX = deltaX;
		}
		
		protected final void setDeltaY(int deltaY){
			this.deltaY = deltaY;
		}
		
		protected final void moveAhead(){
			setTargetPosition(target.getX()+GameConstants.GRID_SIZE/2, target.getY()+GameConstants.GRID_SIZE/2);
			int xVector = targetX - getX();
			int yVector = targetY - getY();
//			int vectorLength = (int) Math.round(Math.sqrt(xVector^2 + yVector^2));
			int vectorLength = (int) Math.sqrt(Math.pow(xVector, 2) + Math.pow(yVector, 2));
			float xNormal = (xVector*(1/(float)vectorLength));
			float yNormal = (yVector*(1/(float)vectorLength));
			
			this.deltaX = Math.round(xNormal*GameConstants.MISSILE_VELOCITY);
			this.deltaY = Math.round(yNormal*GameConstants.MISSILE_VELOCITY);
			
			this.x += deltaX;
			this.y += deltaY;
		}
		
		public final void setPosition(int x, int y){
			this.setX(x);
			this.setY(y);
		}
		
		public final void setTargetPosition(int x, int y){
			this.targetX = x;
			this.targetY = y;
		}
		
		public final boolean isActive(){
			return !this.state.equals(MissileState.WAITING);
		}
		
		public final int getElfDamage(){
			return this.racialDamages.get("elf");
		}
		
		public final int getHumanDamage(){
			return this.racialDamages.get("human");
		}
		
		public final int getDwarfDamage(){
			return this.racialDamages.get("dwarf");
		}
		
		public final int getHobbitDamage(){
			return this.racialDamages.get("hobbit");
		}
		
		/**
		 * Indicates the states that a <code>Missile</code> can be in
		 * during its life cycle.
		 * */
		public enum MissileState{
			WAITING, DORMANT, FIRE_READY, ON_THE_FLY
		}
	}	
}
