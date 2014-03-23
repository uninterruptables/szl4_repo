package team.uninter.mordorq.gamespace;

public class SlowStatus extends StatusModifier{
	
	//A class used to simulate a slow effect on the enemy troops.
	//During different animation cycles, the affect method is called, that slows
	//the enemy troop by increasing it's cooldown. If it already affects it, it does not
	//do anything.
	
	float slowAmount;

	public SlowStatus()
	{
		System.out.println("SlowStatus() called");
		System.out.println("SlowStatus() returned");
	}
	public SlowStatus(float slowAmount)
	{
		System.out.println("SlowStatus(float) called");
		this.slowAmount=slowAmount;
		System.out.println("SlowStatus(float) returned");
	}
	public SlowStatus(float slowAmount, int duration)
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
