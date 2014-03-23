package team.uninter.mordorq.gamespace;

public class Elf extends EnemyTroop {

	
	protected Elf(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	protected int mana;
	public void setReward(int mana)
	{
		System.out.println("EnemyTroop.setReward() called");
		
		System.out.println("EnemyTroop.setReward() returned");
	}
	public int getReward()
	{
		System.out.println("EnemyTroop.getReward() called");
		System.out.println("EnemyTroop.getReward() returned");
		return mana;
		
	}
}
