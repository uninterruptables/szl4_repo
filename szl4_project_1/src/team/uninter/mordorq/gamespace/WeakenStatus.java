package team.uninter.mordorq.gamespace;

public class WeakenStatus extends StatusModifier{
	float weakenAmount;
	
	public WeakenStatus(float weakenAmount, int duration)
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
