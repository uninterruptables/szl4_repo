package team.uninter.mordorq.gamespace;

public class Nazgul extends Magic{

	public Nazgul() {
		super();
		System.out.println("Nazgul() called");
		System.out.println("Nazgul() returned");
	}
	public Nazgul(int x, int y) {
		super(x, y);
		System.out.println("Nazgul(Int, Int) called");
		System.out.println("Nazgul(Int, Int) returned");
	}
	@Override
	public void castOn(GameObject object) {
		System.out.println("Nazgul.castOn(GameObject) called");
		System.out.println("Nazgul.castOn(GameObject) returned");
	}

}
