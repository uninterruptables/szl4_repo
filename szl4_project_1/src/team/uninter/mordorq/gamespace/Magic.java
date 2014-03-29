package team.uninter.mordorq.gamespace;

import java.util.ArrayList;

public abstract class Magic extends Casted{
	
	//Class used to handle different global spells. It contains a list of status modifiers, that
	//can be applied on the enemy units.
	//It's manacost can be asked, for user input check.
	int manaCost;
	protected ArrayList<StatusModifier> effects;
	protected Magic() {
		super();
		System.out.println("Magic() called");
		effects=new ArrayList<StatusModifier>();
		System.out.println("Magic() returned");
	}
	protected Magic(int x, int y) {
		super(x, y);
		System.out.println("Magic(Int, Int) called");
		effects=new ArrayList<StatusModifier>();
		System.out.println("Magic(Int, Int) returned");
	}

	public ArrayList<StatusModifier> getStatusModifiers()
	{
		System.out.println("Magic.getStatusModifiers() : ArrayList called");
		System.out.println("Magic.getStatusModifiers() : ArrayList returned");
		return effects;
	}
	
	public final void castOn(TerrainGrid grid)
	{
		System.out.println("Magic.castOn(GameObject) returned");
		System.out.println("Magic.castOn(GameObject) returned");
	}
	
	public final boolean canCastOn(TerrainGrid grid)
	{
		System.out.println("Magic.canCastOn(GameObject) returned");
		System.out.println("Magic.canCastOn(GameObject) returned");
		return true;
		
	}
	
	
	

}
