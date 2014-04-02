package team.uninter.mordorq.gamespace;

import java.util.ArrayList;
import java.util.List;

public class Animator implements Runnable{

	private Scene scene;
	private List<? extends Controlable> towers;
	private List<? extends Controlable> enemies;
	
	public Animator(Scene scene, List<Tower> towers, List<EnemyTroop> enemies){
		// TODO remove sysout
		System.out.println("Animator.Animator(Scene, List<Controlable>, List<Controlable>) called");
		this.scene = scene;
		this.towers = towers;
		this.enemies = enemies;
		System.out.println("Animator.Animator(Scene, List<Tower>, List<EnemyTroop>) returned");
	}
	
	public Animator(Scene scene){
		// TODO remove sysout
		System.out.println("Animator.Animator(Scene) called");
		this.scene = scene;
		towers = scene.getTowers();
		enemies = new ArrayList<EnemyTroop>();
		System.out.println("Animator.Animator(Scene) returned");
	}
	
	@Override
	public void run() {
		// TODO remove sysout
		System.out.println("Animator run() called");
		for(Controlable enemy : scene.getEnemies()){
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
		for(Controlable tower : scene.getTowers()){
			if(tower.isActive()){
				tower.controlIt();
			}
		}
		scene.repaint();
		System.out.println("Animator run() returned");
	}
	
	public void run(int n) {
		for(int i = 0; i < n; i++){
			for(Controlable enemy : scene.getEnemies()){
				if(enemy.isActive()){
					enemy.controlIt();
				}
				else{
					scene.getEnemies().remove(enemy);
				}
			}
			if(enemies.isEmpty()){
				scene.endRound();
			}
			for(Controlable tower : scene.getTowers()){
				if(tower.isActive()){
					tower.controlIt();
				}
			}
			scene.repaint();
		}	
	}
	


}
