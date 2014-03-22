package team.uninter.mordorq.gamespace;

import java.util.ArrayList;
import java.util.List;

public class Animator implements Runnable{

	private Scene scene;
	private List<Tower> towers;
	private List<EnemyTroop> enemies;
	
	public Animator(Scene scene, List<Tower> towers, List<EnemyTroop> enemies){
		// TODO remove sysout
		System.out.println("Animator.Animator(Scene, List<Tower>, List<EnemyTroop>) called");
		this.scene = scene;
		this.towers = towers;
		this.enemies = enemies;
		System.out.println("Animator.Animator(Scene, List<Tower>, List<EnemyTroop>) returned");
	}
	
	public Animator(Scene scene){
		// TODO remove sysout
		System.out.println("Animator.Animator(Scene) called");
		this.scene = scene;
		towers = new ArrayList<Tower>();
		enemies = new ArrayList<EnemyTroop>();
		System.out.println("Animator.Animator(Scene) returned");
	}
	
	@Override
	public void run() {
		// TODO remove sysout
		System.out.println("Animator run() called");
		for(EnemyTroop enemy : enemies){
			if(enemy.isActive()){
				enemy.controlIt();
			}
			else{
				enemies.remove(enemy);
			}
		}
		if(enemies.isEmpty()){
			scene.endRound();
		}
		for(Tower tower : towers){
			if(tower.isActive()){
				tower.controlIt();
			}
		}
		scene.repaint();
		System.out.println("Animator run() returned");
	}
	


}
