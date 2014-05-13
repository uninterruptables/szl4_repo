package team.uninter.mordorq.gamespace;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import team.uninter.mordorq.utils.GameUtil;

@SuppressWarnings("all")
public class Animator implements Runnable {

	private static final Logger logger = Logger.getLogger(Animator.class);
	private Scene scene;

	public Animator(Scene scene) {
		this.scene = scene;
	}

	@Override
	public void run() {
		run(1);
	}

	public void run(int n) {
		logger.debug(" scene: " + scene.toString());
		for (int i = 0; i < n; i++) {
			List<Controlable> removeable = new ArrayList<Controlable>();

			for (Controlable enemy : scene.getEnemies()) {
				if (enemy.isActive()) {
					EnemyTroop et = (EnemyTroop) enemy;
					et.controlIt();
					logger.debug(" Ctrl.: enemy as ~ h: " + et.getHealth() + " at ( " + et.getX() + "," + et.getY() + " )");
				}
				else {
					removeable.add(enemy);
					EnemyTroop et = (EnemyTroop) enemy;
					logger.debug(" Rmvd.: enemy as ~ h: " + et.getHealth() + " at ( " + et.getX() + "," + et.getY() + " )");
				}
			}
			// to prevent ConcurrentModificationException
			// scene.getEnemies().removeAll(removeable);
			for(Controlable troop : removeable){
				scene.rewardUser(((EnemyTroop)troop).getRewardMana());
			}
			scene.getEnemies().removeAll(removeable);

			if (scene.getEnemies().isEmpty()) {
				// scene.endRound();
				scene.nextRound();
				logger.debug(" in Animator.run(n): round " + scene.getRoundNumber() + " ended in " + GameUtil.fetchFrom(this.toString(), "Animator"));
			}
			if (Math.random() * 100 - 2.0 <= 0) {
				fog();
				logger.debug(" in Animator.run(n): fog activated");
			}
			for (Controlable tower : scene.getTowers()) {
				if (tower.isActive()) {
					tower.controlIt();
					logger.debug(" in Animator.run(n): " + tower.toString() + " was controlled in " + this.toString());
				}
			}
			scene.repaint();
		}
	}

	private void fog() {
		for (Tower tower : scene.getTowers()) {
			FogStatus fogStat = new FogStatus();
			fogStat.apply(tower);
		}
	}

	@Override
	public String toString() {
		return GameUtil.slicePackagesFrom(super.toString());
	}
}
