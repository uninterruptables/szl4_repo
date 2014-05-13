package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.utils.GameConstants;

public class PoisonStatus extends StatusModifier{

	//A class used to simulate a damage over time effect on the enemy troops.
	//During different animation cycles, the affect method is called, that deals damage
	//to the enemy troop it affects.
//	private static int poisonDuration;
	private int poisonDamage;
//	private EnemyTroop target;
	
//	static{
//		poisonDuration = 21;
//		poisonDamage = 5;
//	}
	
//	public PoisonStatus()	{
//		super();
//		this.duration = poisonDuration;
//	}

	public PoisonStatus()
	{
		poisonDamage = GameConstants.POISONOUS_TRAP_POISON_AMOUNT;
		this.duration = GameConstants.POISONOUS_STATUS_DURATION;
		id = GameConstants.STATUS_MODIFIER_ID++;
	}
	
	public PoisonStatus(int poisonDamage, int duration, int identifier)
	{
		this.poisonDamage = poisonDamage;
		this.duration = duration;
		id = identifier;
	}
	
	@Override
	public void affect(EnemyTroop enemy) {	
//		this.target = enemy;
//		this.target.setHealth(enemy.getHealth() - poisonDamage);
		enemy.setHealth(enemy.getHealth() - this.poisonDamage);
	}

	@Override
	public void reverseAffect(EnemyTroop enemy) {
		
	}

	@Override
	public void apply(EnemyTroop enemy) {
//		enemy.add(this);
		for(StatusModifier sm : enemy.getModifiers()){
			if(sm.getId() == this.id){
				sm.setDuration(GameConstants.POISONOUS_STATUS_DURATION);
				return;
			}
		}

		PoisonStatus newStatus = new PoisonStatus(this.poisonDamage, GameConstants.POISONOUS_STATUS_DURATION, this.id);
		enemy.add(newStatus);
		newStatus.affect(enemy);
	}
	
}
