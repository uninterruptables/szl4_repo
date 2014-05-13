package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.utils.GameConstants;

public class SlowStatus extends StatusModifier{
	
	//A class used to simulate a slow effect on the enemy troops.
	//During different animation cycles, the affect method is called, that slows
	//the enemy troop by increasing it's cooldown. If it already affects it, it does not
	//do anything.
	
//	private static int slowDuration;
	private int slowAmount;
	
//	static{
//		slowDuration = 10;
//		slowAmount = 5;
//	}

//	public SlowStatus() {
//		super();
//		super.duration = slowDuration;
//	}

	public SlowStatus(){
		slowAmount = GameConstants.SLOWER_TRAP_SLOW_AMOUNT;
		this.duration = GameConstants.SLOWER_STATUS_DURATION;
		id = GameConstants.STATUS_MODIFIER_ID++;
	}
	
	public SlowStatus(int slowAmount, int duration, int identifier)
	{
		this.slowAmount = slowAmount;
		this.duration = duration;
		id = identifier;
	}


	@Override
	public void affect(EnemyTroop enemy) {
		enemy.setMaxCooldown(enemy.getMaxCooldown() + slowAmount);
	}


	@Override
	public void reverseAffect(EnemyTroop enemy) {
		enemy.setMaxCooldown(enemy.getMaxCooldown() - slowAmount);
	}


	@Override
	public void apply(EnemyTroop enemy) {
//		enemy.add(this);
		for(StatusModifier sm : enemy.getModifiers()){
			if(sm.getId() == this.id){
				sm.setDuration(GameConstants.SLOWER_STATUS_DURATION);
				return;
			}
		}

		SlowStatus newStatus = new SlowStatus(this.slowAmount, GameConstants.SLOWER_STATUS_DURATION, this.id);
		enemy.add(newStatus);
		newStatus.affect(enemy);
	}
	
	
}
