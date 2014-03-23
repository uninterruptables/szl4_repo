package team.uninter.mordorq.gamespace;

public class Nazgul extends Magic{

	public Nazgul() {
		super();
		System.out.println("Nazgul() called");
		System.out.println("Nazgul() returned");
	}
	public Nazgul(int manaCost) {
		super(manaCost);
		System.out.println("Nazgul(Int) called");
		System.out.println("Nazgul(Int) returned");
	}
	
	public Nazgul(int x, int y) {
		super(x, y);
		System.out.println("Nazgul(Int, Int) called");
		System.out.println("Nazgul(Int, Int) returned");
	}
	public Nazgul(int x, int y, int manaCost) {
		super(x, y, manaCost);
		System.out.println("Nazgul(Int, Int, Int) called");
		System.out.println("Nazgul(Int, Int, Int) returned");
	}
	@Override
	public void castOn(GameObject object) {
		System.out.println("Nazgul.castOn(GameObject) called");
		System.out.println("Nazgul.castOn(GameObject) returned");
	}

}
