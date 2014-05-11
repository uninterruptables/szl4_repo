package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.utils.GameConstants;

public class WeakenStatus extends StatusModifier{
	
	//A class used to simulate a weaken effect on the enemy troops.
	//During different animation cycles, the affect method is called, that weakens
	//the enemy troop by decreasing it's damage. If it already affects it, it does not
	//do anything.
	private int weakenAmount;
	
	public WeakenStatus()
	{
		weakenAmount = GameConstants.DECREASE_DAMAGE_TRAP_WEAKEN_AMOUNT;
		this.duration = GameConstants.WEAKEN_STATUS_DURATION;
		id = GameConstants.STATUS_MODIFIER_ID++;
	}
	
	public WeakenStatus(int weakenAmount)
	{
		this.weakenAmount = weakenAmount;
		this.duration = GameConstants.WEAKEN_STATUS_DURATION;
		id = GameConstants.STATUS_MODIFIER_ID++;
	}
	public WeakenStatus(int weakenAmount, int duration)
	{
		this.weakenAmount = weakenAmount;
		this.duration = duration;
		id = GameConstants.STATUS_MODIFIER_ID++;
	}
	
	public WeakenStatus(int weakenAmount, int duration, int identifier)
	{
		this.weakenAmount = weakenAmount;
		this.duration = duration;
		id = identifier;
	}
	
	public void affect(EnemyTroop enemy)
	{
		enemy.setDamage(enemy.getDamage() - this.weakenAmount);
	}
	
	public void reverseAffect(EnemyTroop enemy)
	{
		enemy.setDamage(enemy.getDamage() + this.weakenAmount);
	}
	
	public void apply(EnemyTroop enemy)
	{
		for(StatusModifier sm : enemy.getModifiers()){
			if(sm.getId() == this.id){
				sm.setDuration(GameConstants.WEAKEN_STATUS_DURATION);
				return;
			}
		}

		WeakenStatus newStatus = new WeakenStatus(this.weakenAmount, GameConstants.WEAKEN_STATUS_DURATION, this.id);
		enemy.add(newStatus);
		newStatus.affect(enemy);
	}
	
	public int getWeakenAmount(){
		return this.weakenAmount;
	}
	
	public void setWeakenAmount(int newWeakenAmount){
		this.weakenAmount = newWeakenAmount;
	}
	
}
