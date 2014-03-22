package team.uninter.mordorq.gamespace;

public class WeakenStatus {
	float weakenAmount;
	EnemyTroop affectedEntity;
	
	public WeakenStatus(float weakenAmount)
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
