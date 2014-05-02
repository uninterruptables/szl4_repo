package team.uninter.mordorq.gamespace;


@SuppressWarnings("serial")
abstract public class Casted extends GameObject {

	//class used to hold together different objects the player will be able to cast on the map.
	//All of them have manaCost. They two important methods are castOn (determines what happens once the object is
	//casted) and canCastOn (returns, if the given object can be casted on a terrainGrid. Good, for user feedback mostly)
	
	protected int manaCost;
	
	protected Casted() {
		super();
	}
	
	protected Casted(int x, int y) {
		super(x, y);
	}
	
	protected Casted(int x, int y, int manaCost) {
		super(x, y);
		this.manaCost = manaCost;
	}
	
	abstract public void castOn(TerrainGrid grid);
	
	public int getCost(){
		return manaCost;
	}
	
	//TODO:
	public void setRedImage() {}
	public void setNormalImage() {}
	
	abstract public boolean canCastOn(TerrainGrid grid);
}
