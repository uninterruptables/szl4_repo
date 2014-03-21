package team.uninter.mordorq.gamespace;

public interface TargetPublisher {

	void attach(TargetSubscriber subscriber);
	void detach(TargetSubscriber subscriber);
	void notifyAllWith(EnemyTroop troop);
	boolean contains(EnemyTroop troop);
	EnemyTroop getTarget();
}
