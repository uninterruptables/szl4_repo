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

	public void addEffect(StatusModifier newStatus) {
		System.out.println("Trap.addEffect(StatusModifier) called");
		effects.add(newStatus);
		System.out.println("Trap.addEffect(StatusModifier) returned");
	}
	
	public void affect(EnemyTroop enemyTroop)
	{
		System.out.println("Trap.affect(EnemyTroop) called");
		System.out.println("Trap.affect(EnemyTroop) returned");
		
	}
	
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
	
	public final void castOn(TerrainGrid grid)
	{
		System.out.println("Trap.castOn(TerrainGrid) returned");
		System.out.println("Trap.castOn(TerrainGrid) returned");
	}
	
	public final boolean canCastOn(TerrainGrid grid)
	{
		return false;
		
	}
	
	public final void inject(Injectable inject)
	{
		System.out.println("Trap.Inject(Injectable) returned");
		inject.injectOn(this);
		System.out.println("Trap.Inject(Injectable) returned");
	}

}
