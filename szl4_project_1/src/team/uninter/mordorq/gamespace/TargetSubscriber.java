package team.uninter.mordorq.gamespace;

public interface TargetSubscriber {
	void notifyWith(EnemyTroop target);
	void attach(TargetPublisher publisher);
}
