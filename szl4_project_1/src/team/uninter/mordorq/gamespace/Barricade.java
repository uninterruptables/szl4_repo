package team.uninter.mordorq.gamespace;
import java.io.IOException;

import team.uninter.mordorq.skeleton.Skeleton;
import team.uninter.mordorq.utils.GameConstants;
import team.uninter.mordorq.ApplicationContext;
import team.uninter.mordorq.gamespace.Tower.Missile;

public class Barricade extends Casted implements Vulnerable {
	int health;
	RoadGrid currentGrid;
	
	//Class representing objects, that the player can place on the road, in order to block the enemyTroops path.
	//As a descendant of the vunerable, it has a certain amount of health, that is decreased by the amount of
	//damage that certain enemy type deals on it, during the interractWith method.

	public Barricade() {
		super();
		health = GameConstants.BARRICADE_HEALTH;
		System.out.println("Barricade() called");
		System.out.println("Barricade() returned");
	}
	
	public Barricade(int x, int y) {
		super(x, y);
		health = GameConstants.BARRICADE_HEALTH;
		System.out.println("Barricade(Int, Int) called");
		System.out.println("Barricade(Int, Int) returned");
	}
	@Override
	public void interactWith(EnemyTroop troop)
	{
//		System.out.println("Barricade.interactWith(EnemyTroop) called");
//		try {
//		health=health-troop.getDamage();
//		String response="";
//		while(response.equals("y")||response.equals("n"))
//		{
//				response=((Skeleton)ApplicationContext.lookup("skeleton")).getInput("Is health below zero? (y, n)");
//		}
//		if(response.equals("y")) health=0;
//		else health=1;
//		if(health<=0) currentGrid.remove(this);
//		} catch (IOException e) {
//			System.out.println("Barricade.interactWith(EnemyTroop) returned");
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		this.setHealth(this.health - troop.getDamage());
		if(health <= 0 && currentGrid != null){
			currentGrid.remove();
			this.currentGrid = null;
		}
//		System.out.println("Barricade.interactWith(EnemyTroop) returned");
	}

	@Override
	public void interactWith(Missile missile) {
		
	}
	
	public void setHealth(int health)
	{
		this.health = health;
	}
	
	public void setCurrentGrid(RoadGrid grid){
		this.currentGrid = grid;
	}
	
	@Override
	public void castOn(TerrainGrid grid) {
		System.out.println("Barricade.castOn(GameObject) called");
		System.out.println("Barricade.castOn(GameObject) returned");
	}

	@Override
	public final boolean canCastOn(TerrainGrid grid)
	{
		System.out.println("Barricade.canCastOn(TerrainGrid) called");
		if(grid.isAvailableFor(this))
		{
			System.out.println("Barricade.canCastOn(TerrainGrid) returned");
			return true;
		}
		else
		{
			System.out.println("Barricade.canCastOn(TerrainGrid) returned");
			return false;
		}
		
	}
}
