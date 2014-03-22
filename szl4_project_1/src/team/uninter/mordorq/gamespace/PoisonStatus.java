package team.uninter.mordorq.gamespace;

public class PoisonStatus {

	float damagePerTick;
	EnemyTroop affectedEntity;
	
	public PoisonStatus(float damagePerTick)
	{
		System.out.println("PoisonStatus(float, EnemyTroop) called");
		System.out.println("PoisonStatus(float, EnemyTroop) returned");
	}
	
	public void affect()
	{
		System.out.println("PoisonStatus.affect() called");
		System.out.println("PoisonStatus.affect() returned");
	}
}
