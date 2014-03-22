package team.uninter.mordorq.gamespace;

public class SlowStatus {

	float slowAmount;
	EnemyTroop affectedEntity;
	public SlowStatus(float slowAmount)
	{
		System.out.println("SlowStatus(float, EnemyTroop) called");
		System.out.println("SlowStatus(float, EnemyTroop) returned");
	}
	public void affect()
	{
		System.out.println("SlowStatus.affect() called");
		System.out.println("SlowStatus.affect() returned");
	}
}
