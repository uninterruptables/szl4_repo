package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.utils.GameConstants;

public class WeakenStatus extends StatusModifier{
	
	//A class used to simulate a weaken effect on the enemy troops.
	//During different animation cycles, the affect method is called, that weakens
	//the enemy troop by decreasing it's damage. If it already affects it, it does not
	//do anything.
	int weakenAmount;
	
	public WeakenStatus()
	{
//		System.out.println("WeakenStatus() called");
		weakenAmount = GameConstants.DECREASE_DAMAGE_TRAP_WEAKEN_AMOUNT;
		id = GameConstants.STATUS_MODIFIER_ID++;
//		System.out.println("WeakenStatus() returned");
	}
	
	public WeakenStatus(int weakenAmount)
	{
//		System.out.println("WeakenStatus(float) called");
		this.weakenAmount=weakenAmount;
		id = GameConstants.STATUS_MODIFIER_ID++;
//		System.out.println("WeakenStatus(float) returned");
	}
	public WeakenStatus(int weakenAmount, int duration)
	{
//		System.out.println("WeakenStatus(float, EnemyTroop) called");
		this.weakenAmount=weakenAmount;
		this.duration = duration;
		id = GameConstants.STATUS_MODIFIER_ID++;
//		System.out.println("WeakenStatus(float, EnemyTroop) returned");
	}
	
	public WeakenStatus(int weakenAmount, int duration, int identifier)
	{
//		System.out.println("WeakenStatus(float, EnemyTroop) called");
		this.weakenAmount=weakenAmount;
		this.duration = duration;
		id = identifier;
//		System.out.println("WeakenStatus(float, EnemyTroop) returned");
	}
	
	public void affect(EnemyTroop enemy)
	{
//		System.out.println("WeakenStatus.affect() called");
		enemy.setDamage(enemy.getDamage() - this.weakenAmount);
//		System.out.println("WeakenStatus.affect() returned");
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
