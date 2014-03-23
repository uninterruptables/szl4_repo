package team.uninter.mordorq.gamespace;

public abstract class StatusModifier extends GameObject{
	
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
