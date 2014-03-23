package team.uninter.mordorq.gamespace;

import java.util.ArrayList;

@SuppressWarnings("serial")
abstract public class Trap extends InjectionTarget{

	ArrayList<StatusModifier> effects;
	protected Trap(int x, int y, int manacost) {
		super(x, y, manacost);
		System.out.println("Trap(Int, Int, Int) called");
		System.out.println("Trap(Int, Int, Int) returned");
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
	
	public boolean canInject(Injectable inj)
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

}
