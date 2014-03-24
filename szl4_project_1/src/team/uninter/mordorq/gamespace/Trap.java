package team.uninter.mordorq.gamespace;

import java.util.ArrayList;

@SuppressWarnings("serial")
abstract public class Trap extends InjectionTarget{
	
	//generic class used to handle trap objects, that can be placed on roads.
	//They contain a number of different effects they can apply on enemy troops.

	ArrayList<StatusModifier> effects;
	protected Trap() {
		super();
		System.out.println("Trap() called");
		effects=new ArrayList<>();
		System.out.println("Trap() returned");
	}
	protected Trap(int x, int y) {
		super(x, y);
		System.out.println("Trap(Int, Int) called");
		effects=new ArrayList<>();
		System.out.println("Trap(Int, Int) returned");
	}

	//method used to add additional effects to the trap (mainly via runes)
	public void addEffect(StatusModifier newStatus) {
		System.out.println("Trap.addEffect(StatusModifier) called");
		effects.add(newStatus);
		System.out.println("Trap.addEffect(StatusModifier) returned");
	}
	//method called, when it affects an enemy
	public void affect(EnemyTroop enemyTroop)
	{
		System.out.println("Trap.affect(EnemyTroop) called");
		System.out.println("Trap.affect(EnemyTroop) returned");
		
	}
	//method that helps to determine whether a certain injectable can be injected on it, or not
	public final boolean canInject(Injectable inj)
	{
		System.out.println("Trap.canInject(Injectable) : bool called");
		if(inj.canInjectOn(this))
		{
			System.out.println("Trap.canInject(Injectable) : bool returned");
			return true;
		}
		else
		{
			System.out.println("Trap.canInject(Injectable) : bool returned");
			return false;
		}
	}
	//during the cast of a terrainGrid
	public final void castOn(TerrainGrid grid)
	{
		System.out.println("Trap.castOn(TerrainGrid) returned");
		System.out.println("Trap.castOn(TerrainGrid) returned");
	}
	//checks, wheter it can be casted on a grid or not
	public final boolean canCastOn(TerrainGrid grid)
	{
		System.out.println("Trap.canCastOn(TerrainGrid) called");
		if(grid.isAvailableFor(this))
		{
			System.out.println("Trap.canCastOn(TerrainGrid) returned");
			return true;
		}
		else
		{
			System.out.println("Trap.canCastOn(TerrainGrid) returned");
			return false;
		}
		
	}
	//injects an injectable
	public final void inject(Injectable inject)
	{
		System.out.println("Trap.Inject(Injectable) returned");
		inject.injectOn(this);
		System.out.println("Trap.Inject(Injectable) returned");
	}

}
