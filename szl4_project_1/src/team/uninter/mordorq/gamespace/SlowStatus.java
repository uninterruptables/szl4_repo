package team.uninter.mordorq.gamespace;

public class SlowStatus extends StatusModifier{
	
	//A class used to simulate a slow effect on the enemy troops.
	//During different animation cycles, the affect method is called, that slows
	//the enemy troop by increasing it's cooldown. If it already affects it, it does not
	//do anything.
	
	private static int slowDuration;
	private static int slowAmount;
	
	static{
		slowDuration = 10;
		slowAmount = 5;
	}

	public SlowStatus() {
		super();
		super.duration = slowDuration;
	}


	/* (non-Javadoc)
	 * @see team.uninter.mordorq.gamespace.StatusModifier#affect(team.uninter.mordorq.gamespace.EnemyTroop)
	 */
	@Override
	public void affect(EnemyTroop enemy) {
		enemy.setMaxCooldown(enemy.getMaxCooldown() + slowAmount);
	}

	/* (non-Javadoc)
	 * @see team.uninter.mordorq.gamespace.StatusModifier#reverseAffect(team.uninter.mordorq.gamespace.EnemyTroop)
	 */
	@Override
	public void reverseAffect(EnemyTroop enemy) {
		enemy.setMaxCooldown(enemy.getMaxCooldown() - slowAmount);
	}

	/** (non-Javadoc)
	 * @see team.uninter.mordorq.gamespace.StatusModifier#apply(team.uninter.mordorq.gamespace.EnemyTroop)
	 */
	@Override
	public void apply(EnemyTroop enemy) {
		enemy.add(this);
	}
	
	
}
