package team.uninter.mordorq.gamespace;

public abstract class Rune extends Casted implements Injectable {

	public Rune(int manaCost) {
		super(manaCost);
		System.out.println("Rune(Int) called");
		System.out.println("Rune(Int) returned");
	}
	
	public boolean canCastOn(TerrainGrid grid)
	{
		System.out.println("Rune.canCastOn(TerrainGrid) called");
		grid.isAvailableFor(this);
		System.out.println("Rune.canCastOn(TerrainGrid) returned");
		return false;
	}

}
