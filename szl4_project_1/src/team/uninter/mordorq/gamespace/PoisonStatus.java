package team.uninter.mordorq.gamespace;

public class PoisonStatus extends StatusModifier{

	//A class used to simulate a damage over time effect on the enemy troops.
	//During different animation cycles, the affect method is called, that deals damage
	//to the enemy troop it affects.
	private static int poisonDuration;
	private static int poisonDamage;
	private EnemyTroop target;
	
	static{
		poisonDuration = 21;
		poisonDamage = 5;
	}
	
	public PoisonStatus()	{
		super();
		this.duration = poisonDuration;
	}
	
	/** (non-Javadoc)
	 * @see team.uninter.mordorq.gamespace.StatusModifier#affect(team.uninter.mordorq.gamespace.EnemyTroop)
	 */
	@Override
	public void affect(EnemyTroop enemy) {	
		this.target = enemy;
		this.target.setHealth(enemy.getHealth() - poisonDamage);
	}

	/* (non-Javadoc)
	 * @see team.uninter.mordorq.gamespace.StatusModifier#reverseAffect(team.uninter.mordorq.gamespace.EnemyTroop)
	 */
	@Override
	public void reverseAffect(EnemyTroop enemy) {}

	/* (non-Javadoc)
	 * @see team.uninter.mordorq.gamespace.StatusModifier#apply(team.uninter.mordorq.gamespace.EnemyTroop)
	 */
	@Override
	public void apply(EnemyTroop enemy) {
		enemy.add(this);
	}
	
	@Override
	public void setDuration(int duration){
		affect(target);
		this.duration = duration;
	}
}
