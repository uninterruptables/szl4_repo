package team.uninter.mordorq.gamespace;

public abstract class Rune extends Casted implements Injectable {

	protected Rune() {
		super();
		System.out.println("Rune() called");
		System.out.println("Rune() returned");
	}
	
	protected Rune(int x, int y) {
		super(x, y);
		System.out.println("Rune(Int, Int) called");
		System.out.println("Rune(Int, Int) returned");
	}
	
	protected boolean canCastOn(TerrainGrid grid)
	{
		System.out.println("Rune.canCastOn(TerrainGrid) called");
		boolean ret=grid.isAvailableFor(this);
		System.out.println("Rune.canCastOn(TerrainGrid) returned");
		return ret;
	}
	
	public final void castOn(TerrainGrid grid)
	{
		System.out.println("Rune.castOn(object) called");
		if(grid.isAvailableFor(this))
		{
			
		}
		System.out.println("Rune.castOn(object) returned");
	}

}
