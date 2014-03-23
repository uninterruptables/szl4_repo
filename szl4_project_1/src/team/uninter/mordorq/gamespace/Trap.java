package team.uninter.mordorq.gamespace;

import java.util.ArrayList;

@SuppressWarnings("serial")
abstract public class Trap extends InjectionTarget{

	ArrayList<StatusModifier> effects;
	public Trap() {
		super();
		System.out.println("Trap() called");
		System.out.println("Trap() returned");
	}
	public Trap(int x, int y) {
		super(x, y);
		System.out.println("Trap(Int, Int) called");
		System.out.println("Trap(Int, Int) returned");
	}

	public void addEffect(StatusModifier newStatus) {
		System.out.println("Trap.addEffect(StatusModifier) called");
		System.out.println("Trap.addEffect(StatusModifier) returned");
	}
	
	public void affect(EnemyTroop enemyTroop)
	{
		System.out.println("Trap.affect(EnemyTroop) called");
		System.out.println("Trap.affect(EnemyTroop) returned");
		
	}
	
	public final void injectOn(Injectable inj)
	{
		System.out.println("Trap.injectOn(Injectable) : bool called");
		if(inj.canInjectOn(this))
		{
			System.out.println("Trap.injectOn(Injectable) : bool returned");
		}
		else
		{
			System.out.println("Trap.injectOn(Injectable) : bool returned");
		}
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

}
