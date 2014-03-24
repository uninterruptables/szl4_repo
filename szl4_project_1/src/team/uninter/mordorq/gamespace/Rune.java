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
	
	public boolean canCastOn(TerrainGrid grid)
	{
		System.out.println("Rune.canCastOn(TerrainGrid) called");
		if(grid.getInjectionTarget()!=null)
		{
			boolean ret=grid.getInjectionTarget().canInject(this);
			System.out.println("Rune.canCastOn(TerrainGrid) returned");
			return ret;
		}
		else
			{
				System.out.println("Rune.canCastOn(TerrainGrid) returned");
				return false;
			}
	}
	
	public final void castOn(TerrainGrid grid)
	{
		System.out.println("Rune.castOn(object) called");
		if(grid.getInjectionTarget()!=null)
		{
			if(grid.getInjectionTarget().canInject(this))
			{	
				grid.getInjectionTarget().inject(this);
			}
		}
		System.out.println("Rune.castOn(object) returned");
	}

}
