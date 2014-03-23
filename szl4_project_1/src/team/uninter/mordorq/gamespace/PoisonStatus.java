package team.uninter.mordorq.gamespace;

public class PoisonStatus extends StatusModifier{

	float damagePerTick;
	
	public PoisonStatus()
	{
		System.out.println("PoisonStatus() called");
		System.out.println("PoisonStatus() returned"
	}
	
	public PoisonStatus(float damagePerTick)
	{
		System.out.println("PoisonStatus(float) called");
		this.damagePerTick=damagePerTick;
		System.out.println("PoisonStatus(float) returned"
	}
	public PoisonStatus(float damagePerTick, int duration)
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
