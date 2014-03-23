package team.uninter.mordorq.gamespace;

import java.util.ArrayList;

public abstract class Magic extends Casted{
	int manaCost;
	ArrayList<StatusModifier> effects;
	public Magic() {
		super();
		System.out.println("Magic() called");
		System.out.println("Magic() returned");
	}
	public Magic(int x, int y) {
		super(x, y);
		System.out.println("Magic(Int, Int) called");
		System.out.println("Magic(Int, Int) returned");
	}

	public int getManaCost()
	{
		System.out.println("Magic.getManaCost() : Int called");
		System.out.println("Magic.getManaCost() : Int returned");
		return manaCost;
	}
	public ArrayList<StatusModifier> getStatusModifiers()
	{
		System.out.println("Magic.getStatusModifiers() : ArrayList called");
		System.out.println("Magic.getStatusModifiers() : ArrayList returned");
		return effects;
	}
	
	
	

}
