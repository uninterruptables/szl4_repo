package team.uninter.mordorq.gamespace;

public abstract class Rune extends Casted implements Injectable {

	public Rune() {
		super();
		System.out.println("Rune() called");
		System.out.println("Rune() returned");
	}
	
	public Rune(int x, int y) {
		super(x, y);
		System.out.println("Rune(Int, Int) called");
		System.out.println("Rune(Int, Int) returned");
	}
	
	public boolean canCastOn(TerrainGrid grid)
	{
		System.out.println("Rune.canCastOn(TerrainGrid) called");
		grid.isAvailableFor(this);
		System.out.println("Rune.canCastOn(TerrainGrid) returned");
		return false;
	}
	
	public final void castOn(TerrainGrid grid)
	{
		System.out.println("Rune.castOn(object) called");
		System.out.println("Rune.castOn(object) returned");
	}

}
