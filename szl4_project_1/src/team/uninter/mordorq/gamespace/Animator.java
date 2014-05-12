package team.uninter.mordorq.gamespace;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

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
		logger.debug("in Animator.run() for " + this.toString());
		run(1);
	}

	public void run(int n) {
		logger.debug("in Animator.run(n) for " + this.toString());
		for (int i = 0; i < n; i++) {
			List<Controlable> removeable = new ArrayList<Controlable>();

			for (Controlable enemy : scene.getEnemies()) {
				if (enemy.isActive()) {
					enemy.controlIt();
					logger.debug("in Animator.run(n): " + enemy.toString() + " was controlled in " + this.toString());
				}
				else {
					removeable.add(enemy);
					logger.debug("in Animator.run(n): " + enemy.toString() + " was nominated for removal in " + this.toString());
				}
			}
			// to prevent ConcurrentModificationException
			scene.getEnemies().removeAll(removeable);

			if (enemies.isEmpty()) {
//				scene.endRound();
				scene.nextRound();
				logger.debug("in Animator.run(n): round " + scene.getRoundNumber() + " ended in " + this.toString());
			}
			if (Math.random() * 100 - 2.0 <= 0) {
				fog();
				logger.debug("in Animator.run(n): fog activated");
			}
			for (Controlable tower : scene.getTowers()) {
				if (tower.isActive()) {
					tower.controlIt();
					logger.debug("in Animator.run(n): " + tower.toString() + " was controlled in " + this.toString());
				}
			}
			scene.repaint();
			logger.debug("in Animator.run(n): scene.repaint called in " + this.toString());
		}
	}

	private void fog() {
		for (Tower tower : towers) {
			FogStatus fogStat = new FogStatus();
			fogStat.apply(tower);
			logger.debug("in Animator.fog: " + tower.toString() + " was affected by " + fogStat.toString() + " in " + this.toString());
		}
	}

	public void add(Tower tower) {
		this.towers.add(tower);
		logger.debug("in Animator.add: " + tower.toString() + " was added to " + this.toString());
	}

}
