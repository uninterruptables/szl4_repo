package team.uninter.mordorq.gamespace;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import team.uninter.mordorq.utils.GameUtil;

@SuppressWarnings("all")
public class Animator implements Runnable {

	private static final Logger logger = Logger.getLogger(Animator.class);
	private Scene scene;
	private List<Tower> towers;
	private List<? extends Controlable> enemies;

	public Animator(Scene scene, List<Tower> towers, List<EnemyTroop> enemies) {
		this.scene = scene;
		this.towers = towers;
		this.enemies = enemies;
	}

	public Animator(Scene scene) {
		this.scene = scene;
		towers = scene.getTowers();
		enemies = scene.getEnemies();
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
					logger.debug(" Ctrl.: enemy as ~ h: " + et.getHealth() + " at ( " + et.getX() + "," + et.getY() + " )");
				}
				else {
					removeable.add(enemy);
					EnemyTroop et = (EnemyTroop) enemy;
					logger.debug(" Rmvd.: enemy as ~ h: " + et.getHealth() + " at ( " + et.getX() + "," + et.getY() + " )");
				}
			}
			// to prevent ConcurrentModificationException
			scene.getEnemies().removeAll(removeable);

			if (enemies.isEmpty()) {
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
		for (Tower tower : towers) {
			FogStatus fogStat = new FogStatus();
			fogStat.apply(tower);
		}
	}

	public void add(Tower tower) {
		this.towers.add(tower);
	}
}
