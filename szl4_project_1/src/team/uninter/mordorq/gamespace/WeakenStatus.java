package team.uninter.mordorq.gamespace;

public class WeakenStatus extends StatusModifier{
	
	//A class used to simulate a weaken effect on the enemy troops.
	//During different animation cycles, the affect method is called, that weakens
	//the enemy troop by decreasing it's damage. If it already affects it, it does not
	//do anything.
	float weakenAmount;
	
	public WeakenStatus()
	{
		System.out.println("WeakenStatus() called");
		System.out.println("WeakenStatus() returned");
	}
	
	public WeakenStatus(float weakenAmount)
	{
		System.out.println("WeakenStatus(float) called");
		this.weakenAmount=weakenAmount;
		System.out.println("WeakenStatus(float) returned");
	}
	public WeakenStatus(float weakenAmount, int duration)
	{
		System.out.println("WeakenStatus(float, EnemyTroop) called");
		System.out.println("WeakenStatus(float, EnemyTroop) returned");
	}
	
	public void affect()
	{
		System.out.println("WeakenStatus.affect() called");
		System.out.println("WeakenStatus.affect() returned");
	}
}
