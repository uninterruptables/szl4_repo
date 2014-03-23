package team.uninter.mordorq.gamespace;
import team.uninter.mordorq.skeleton.Skeleton;
import team.uninter.mordorq.ApplicationContext;
import team.uninter.mordorq.gamespace.Tower.Missile;

public class Barricade extends Casted implements Vulnerable {
	int health;
	RoadGrid currentGrid;

	public Barricade() {
		super();
		health=0;
		System.out.println("Barricade() called");
		System.out.println("Barricade() returned");
	}
	public Barricade(int manaCost) {
		super(manaCost);
		health=0;
		System.out.println("Barricade(Int) called");
		System.out.println("Barricade(Int) returned");
	}
	
	public Barricade(int x, int y) {
		super(x, y);
		health=0;
		System.out.println("Barricade(Int, Int) called");
		System.out.println("Barricade(Int, Int) returned");
	}
	public Barricade(int x, int y, int manacost) {
		super(x, y, manacost);
		health=0;
		System.out.println("Barricade(Int, Int, Int) called");
		System.out.println("Barricade(Int, Int, Int) returned");
	}
	@Override
	public void interactWith(EnemyTroop troop)
	{
		System.out.println("Barricade.interactWith(EnemyTroop) called");
		setHealth(-troop.getDamage(this));
		String response="";
		while(response.equals("y")||response.equals("n"))
		{
			response=((Skeleton)ApplicationContext.lookup("skeleton")).getInput("Is health below zero? (y, n)");
		}
		if(response.equals("y")) health=0;
		else health=1;
		if(health<=0) currentGrid.remove(this);
		System.out.println("Barricade.interactWith(EnemyTroop) returned");
	}

	@Override
	public void interactWith(Missile missile) {
		
	}
	
	public void setHealth(int healthDiff)
	{
		health+=healthDiff;
	}
	@Override
	public void castOn(GameObject object) {
		System.out.println("Barricade.castOn(GameObject) called");
		System.out.println("Barricade.castOn(GameObject) returned");
	}
}