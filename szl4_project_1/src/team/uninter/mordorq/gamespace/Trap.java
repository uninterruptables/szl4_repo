package team.uninter.mordorq.gamespace;

import java.util.ArrayList;

@SuppressWarnings("serial")
abstract public class Trap extends InjectionTarget{
	
	//generic class used to handle trap objects, that can be placed on roads.
	//They contain a number of different effects they can apply on enemy troops.

//	ArrayList<StatusModifier> effects;
	StatusModifier effects;
	protected Trap() {
		super();
		System.out.println("Trap() called");
//		effects=new ArrayList<>();
		System.out.println("Trap() returned");
	}
	protected Trap(int x, int y) {
		super(x, y);
		System.out.println("Trap(Int, Int) called");
//		effects=new ArrayList<>();
		System.out.println("Trap(Int, Int) returned");
	}

	//method used to add additional effects to the trap (mainly via runes)
	public void addEffect(StatusModifier newStatus) {
		System.out.println("Trap.addEffect(StatusModifier) called");
//		effects.add(newStatus);
		this.effects = newStatus;
		System.out.println("Trap.addEffect(StatusModifier) returned");
	}
	//method called, when it affects an enemy
	public void affect(EnemyTroop enemyTroop)
	{
//		System.out.println("Trap.affect(EnemyTroop) called");
//		for(StatusModifier sm : effects){
//			sm.apply(enemyTroop);
//		}
//		System.out.println("Trap.affect(EnemyTroop) returned");
		this.effects.apply(enemyTroop);
		
	}
	//method that helps to determine whether a certain injectable can be injected on it, or not
	public final boolean canInject(Injectable injectable) {
		return injectable.canInjectOn(this);
	}
	
	//during the cast of a terrainGrid
	public final void castOn(TerrainGrid grid) {
		//TODO:
	}
	
	//checks, wheter it can be casted on a grid or not
	public final boolean canCastOn(TerrainGrid grid) {
		return grid.isAvailableFor(this);
	}
	
	//injects an injectable
	public final void inject(Injectable inject)
	{
		System.out.println("Trap.Inject(Injectable) returned");
		inject.injectOn(this);
		this.remainingRunePlace--;
		System.out.println("Trap.Inject(Injectable) returned");
	}
	
	public StatusModifier getEffect(){
		return this.effects;
	}

}
