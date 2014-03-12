package szl4.uninterruptables.gamespace;

import szl4.uninterruptables.gamespace.Tower.Missile.MissileState;

@SuppressWarnings("serial")
abstract public class Tower extends InjectionTarget 
					implements TargetSubscriber, Controlable{

	protected Tower(int x, int y) {
		super(x, y);
		missile = createMissile();
	}

	final public void controlIt(){
		missile.controlIt();
	}
	
	final public boolean isActive(){
		if(missile.state.equals(MissileState.FIRE_READY)){
			EnemyTroop target = getNewTarget();
			missile.setTarget(target);
			if(target == null) missile.set(MissileState.WAITING);
			else {
				int _x = target.getX(); //+ target.getImage().getWidth() / 2;
				int _y = target.getY();
				missile.setTargetPosition(_x, _y);
			}
		}
		return missile.isActive();
	}
	
	protected abstract Missile createMissile();
	protected EnemyTroop getNewTarget(){
		//TODO:
		return null;
	}
	
	public abstract static class Missile extends GameObject implements Controlable{
		
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
			this.state = state;
		}
		
		public EnemyTroop getTarget(){
			return target;
		}
		
		public void setTarget(EnemyTroop target){
			this.target = target;
		}
		
		protected void moveAhead(){
			//TODO:
		}
		
		public void setTargetPosition(int x, int y){
			this.setX(x);
			this.setY(y);
		}
		
		public boolean isActive(){
			// return this.state != MissileState.WAITING;
			return !this.state.equals(MissileState.WAITING);
		}
		
		public enum MissileState{
			WAITING, DORMANT, FIRE_READY, ON_THE_FLY
		}
		
		private int cooldown;
		private MissileState state;
		private EnemyTroop target;
		private int targetX, targetY;
	}
	
	protected Missile missile;
}
