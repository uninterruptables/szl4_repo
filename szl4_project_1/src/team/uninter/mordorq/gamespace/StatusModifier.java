package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.utils.GameConstants;

public abstract class StatusModifier extends GameObject{
	
	//Generic class used to handle different status modifiing effects. It has an affected 
	//entity, as an enemy troop, and a duration. Each status modifier must create they own 
	//affect method to simulate their effects.
	protected int duration;
	protected int id;
	
	abstract public void affect(EnemyTroop enemy);
	
	abstract public void reverseAffect(EnemyTroop enemy);
	
	abstract public void apply(EnemyTroop enemy);
	
	
	public final int getId(){
		return id;
	}
	
	
	public final int getDuration(){
		return duration;
	}
	
	public final void setDuration(int duration){
		this.duration = duration;
	}

}
