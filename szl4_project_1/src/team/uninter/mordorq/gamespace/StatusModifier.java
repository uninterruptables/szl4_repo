package team.uninter.mordorq.gamespace;

public abstract class StatusModifier extends GameObject{
	
	//Generic class used to handle different status modifiing effects. It has an affected 
	//entity, as an enemy troop, and a duration. Each status modifier must create they own 
	//affect method to simulate their effects.
	protected EnemyTroop affectedEntity;
	protected int duration;
	
	abstract public void affect();
	public void apply(EnemyTroop enemy, int duration)
	{
		System.out.println("StatusModifier.apply(EnemyTroop, Int) called");
		System.out.println("StatusModifier.apply(EnemyTroop, Int) returned");
	}
	
	public EnemyTroop getAffectedEntity()
	{
		System.out.println("StatusModifier.getAffectedEntity : EnemyTroop called");
		System.out.println("StatusModifier.getAffectedEntity : EnemyTroop returned");
		return affectedEntity;
	}
	public int getDuration(){
		System.out.println("StatusModifier.getDuration() : int called");
		System.out.println("StatusModifier.getDuration() : int returned");
		return duration;
	}

}
