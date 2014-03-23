package team.uninter.mordorq.gamespace;

public class PoisonStatus extends StatusModifier{

	//A class used to simulate a damage over time effect on the enemy troops.
	//During different animation cycles, the affect method is called, that deals damage
	//to the enemy troop it affects.
	float damagePerTick;
	
	public PoisonStatus()
	{
		System.out.println("PoisonStatus() called");
		System.out.println("PoisonStatus() returned");
	}
	
	public PoisonStatus(float damagePerTick)
	{
		System.out.println("PoisonStatus(float) called");
		this.damagePerTick=damagePerTick;
		System.out.println("PoisonStatus(float) returned");
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
