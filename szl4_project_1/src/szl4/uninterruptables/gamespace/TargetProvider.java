package szl4.uninterruptables.gamespace;

public interface TargetProvider {

	void attach(TargetSubscriber subscriber);
	void detach(TargetSubscriber subscriber);
	void notifySubscribers();
}
