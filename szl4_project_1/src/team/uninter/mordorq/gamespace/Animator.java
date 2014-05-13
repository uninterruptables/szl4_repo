package team.uninter.mordorq.gamespace;

import java.util.ArrayList;
import java.util.List;

import team.uninter.mordorq.utils.GameUtil;

@SuppressWarnings("all")
public class Animator implements Runnable {

	private Scene scene;

	public Animator(Scene scene) {
		this.scene = scene;
	}

	@Override
	public void run() {
		run(1);
	}

	public void run(int n) {
		for (int i = 0; i < n; i++) {
			List<Controlable> removeable = new ArrayList<Controlable>();

			for (Controlable enemy : scene.getEnemies()) {
				if (enemy.isActive()) {
					EnemyTroop et = (EnemyTroop) enemy;
					et.controlIt();
				}
				else {
					removeable.add(enemy);
					EnemyTroop et = (EnemyTroop) enemy;
				}
			}

			for (Controlable troop : removeable) {
				scene.rewardUser(((EnemyTroop) troop).getRewardMana());
			}
			scene.getEnemies().removeAll(removeable);

			if (scene.getEnemies().isEmpty()) {
				scene.nextRound();
			}
			if (Math.random() * 100 - 2.0 <= 0) {
				fog();
			}
			for (Controlable tower : scene.getTowers()) {
				if (tower.isActive()) {
					tower.controlIt();
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
