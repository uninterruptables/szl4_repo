package team.uninter.mordorq.gamespace;

import java.util.ArrayList;
import java.util.List;
import java.math.*;

@SuppressWarnings("all")
public class Animator implements Runnable{

	private Scene scene;
	private List<Tower> towers;
	private List<? extends Controlable> enemies;
	
	public Animator(Scene scene, List<Tower> towers, List<EnemyTroop> enemies){
		this.scene = scene;
		this.towers = towers;
		this.enemies = enemies;
	}
	
	public Animator(Scene scene){
		this.scene = scene;
		towers = scene.getTowers();
		enemies = scene.getEnemies();
	}
	
	@Override
	public void run() {
		run(1);
	}
	
	public void run(int n) {
		for(int i = 0; i < n; i++){
			List<Controlable> removeable = new ArrayList<Controlable>();
			
			for(Controlable enemy : scene.getEnemies()){
				if(enemy.isActive()){
					enemy.controlIt();
				}
				else{
					removeable.add(enemy);
				}
			}
			//to prevent ConcurrentModificationException 
			scene.getEnemies().removeAll(removeable);

			if(enemies.isEmpty()){
				scene.endRound();
			}
			if(Math.random()*100 - 2.0 <= 0) fog();
			for(Controlable tower : scene.getTowers()){
				if(tower.isActive()){
					tower.controlIt();
				}
			}
			scene.repaint();
		}	
	}
	
	private void fog(){
		for(Tower tower : (List<Tower>)towers)
			new FogStatus().apply(tower);
	}
	
	public void add(Tower tower){
		this.towers.add(tower);
	}

}
